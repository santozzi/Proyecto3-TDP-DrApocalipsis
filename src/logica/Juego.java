package logica;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import entidades.Entidad;
import entidades.personajes.jugador.Jugador;
import logica.contabilidad.Contabilidad;
import niveles.Nivel;
import niveles.Nivel1;
import niveles.Nivel2;
import niveles.Nivel3;
import observador.IObservado;
import observador.IObservador;
import reproductor_de_audio.Ambiente;
import reproductor_de_audio.Musica;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import GUI.FrmScore;

public class Juego implements IObservado {
	protected Nivel nivel;

	protected List<IObservador> observadores;
	public static final int ANCHO_DE_COMBATE=444;
	public static final int ALTO_DE_COMBATE=619;
	public static final int DECORADO_IZQUIERDO=184;
	public static final int DECORADO_DERECHO=184;
	protected HiloSecundario hiloSecundario;
	protected Contabilidad score;
	protected Point limite;
	protected static final int LATENCIA_MINIMA=5;
	protected static final int LATENCIA_MAXIMA=10;
	protected Jugador jugador;
	protected boolean finDeLaTanda;
	protected int nivelActual;
	protected boolean ifinalizarTanda;
	protected boolean finalizaBoss;
	protected static Logger Logger;
	protected boolean jugadorVive;


	public Juego() {
		jugadorVive= false;
		if(Logger==null) {
			Logger = Logger.getLogger(Juego.class.getName());
			Handler hnd = new ConsoleHandler();

			hnd.setLevel(Level.FINE);
			Logger.addHandler(hnd);
			Logger.setLevel(Level.FINE);
			Logger rootLogger = Logger.getParent();
			for(Handler h: rootLogger.getHandlers()) {
				h.setLevel(Level.OFF);
			}
			
		}
		
		this.nivelActual = 1;
		finalizaBoss= false;
		this.score = new Contabilidad();
		observadores = new LinkedList<IObservador>();
		//hiloSecundario = new HiloSecundario(this);
		hiloSecundario = new HiloSecundario(this);
		//  nivel = new Nivel1(this);
		this.limite = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
		jugador = new Jugador(this);
		ifinalizarTanda= false;
		//hiloSecundario.stop();
		Logger.fine("Iniciando Hilo secundario");
		hiloSecundario.start();
		if(hiloSecundario.isAlive()) {
			Logger.fine("Hilo secundario iniciado con exito");
		}else
			Logger.warning("Error al iniciar hilo secundario");
		
	}
	public void finalizarJuego() {
		hiloSecundario.terminarEjecucion();
		Logger.fine("Fin del juego");
		Musica.parar();
	}
	
	
	public void cargarJugador() {
		jugadorVive= true;
		agregarAEntidadesParaAgregar(jugador);
		
	}

	public Point getLimite() {
		return this.limite;
	}

	public void cargarNivel() {
		//Nivel[] niveles = new Nivel[3];

		if(nivelActual==1) {
			Logger.fine("Cargando nivel 1");
			this.nivel = new Nivel1(this);
			
		}else if(nivelActual==2){
			Logger.fine("Cargando nivel 2");
			nivel= new Nivel2(this);
			
		}else if(nivelActual==3){
			Logger.fine("Cargando nivel 3");
			nivel= new Nivel3(this);
			
		}else {
			
			finalizarJuego();
			nivel= null;
		}

		if(nivel!=null) {
			for(Entidad entidad : nivel.primeraTanda()) {
				hiloSecundario.agregarAColaParaAgregar(entidad);
			}
			notificarNivel();
			
			Random random = new Random();
			int randomInt;
			String pista = new String("intro");
			
			randomInt = random.nextInt(3)+1;
			Ambiente.reproducir(pista+randomInt);
			Musica.reproducir("Digadig");
		}
         
	}
	public Jugador getJugador() {
		return this.jugador;
	}
	public void cargarJefe() {
		for(Entidad entidad : nivel.elJefe()) {
			hiloSecundario.agregarAColaParaAgregar(entidad);
		}
		finalizaBoss= true;

	}

