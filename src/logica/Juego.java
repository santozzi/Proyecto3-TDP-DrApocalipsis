package logica;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import entidades.Entidad;
import entidades.personajes.jugador.Jugador;
import logica.contabilidad.Contabilidad;
import niveles.Nivel;
import niveles.Nivel1;
import niveles.Nivel2;
import observador.IObservado;
import observador.IObservador;

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

	
	public Juego() {
		this.nivelActual = 1;
		
		this.score = new Contabilidad();
		observadores = new LinkedList<IObservador>();
		//hiloSecundario = new HiloSecundario(this);
		hiloSecundario = HiloSecundario.getHiloSecundario(this);
      //  nivel = new Nivel1(this);
		this.limite = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
		jugador = new Jugador(this);
		ifinalizarTanda= false;
		hiloSecundario.start();
	}
	public void cargarJugador() {
		agregarAEntidadesParaAgregar(jugador);
	}
	
	/*hilo paralelo
	private void hiloRecorredorDeEntidades() {
		Thread hiloVerificar = new Thread(){
			//  Iterator<Latencia> itLat ;
			@Override 
			public void run() {
				while(true) {
					
					if(entidad.getVector().getPosicion().y<limite.y && entidad.getVector().getPosicion().y<0) {
						if(limite.x >= Juego.ANCHO_DE_COMBATE-entidad.getImagen().getIconWidth()) {
							limite.y = limite.y = entidad.getVector().getPosicion().y-entidad.getImagen().getIconHeight();
							limite.x = 0;
						}else {
							limite.y = limite.y = entidad.getVector().getPosicion().y;
							limite.x += entidad.getImagen().getIconWidth();
						}
					 
					System.out.println("Limite: X=" + limite.x + " ; Y=" + limite.y + " (Juego)");
					
				}
			}
		};
	}
	*/
	public Point getLimite() {
		return this.limite;
	}

	public void cargarNivel() {
		//Nivel[] niveles = new Nivel[3];
		
		if(nivelActual==1) {
			this.nivel = new Nivel1(this);
		}else if(nivelActual==2){
			nivel= new Nivel2(this);
		}else {
			System.out.println("game over");
			nivel= null;
		}

		if(nivel!=null) {
			for(Entidad entidad : nivel.primeraTanda()) {
				hiloSecundario.agregarAColaParaAgregar(entidad);
			}
		notificarNivel();	
		}
		
	}
	public Jugador getJugador() {
		return this.jugador;
	}


    public void agregarItem(String clave,int puntos) {
    	score.agregarItem(clave, puntos);
    }
	public void cuarentena() {
		List<Entidad> listaDeInfectados = this.nivel.getColeccionDeInfectados().getListaDeInfectados();
		
		for(Entidad entidad : listaDeInfectados)
			entidad.cambiarEstadoTemporal();
	}
	// pregunto si no quedan mas infectados en el nivel
	public void notificarBajaDeInfectado(Entidad infectado) {
		List<Entidad> listaDeInfectados = this.nivel.getColeccionDeInfectados().getListaDeInfectados();
		//score++;
		listaDeInfectados.remove(infectado);
		
		if(listaDeInfectados.isEmpty()) {
			if(ifinalizarTanda) {
				nivelActual++;
				System.out.println("Nivel Actual "+nivelActual);
				System.out.println(score);
				ifinalizarTanda=false;
				cargarNivel();
			}else
				finalizarTanda();
		}
			
	}
	public void finalizarTanda() {
       System.out.println("Finalizar tanda");
       //hiloSecundario.terminarEjecucion();
       for(Entidad entidad : nivel.segundaTanda()) {
			hiloSecundario.agregarAColaParaAgregar(entidad);
		}
        ifinalizarTanda=true;
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

	//-------------------fin de observado------------------------------

}
