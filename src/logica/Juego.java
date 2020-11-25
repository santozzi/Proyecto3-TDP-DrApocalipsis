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
import niveles.Nivel2;
import niveles.Nivel3;
import observador.IObservado;
import observador.IObservador;

public class Juego implements IObservado {
	protected Nivel nivel;

	protected Mapa mapa;


	protected List<IObservador> observadores;
	public static final int ANCHO_DE_COMBATE=444;
	public static final int ALTO_DE_COMBATE=619;
	protected HiloSecundario hiloSecundario;
	//public static final int DECORADO_IZQUIERDO=62;
	//public static final int DECORADO_DERECHO=62;
	public static final int DECORADO_IZQUIERDO=184;
	public static final int DECORADO_DERECHO=184;

	protected Point limite;
	protected static final int LATENCIA_MINIMA=5;
	protected static final int LATENCIA_MAXIMA=10;
	protected Jugador jugador;
	protected boolean finDeLaTanda;
	protected int nivelActual;
	public Juego() {
		this.nivelActual = 1;
		observadores = new LinkedList<IObservador>();
		hiloSecundario = new HiloSecundario(this);

		this.limite = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
		jugador = new Jugador(this);

		hiloSecundario.start();


	}
	public void cargarJugador() {
		agregarAEntidadesParaAgregar(jugador);
	}



	//hilo paralelo
	public void hiloRecorredorDeEntidades() {
		Thread hiloVerificar = new Thread(){
			//  Iterator<Latencia> itLat ;
			@Override 
			public void run() {

				while(true) {

					/*
								if(entidad.getVector().getPosicion().y<limite.y && entidad.getVector().getPosicion().y<0) {

									if(limite.x >= Juego.ANCHO_DE_COMBATE-entidad.getImagen().getIconWidth()) {
										limite.y = limite.y = entidad.getVector().getPosicion().y-entidad.getImagen().getIconHeight();
										limite.x = 0;
									}else {
										limite.y = limite.y = entidad.getVector().getPosicion().y;
										limite.x += entidad.getImagen().getIconWidth();
									}
}
					 */
					//System.out.println("Limite: X=" + limite.x + " ; Y=" + limite.y + " (Juego)");





				}


			}

		};


	}


	
	public Point getLimite() {
		return this.limite;
	}
	public Nivel getNivel() {
		return nivel;
	}

    public void cargarNivel(int n) {
		//Nivel[] niveles = new Nivel[3];
		if(n==1) {
			System.out.println("estoy en cargar nivel "+n);
			this.nivel = new Nivel1(this);

			/*	}else if(n==2) {
			this.nivel = new Nivel2(this);
		}else if(n==3) {
			this.nivel = new Nivel3(this);*/
		}else {
			System.out.println("game over");
			nivel= null;
		}

		if(nivel!=null) {
			for(Entidad entidad : nivel.primeraTanda()) {
				hiloSecundario.agregarAColaParaAgregar(entidad);
			}
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
        hiloSecundario.agregarAColaParaAgregar(entidad);
		
	}

	public void agregarAEntidadesParaQuitar(Entidad entidad) {
       hiloSecundario.agregarAColaParaQuitar(entidad);
       notificarQuitarEntidad(entidad);
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
	// pregunto si no quedan mas infectados en el nivel
	public void verificarFinTanda() {
		if(this.nivel.getColeccionDeInfectados().getListaDeInfectados().isEmpty()) {
			finalizarTanda();
		}
	}
	public void finalizarTanda() {
	

	}
	public List<Entidad> getLista(){
		return hiloSecundario.listaDeRecorrido();
	}
	

}
