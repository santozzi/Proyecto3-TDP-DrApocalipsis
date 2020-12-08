package logica;

import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import entidades.Entidad;
/**
 * 
 *HiloSecundario
 *Encargada de agregar, quitar y recorrer entidades en segundo plano
 */
public class HiloSecundario extends Thread{
	protected Queue<Entidad> colaParaAgregar;
	protected Queue<Entidad> colaParaQuitar;
	protected List<Entidad> listaParaRecorrer;
	protected List<Entidad> copiaDeListaParaRecorrer;
	protected Juego juego;
	public static final int LATENCIA_MAXIMA = 10;
	private boolean correr;
	private boolean correr2;
	

	/**
	 * HiloSecundario
	 * @param juego
	 */
	public HiloSecundario(Juego juego) {
		this.juego = juego;
		colaParaAgregar = new ConcurrentLinkedQueue<Entidad>();
		colaParaQuitar = new ConcurrentLinkedQueue<Entidad>();
		listaParaRecorrer = new LinkedList<Entidad>();
		copiaDeListaParaRecorrer = new LinkedList<Entidad>();
		this.correr = true;
		this.correr2 = false;
		
	}
	/**
	 * terminarEjecucion
	 * Finaliza al hilo en ejecucion
	 */
	public void terminarEjecucion() {
		this.correr = false;
		
	}
    /**
     * La parte que se ejecuta en segundo plano
     */
	@Override
	public void run() {
		Iterator<Entidad> itListaParaRecorrer;
		Entidad entidadParaAccionar;
		while(correr||!correr2) {
			juego.notificarObservadores();
			esperar(5);
			itListaParaRecorrer = listaParaRecorrer.iterator();
			while(itListaParaRecorrer.hasNext()) {
				entidadParaAccionar = itListaParaRecorrer.next();
				entidadParaAccionar.actuar();
			}
			agregarYQuitarEntidades();
		}
	}
	/*
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
    	
    }*/
	
	/**
	 * esparar
	 * Tiempo de espera en milisegundos por cada ciclo
	 * @param miliSegundos
	 */
	private void esperar(int miliSegundos) {
		try {Thread.sleep(miliSegundos);} catch (InterruptedException e) {e.getMessage();}
	}
	/**
	 * agregarYQuitarEntidades
	 * Este método se ejecuta al finalizar cada ciclo del hilo secundario
	 * Se encarga de agregar, quitar y clonar la lista de entidades activas
	 */
	private void agregarYQuitarEntidades() {
		//Agrega a la lista de recorrido
		while(!colaParaAgregar.isEmpty()) {
			Entidad entParaAgregar = colaParaAgregar.poll();
			listaParaRecorrer.add(entParaAgregar);
			juego.notificarEntidad(entParaAgregar);
		}
		//Quita a la lista de recorrido
		while(!colaParaQuitar.isEmpty()) {

			Entidad entParaQuitar =colaParaQuitar.poll();
			listaParaRecorrer.remove(entParaQuitar);
			juego.notificarQuitarEntidad(entParaQuitar);
		}
		
	    //Borra la anterior y clona la lista de recorrido
		copiaDeListaParaRecorrer.clear();
		for(Entidad entidad : listaParaRecorrer) {
			copiaDeListaParaRecorrer.add(entidad);
		}
		//----------------------------------------------------

		
		//para entrar en la pantalla score.
		if((colaParaAgregar.isEmpty()
				&&colaParaQuitar.isEmpty()
				&&listaParaRecorrer.size()<=1
				&&!correr)||!juego.jugadorVive&&!correr) {
			
			
			juego.notificarEstadistica();
			this.correr2 = true;
			}

	}
	/**
	 * agregarAColaParaAgregar
	 * Agrega una entidad a la cola para agregar a la lista de recorrido
	 * @param entidad
	 */
	public void agregarAColaParaAgregar(Entidad entidad) {
		colaParaAgregar.add(entidad);
	}
	/**
	 * agregarAColaParaQuitar
	 * Quiata una entidad a la cola para quitar a la lista de recorrido
	 * @param entidad
	 */
	public void agregarAColaParaQuitar(Entidad entidad) {
		colaParaQuitar.add(entidad);
	}
	/**
	 * listaDeRecorrido
	 * Devuelve un clon de la lista de recorido
	 * @return clon de lista de recorrido
	 */
	public List<Entidad> listaDeRecorrido(){
		return copiaDeListaParaRecorrer;
	}

}
