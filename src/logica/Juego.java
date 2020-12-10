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

/**
 *Juego 
 *Lógica del programa que implementa a IObservado
 */
public class Juego implements IObservado {
    //Nivel del juego
	protected Nivel nivel;
	//Lista de observadores
	protected List<IObservador> observadores;
	// dimensiones de la parte jugable
	public static final int ANCHO_DE_COMBATE=444;
	public static final int ALTO_DE_COMBATE=619;
	public static final int DECORADO_IZQUIERDO=184;
	public static final int DECORADO_DERECHO=184;
	//---------------------------------------
	//operaciones realizadas en segundo plano
	protected HiloSecundario hiloSecundario;
	//para contabilizar el score
	protected Contabilidad score;
	//Guarda el ultimo punto de la linea virtual
	protected Point limite;
	//Velocidad del juego, tiempo de espera en milisegundos por cilclo
	protected static final int LATENCIA_MINIMA=5;
	//unidad Maxima de velocidad de entidades
	protected static final int LATENCIA_MAXIMA=10;
	//Entidad que controla el usuario
	protected Jugador jugador;
	//determina cuando se termina la primera tanda
	protected boolean finDeLaTanda;
	//devuelve en que nivel se encuentra el usuario
	protected int nivelActual;
	//devuelve cuando la tanda empieza
	protected boolean ifinalizarTanda;
	//devuelve cuando finaliza el boss
	protected boolean finalizaBoss;
	//Para mostrar por consola eventos puntuales
	protected static Logger Logger;
	//Devuelve si el jugador esta o no vivo
	protected boolean jugadorVive;


	@SuppressWarnings("static-access")
	/**
	 * Inicializo atributos
	 */
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
	/**
	 * Para el hilo secundario y la música
	 */
	public void finalizarJuego() {
		hiloSecundario.terminarEjecucion();
		Logger.fine("Fin del juego");
		Musica.parar();
	}
    /**
     * Carga al jugador en la cola de entidades a agregar		
     */
	public void cargarJugador() {
		jugadorVive= true;
		agregarAEntidadesParaAgregar(jugador);
		
	}
    /**
     * Devuelve el punto minimo de la linea virtual
     * @return
     */
	public Point getLimite() {
		return this.limite;
	}
    
	/**
	 * carga el nivel actual, si ya no hay niveles finaliza el juego
	 */
	public void cargarNivel() {
	

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
	/**
	 * Devuelve al jugador
	 * @return
	 */
	public Jugador getJugador() {
		return this.jugador;
	}
	/**
	 * Agrega al jefe a la cola de entidades a agregar
	 */
	public void cargarJefe() {
		for(Entidad entidad : nivel.elJefe()) {
			hiloSecundario.agregarAColaParaAgregar(entidad);
		}
		finalizaBoss= true;

	}

	/**
	 * Agrega un item a la contabilidad
	 * @param clave
	 * @param puntos
	 */
	public void agregarItem(String clave,int puntos) {
		score.agregarItem(clave, puntos);
	}
	
	/**
	 * Detiene a todos los infectados por un determinado tiempo
	 */
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
	/**
	 * Empieza la segunda tanda
	 */
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
	/**
	 * Devuelve la lista clonada de la que utiliza el hilo secundario para recorrer
	 * @return
	 */
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
   
	/**
	 * Devuelve verdadero si el hilo secundario esta corriendo
	 * @return
	 */
	public boolean isHiloSecundarioCorriendo() {
    	return hiloSecundario.isAlive();
    }
	/**
	 * Detiene al hilo secundario
	 */
	public void detenerHiloSecundario() {
		hiloSecundario.terminarEjecucion();
		
	}
	/**
	 * Devuelve verdadero si el jugador esta vivo
	 * @return
	 */
	public boolean isJugadorVive() {
		return jugadorVive;
	}
	/**
	 * Mata al jugador
	 */
	public void matarJugador() {
		jugadorVive= false;
	}
}
