package logica;

import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import entidades.Entidad;

public class HiloSecundario extends Thread{
	protected Queue<Entidad> colaParaAgregar;
	protected Queue<Entidad> colaParaQuitar;
	protected List<Entidad> listaParaRecorrer;
	protected Juego juego;
	public static final int LATENCIA_MAXIMA = 10;
	private static HiloSecundario hiloSecundario;
	private boolean correr;
	
	//Singleton
	public static HiloSecundario getHiloSecundario(Juego juego) {
		if(hiloSecundario == null)
			hiloSecundario = new HiloSecundario(juego);
		
		return hiloSecundario;
	}
	
	private HiloSecundario(Juego juego) {
		this.juego = juego;
		colaParaAgregar = new ConcurrentLinkedQueue<Entidad>();
		colaParaQuitar = new ConcurrentLinkedQueue<Entidad>();
		listaParaRecorrer = new LinkedList<Entidad>();
		this.correr = true;
	}
	public void terminarEjecucion() {
		this.correr = false;
		hiloSecundario = null;
	}

	@Override
	public void run() {
		Iterator<Entidad> itListaParaRecorrer;
		Entidad entidadParaAccionar;
		while(correr) {
			
			

			juego.notificarObservadores();
			esperar(5);
			itListaParaRecorrer = listaParaRecorrer.iterator();
			while(itListaParaRecorrer.hasNext()) {
				entidadParaAccionar = itListaParaRecorrer.next();
				
				actualizarLimiteVirtual(entidadParaAccionar);
				
				
				
				
				
				
				entidadParaAccionar.actuar();
			}
			agregarYQuitarEntidades();
		}
	}
	
    private void actualizarLimiteVirtual(Entidad entidad) {
    	
    	
    	Point limite = juego.getLimite(); 
    	if(entidad.getVector().getPosicion().y<limite.y && entidad.getVector().getPosicion().y<0) {
			if(limite.x >= Juego.ANCHO_DE_COMBATE-entidad.getImagen().getIconWidth()) {
				limite.y = limite.y = entidad.getVector().getPosicion().y-entidad.getImagen().getIconHeight();
				limite.x = 0;
			}else {
				limite.y = limite.y = entidad.getVector().getPosicion().y;
				limite.x += entidad.getImagen().getIconWidth();
			}
    	}
    	
    	
    }
	private void esperar(int segundos) {
		try {Thread.sleep(segundos);} catch (InterruptedException e) {e.getMessage();}
	}
	private void agregarYQuitarEntidades() {

		while(!colaParaAgregar.isEmpty()) {
			Entidad entParaAgregar = colaParaAgregar.poll();
			listaParaRecorrer.add(entParaAgregar);
			juego.notificarEntidad(entParaAgregar);
		}
		while(!colaParaQuitar.isEmpty()) {

			Entidad entParaQuitar =colaParaQuitar.poll();
			listaParaRecorrer.remove(entParaQuitar);
			juego.notificarQuitarEntidad(entParaQuitar);
		}

	}
	public void agregarAColaParaAgregar(Entidad entidad) {

		colaParaAgregar.add(entidad);

	}
	public void agregarAColaParaQuitar(Entidad entidad) {
		colaParaQuitar.add(entidad);
	}
	public List<Entidad> listaDeRecorrido(){
		return listaParaRecorrer;
	}
}
