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
	protected int anchoInfectado;
	protected int altoInfectado ;
	protected Nivel nivel;
	
	protected List<Point> posiciones;
	
	
	public FabricaDeTandas(Juego j, Nivel nivel, int cantInfectados) {
		this.juego = j;
		this.cantidadInfectados = cantInfectados;
		this.nivel = nivel;

	}

	
	protected void crearTanda(int cantidadInfectados, Infectado tipoInfectado) {

			Point posicion;
			Infectado nuevoInfectado = null;//new InfectadoAlpha(this.juego);
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
						random.nextInt(Juego.ALTO_DE_COMBATE),
						random);
				
				posiciones.add(posicion);
				
				if(juego.getLimite().y>=posicion.y)
					juego.getLimite().y = posicion.y - nuevoInfectado.getImagen().getIconHeight();
				
				nuevoInfectado.setPosicion(posicion.x, - posicion.y - nuevoInfectado.getImagen().getIconHeight());
				nuevoInfectado.getVector().setModulo(9);
				compositeInfectados.add(nuevoInfectado);
			}
		}
		
	
	private Point asignarPosicion(List<Point> posiciones, int anchoInfectado, int altoInfectado, int x, int y, Random random) {
		Iterator<Point> itPosiciones;
		Point aRetornar;
		Point elem;
		boolean estaInsertado = false;
		itPosiciones = posiciones.iterator();

		while(itPosiciones.hasNext() && !estaInsertado) {
			elem = itPosiciones.next();
			estaInsertado = (x <= (elem.x + anchoInfectado) && x >= (elem.x - anchoInfectado))
					&& (y <= (elem.y + altoInfectado) && y >= (elem.y - altoInfectado));
		}

		if(estaInsertado)
			aRetornar = asignarPosicion(posiciones, anchoInfectado, altoInfectado, random.nextInt(Juego.ANCHO_DE_COMBATE-anchoInfectado), random.nextInt(Juego.ALTO_DE_COMBATE), random);
		else
			aRetornar = new Point(x, y);

		return aRetornar;
	}
	
	
	abstract public void primeraTanda();
	abstract public void segundaTanda();
	abstract public void  elJefe();
}