	public void agregarItem(String clave,int puntos) {
		score.agregarItem(clave, puntos);
	}
	public void cuarentena() {
		if(nivel!=null) {
		List<Entidad> listaDeInfectados = this.nivel.getColeccionDeInfectados().getListaDeInfectados();
		
			for(Entidad entidad : listaDeInfectados)
				entidad.cambiarEstadoTemporal();
		}
	}
	// pregunto si no quedan mas infectados en el nivel
	public void notificarBajaDeInfectado(Entidad infectado) {
		List<Entidad> listaDeInfectados = this.nivel.getColeccionDeInfectados().getListaDeInfectados();
		//score++;
		listaDeInfectados.remove(infectado);

		if(listaDeInfectados.isEmpty()) {
			
			if(finalizaBoss) {
				Logger.fine("Entrando a la carga del nuevo nivel despues de matar al boss");
				nivelActual++;
				cargarNivel();
				
				Musica.parar();
				Musica.reproducir("Digadig");
				
				finalizaBoss=false;
			}else {
				if(ifinalizarTanda) {
					Logger.fine("Cargando al boss");
					cargarJefe();
					
					Musica.parar();
					Musica.reproducir(new String("poltergeist"));
					Ambiente.reproducir("nil_win");

					ifinalizarTanda=false;

				}else {
					Logger.fine("Finalizando tanda");
					finalizarTanda();
				}
			}
		}
		notificarScore();
	}
	public void finalizarTanda() {
		
		for(Entidad entidad : nivel.segundaTanda()) {
			hiloSecundario.agregarAColaParaAgregar(entidad);
		}
		ifinalizarTanda=true;
		
		Random random = new Random();
		int randomInt;
		String pista = new String("intro");
		
		randomInt = random.nextInt(3)+1;
		Ambiente.reproducir(pista+randomInt);
	
	}
	public List<Entidad> getLista(){
		return hiloSecundario.listaDeRecorrido();
	}



	//--------Agregar y quitar entidades--------------
	public void agregarAEntidadesParaAgregar(Entidad entidad) {
		
		hiloSecundario.agregarAColaParaAgregar(entidad);

	}

	public void agregarAEntidadesParaQuitar(Entidad entidad) {
		hiloSecundario.agregarAColaParaQuitar(entidad);
		notificarQuitarEntidad(entidad);
	}
	//------------------------------------------------



	//--------------Inicio de observado----------------
	//Agrega las entidades en el mapa
	@Override
	public void notificarEntidad(Entidad entidad) {
		for(IObservador obs: observadores)
			obs.updateEntidades(entidad);
	}
	//Actualiza las entidades del mapa
	@Override
	public void actualizarEntidad(Entidad entidad) {
		for(IObservador obs: observadores)
			obs.updateEntidad(entidad);
	}

	@Override
	public void agregarObservador(IObservador obs) {
		observadores.add(obs);

	}
	@Override
	public void eliminarObservador(IObservador obs) {
		observadores.remove(obs);

	}
	@Override
	public void notificarObservadores() {
		for(IObservador obs: observadores)
			obs.update();

	}

	@Override
	public void notificarQuitarEntidad(Entidad entidad) {
		for(IObservador obs: observadores)
			obs.quitarEntidad(entidad);

	}
	@Override
	public void notificarCargaViralDeJugador() {
		for(IObservador obs: observadores)
			obs.updateEnergiaJugador();

	}
	@Override
	public void notificarNivel() {
		for(IObservador obs: observadores) {
			obs.updateNivel(nivel.getImagenIzq(), nivel.getImagenFondo(), nivel.getImagenDer());
		}

	}
	@Override
	public void notificarScore() {
		for(IObservador obs: observadores) {
			obs.updateScore(this.score.getScore());	
		}
	}
	@Override
	public void notificarEstadistica() {
		for(IObservador obs: observadores) {
			obs.updateEstedistica(score.listaDeItems());
		}
		
	}

	//-------------------fin de observado------------------------------
    public boolean isHiloSecundarioCorriendo() {
    	return hiloSecundario.isAlive();
    }
	public void detenerHiloSecundario() {
		hiloSecundario.terminarEjecucion();
		
	}
	
	public boolean isJugadorVive() {
		return jugadorVive;
	}
	public void matarJugador() {
		jugadorVive= false;
	}
}
