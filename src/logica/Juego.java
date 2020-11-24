package logica;

import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import GUI.Mapa;
import entidades.Entidad;
import entidades.personajes.jugador.Jugador;
import niveles.Nivel;
import niveles.Nivel1;
import observador.IObservado;
import observador.IObservador;

public class Juego implements IObservado {
	protected Nivel nivel;

	protected List<Latencia> entidadesParaRecorido;
	protected List<Latencia> entidadesParaAgregar;
	protected List<Latencia> entidadesParaQuitar;
	protected Mapa mapa;


	protected List<IObservador> observadores;
	public static final int ANCHO_DE_COMBATE=444;
	public static final int ALTO_DE_COMBATE=619;

	//public static final int DECORADO_IZQUIERDO=62;
	//public static final int DECORADO_DERECHO=62;
	public static final int DECORADO_IZQUIERDO=184;
	public static final int DECORADO_DERECHO=184;

	protected Point limite;
	protected static final int LATENCIA_MINIMA=5;
	protected static final int LATENCIA_MAXIMA=10;
	protected Jugador jugador;
	protected boolean finDeLaTanda;

	public Juego() {
		
		observadores = new LinkedList<IObservador>();

		this.limite = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
		jugador = new Jugador(this);
		nivel = new Nivel1(this);

		entidadesParaRecorido = new LinkedList<Latencia>();
		entidadesParaAgregar = new LinkedList<Latencia>();
		entidadesParaQuitar = new LinkedList<Latencia>();
		//mapa = new Mapa(this);
		//mapa.setVisible(true);

		hiloRecorredorDeEntidades();

	}
	public void cargarJugador() {
		entidadesParaAgregar.add(new Latencia(jugador)) ;	
	}



	//hilo paralelo
	public void hiloRecorredorDeEntidades() {
		Thread hiloVerificar = new Thread(){
			//  Iterator<Latencia> itLat ;
			@Override 
			public void run() {

				while(true) {
					try {
						Thread.sleep(LATENCIA_MINIMA);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					notificarObservadores();


					Entidad entidad;

					for(Latencia lat: entidadesParaRecorido){


						entidad = lat.getEntidad();

						int velocidad = entidad.getVector().getModulo();
						if(velocidad>0 && velocidad<LATENCIA_MAXIMA) {
							//velocidad cuanto mas cercano a uno sea mas rapido va a ir

							int latencia = LATENCIA_MAXIMA-velocidad;
	
							if(entidad!=jugador) {

								if(entidad.getVector().getPosicion().y<limite.y && entidad.getVector().getPosicion().y<0) {

									if(limite.x >= Juego.ANCHO_DE_COMBATE-entidad.getImagen().getIconWidth()) {
										limite.y = limite.y = entidad.getVector().getPosicion().y-entidad.getImagen().getIconHeight();
										limite.x = 0;
									}else {
										limite.y = limite.y = entidad.getVector().getPosicion().y;
										limite.x += entidad.getImagen().getIconWidth();
									}


									//System.out.println("Limite: X=" + limite.x + " ; Y=" + limite.y + " (Juego)");
								}

								if(latencia<=lat.getLatencia()) {
									//	System.out.println("entre en el hilo: "+entidad.getVector().getModulo());
									entidad.desplazarse();
									actualizarEntidad(entidad);
									lat.reiniciarLatencia();
								}else {
									
									lat.incrementarLatencia();
								}
							}
						}
					}
					cargarColaDeEntidades();

				}
			}
		};
		hiloVerificar.start();

	}
	public void agregarEntidad(Entidad entidad) {
		entidadesParaRecorido.add(new Latencia(entidad));
		notificarEntidad(entidad);
	}
	private void cargarColaDeEntidades() {
		for(Latencia entidadA : entidadesParaAgregar) {
			agregarEntidad(entidadA.getEntidad());
			//	System.out.println("agrego latencia "+entidadA);
		}
		entidadesParaAgregar.clear();

		for(Latencia entidadA : entidadesParaQuitar) {
			entidadesParaRecorido.remove(entidadA);
			notificarQuitarEntidad(entidadA.getEntidad());
		}

		entidadesParaQuitar.clear();

	}
	public Point getLimite() {
		return this.limite;
	}
	public Nivel getNivel() {
		return nivel;
	}
	public void cargarNivel() {
		for(Entidad entidad : nivel.primeraTanda()) {
			entidadesParaAgregar.add(new Latencia(entidad));
		}
	}
	@Override
	public void notificarEntidad(Entidad entidad) {
		for(IObservador obs: observadores)
			obs.updateEntidades(entidad);
	}
	@Override
	public void actualizarEntidad(Entidad entidad) {
		for(IObservador obs: observadores)
			obs.updateEntidad(entidad);
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
		for(IObservador obs: observadores)
			obs.update();

	}
	public void agregarAEntidadesParaAgregar(Entidad entidad) {

		entidadesParaAgregar.add(new Latencia(entidad));
	}

	public void agregarAEntidadesParaQuitar(Entidad entidad) {
		Latencia lat = null;
		Iterator<Latencia> itLat = entidadesParaRecorido.iterator();
		boolean esta = false;

		while(!esta&&itLat.hasNext()) {
			lat= itLat.next();
			if(lat.getEntidad()==entidad) {
				entidadesParaQuitar.add(lat);
			}
		}
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
	public void verificarFinTanda() {
		if(this.nivel.getColeccionDeInfectados().getListaDeInfectados().isEmpty()) {
			finalizarTanda();
		}
	}
	private void finalizarTanda() {
		// termino la tanda actual y cargo una nueva
	}

}
