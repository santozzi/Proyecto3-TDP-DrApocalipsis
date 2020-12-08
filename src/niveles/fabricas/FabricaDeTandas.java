package niveles.fabricas;

import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import entidades.Entidad;
import entidades.personajes.infectados.Infectado;
import logica.Juego;
import niveles.Nivel;

public abstract class FabricaDeTandas {
	
	protected Juego juego;
	protected int cantidadInfectados;
	protected Nivel nivel;
	protected List<Point> posiciones;
	
	
	public FabricaDeTandas(Juego j, Nivel nivel, int cantInfectados) {
		this.juego = j;
		this.cantidadInfectados = cantInfectados;
		this.nivel = nivel;

	}

	/**
	 * Creo una tanda con los parametros que me mandaron
	 * -------------------------------------------------
	 * @param cantidadInfectados : cantidad de infectados que voy a insertar en la nueva tanda
	 * @param tipoInfectado : tipo de infectado que voy a crear
	 * @param modulo : velocidad de los infectados que creo
	 * @param limiteEnY : limite donde voy a definir que tanto espacio en el mapa ocupa la tanda de infactados
	 * 
	 */
	protected void crearTanda(int cantidadInfectados, Infectado tipoInfectado,int modulo, int limiteEnY) {

			Point posicion;
			Infectado nuevoInfectado = null;
			Random random = new Random();
			posiciones = new LinkedList<Point>();
			List<Entidad> compositeInfectados = this.nivel.getColeccionDeInfectados().getListaDeInfectados();

			for(int i=0 ; i<cantidadInfectados ; i++) {
             	nuevoInfectado =tipoInfectado.clone();

				

				posicion = asignarPosicion(
						posiciones,
						nuevoInfectado.getImagen().getIconWidth(),
						nuevoInfectado.getImagen().getIconHeight(),
						random.nextInt(Juego.ANCHO_DE_COMBATE-nuevoInfectado.getImagen().getIconWidth()),
						random.nextInt(limiteEnY),
						random,
						limiteEnY);
				if(posicion!=null) {
				posiciones.add(posicion);
				
				if(juego.getLimite().y>=posicion.y)
					juego.getLimite().y = posicion.y - nuevoInfectado.getImagen().getIconHeight();
				
				nuevoInfectado.setPosicion(posicion.x, - posicion.y - nuevoInfectado.getImagen().getIconHeight());
				nuevoInfectado.getVector().setModulo(modulo);
				compositeInfectados.add(nuevoInfectado);
			}
			}
		}
		
	/**
	 * Busca una posicion libre en el mapa para insertar a un nuevo infectado
	 * ----------------------------------------------------------------------
	 * @param posiciones : lista donde guardo todas las posiciones en donde inserte a los infectados
	 * @param anchoInfectado : ancho que ocupa un infectado en el mapa
	 * @param altoInfectado : alto que ocupa un infectado en el mapa
	 * @param x : posicion en x a testear
	 * @param y : posicion en y a testear
	 * @param random : Random que voy a utilizar para crear una posicion aleatoria
	 * @param limiteEnY : limite donde voy a definir que tanto espacio en el mapa ocupa la tanda de infactados
	 * @return Posicion en el mapa donde voy a insertar al nuevo infectado
	 */
	private Point asignarPosicion(List<Point> posiciones, int anchoInfectado, int altoInfectado, int x, int y, Random random, int limiteEnY) {
		Iterator<Point> itPosiciones;
		Point aRetornar =null;
		Point elem;
		boolean estaInsertado = false;
		itPosiciones = posiciones.iterator();

		while(itPosiciones.hasNext() && !estaInsertado) {
			elem = itPosiciones.next();
			estaInsertado = (x <= (elem.x + anchoInfectado) && x >= (elem.x - anchoInfectado))
					&& (y <= (elem.y + altoInfectado) && y >= (elem.y - altoInfectado));
		}

		if(estaInsertado)
			aRetornar = asignarPosicion(posiciones, anchoInfectado, altoInfectado, random.nextInt(Juego.ANCHO_DE_COMBATE-anchoInfectado), random.nextInt(limiteEnY), random, limiteEnY);
		else
			aRetornar = new Point(x, y);

		return aRetornar;
	}
	
	/**
	 * Creo la primera tanda
	 */
	abstract public void primeraTanda();
	
	/**
	 * Creo la segunda tanda
	 */
	abstract public void segundaTanda();
	
	/**
	 * Creo la tanda del jefe
	 */
	abstract public void  elJefe();
}
