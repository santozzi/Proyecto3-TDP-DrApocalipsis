package logica;

import java.util.Iterator;
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
	protected List<Entidad> entidadesParaAgregar;
	protected List<Entidad> entidadesParaQuitar;
	

	protected List<IObservador> observadores;
	public static final int ANCHO_DE_COMBATE=444;
	public static final int ALTO_DE_COMBATE=619;
	public static int limite = ALTO_DE_COMBATE*3;
	//public static final int DECORADO_IZQUIERDO=62;
	//public static final int DECORADO_DERECHO=62;
	public static final int DECORADO_IZQUIERDO=184;
	public static final int DECORADO_DERECHO=184;


	protected static final int VELOCIDAD_MINIMA=5;
	protected static final int VELOCIDAD_MAXIMA=1000;
	protected Jugador jugador;

	public Juego() {
		
		observadores = new LinkedList<IObservador>();

		jugador = new Jugador(this);
		nivel = new Nivel1(this);

		entidadesParaRecorido = new LinkedList<Latencia>();
		entidadesParaAgregar = new LinkedList<Entidad>();
		entidadesParaQuitar = new LinkedList<Entidad>();
		
		hiloRecorredorDeEntidades();

	}
	public void cargarJugador() {
		 entidadesParaAgregar.add(jugador) ;	
	}
	public void hiloRecorredorDeEntidades() {
		Thread hiloVerificar = new Thread(){
      //  Iterator<Latencia> itLat ;
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


					Entidad entidad;

                    for(Latencia lat: entidadesParaRecorido){


						 entidad = lat.getEntidad();
						int velocidad = entidad.getVector().getModulo();
						if(velocidad!=0) {
							//velocidad cuanto mas cercano a uno sea mas rapido va a ir

							int latencia = VELOCIDAD_MAXIMA/velocidad;

                          if(entidad!=jugador) {
							if(latencia==lat.getLatencia()) {
							//	System.out.println("entre en el hilo: "+entidad.getVector().getModulo());
								
								if(entidad.getVector().getPosicion().y<limite&&entidad.getVector().getPosicion().y<0) {
									limite = entidad.getVector().getPosicion().y;
								}
							    
								entidad.desplazarse();
								
								actualizarEntidad(entidad);
								lat.reiniciarLatencia();
							}else {
								lat.incrementarLatencia();
								//
							}
                          }




						}
					}
                     for(Entidad entidadA : entidadesParaAgregar) {
                    	 agregarEntidad(entidadA);
                     }
                     entidadesParaAgregar.clear();
                     
                     for(Entidad entidadA : entidadesParaQuitar) {
                    	 agregarEntidad(entidadA);
                     }
                     entidadesParaQuitar.clear();


				}


			}
			public void agregarEntidad(Entidad entidad) {
				entidadesParaRecorido.add(new Latencia(entidad));
				notificarEntidad(entidad);
			

			}
		};
		hiloVerificar.start();

	}


	public void cargarNivel() {
		for(Entidad entidad : nivel.primeraTanda()) {
			entidadesParaAgregar.add(entidad);

		}
	}
	@Override
	public void notificarEntidad(Entidad entidad) {
		for(IObservador obs : observadores) {
			obs.updateEntidades(entidad);
		}

	}
	@Override
	public void actualizarEntidad(Entidad entidad) {
		for(IObservador obs : observadores) {
			obs.updateEntidad(entidad);
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
	public void agregarAEntidadesParaAgregar(Entidad entidad) {
		entidadesParaAgregar.add(entidad);
	}
	public void agregarAEntidadesParaQuitar(Entidad entidad) {
		entidadesParaQuitar.add(entidad);
	}

}
