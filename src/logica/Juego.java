package logica;

import java.util.LinkedList;
import java.util.List;



import entidades.Entidad;
import entidades.personajes.jugador.Jugador;
import niveles.Nivel;
import niveles.Nivel1;
import observador.IObservado;
import observador.IObservador;

public class Juego implements IObservado{
	protected Nivel nivel;
	protected List<Latencia> entidadesParaRecorido;
	protected List<IObservador> observadores;
	public static final int ANCHO_DE_COMBATE=444;
	public static final int ALTO_DE_COMBATE=619;
	//public static final int DECORADO_IZQUIERDO=62;
	//public static final int DECORADO_DERECHO=62;
	public static final int DECORADO_IZQUIERDO=184;
	public static final int DECORADO_DERECHO=184;


	protected static final int VELOCIDAD_MINIMA=10;
	protected static final int VELOCIDAD_MAXIMA=1000;
	protected Jugador jugador;

	public Juego() {
		jugador = new Jugador(this);
		nivel = new Nivel1(this);
		observadores = new LinkedList<IObservador>();
		entidadesParaRecorido = new LinkedList<Latencia>();
	    agregarEntidad(jugador);	
		hiloRecorredorDeEntidades();

	}
	public void hiloRecorredorDeEntidades() {
		Thread hiloVerificar = new Thread(){

			@Override 
			public void run() {
				while(true) {
					try {
						Thread.sleep(VELOCIDAD_MINIMA);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					notificarObservadores();
					for(Latencia lat : entidadesParaRecorido) {

						Entidad entidad = lat.getEntidad();
						int velocidad = entidad.getVector().getModulo();
						if(velocidad!=0) {
							//velocidad cuanto mas cercano a uno sea mas rapido va a ir

							int latencia = VELOCIDAD_MAXIMA/velocidad;
                          if(entidad!=jugador) {
							if(latencia==lat.getLatencia()) {
								entidad.desplazarse();
								lat.reiniciarLatencia();
							}else {
								lat.incrementarLatencia();
							}
                          }else {
                        	  //si la entidad es jugador 
                          }
							
							


						}
					}
				}


			}

		};
		hiloVerificar.start();

	}
	public void agregarEntidad(Entidad entidad) {
		entidadesParaRecorido.add(new Latencia(entidad));
		
		
	}
	public void cargarNivel() {
		for(Entidad entidad : nivel.primeraTanda()) {
			agregarEntidad(entidad);
		}
	}
	public Jugador getJugador() {
		return this.jugador;
	}
	public List<Latencia> getLista(){
		return entidadesParaRecorido;
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
		for(IObservador obs : observadores) {
			obs.update();
		}

	}
	
}
