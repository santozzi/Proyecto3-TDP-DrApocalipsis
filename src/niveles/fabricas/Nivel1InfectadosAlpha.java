package niveles.fabricas;

import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import entidades.Entidad;
import entidades.personajes.infectados.Infectado;
import entidades.personajes.infectados.InfectadoAlpha;
import entidades.personajes.infectados.InfectadoBeta;
import logica.CompositeInfectado;
import logica.Juego;
import niveles.Nivel;

public class Nivel1InfectadosAlpha extends FabricaDeTandas{


	public Nivel1InfectadosAlpha(Juego j, Nivel nivel) {
		this(j, nivel, 50);

	}

	public Nivel1InfectadosAlpha(Juego j, Nivel nivel, int cantInfectados) {
		this.juego = j;
		this.cantidadInfectados = cantInfectados;
		this.nivel = nivel;

	}

	public void primeraTanda() {

		Point posicion;
		Infectado nuevoInfectado;
		Random random = new Random();
		List<Point> posiciones = new LinkedList<Point>();
		List<Entidad> compositeInfectados = this.nivel.getColeccionDeInfectados().getListaDeInfectados();

		for(int i=0 ; i<cantidadInfectados; i++) {
            nuevoInfectado = new InfectadoAlpha(this.juego);
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
			//nuevoInfectado.getVector().getDireccion().y=1;
			//nuevoInfectado.getVector().getDireccion().x=1;
			/*
 			nuevoInfectado.getVector().getPosicion().x = posicion.x;
			nuevoInfectado.getVector().getPosicion().y = - posicion.y - nuevoInfectado.getImagen().getIconHeight();
			nuevoInfectado.tirarParticula();
			 */
			nuevoInfectado.setPosicion(posicion.x, - posicion.y - nuevoInfectado.getImagen().getIconHeight());
			nuevoInfectado.getVector().setModulo(3);
			//nuevoInfectado.getVector().cambioDeSentido();
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
	@Override
	public void segundaTanda() {
		Infectado nuevoInfectado;
		Random r1 = new Random();
		for(int i=0 ; i<cantidadInfectados*2 ; i++) {
			nuevoInfectado = new InfectadoAlpha(this.juego);

			nuevoInfectado.getVector().getPosicion().x = r1.nextInt(Juego.ANCHO_DE_COMBATE) + Juego.DECORADO_IZQUIERDO;
			nuevoInfectado.getVector().getPosicion().y =r1.nextInt(Juego.ALTO_DE_COMBATE);
			nuevoInfectado.getVector().setModulo(500);
			//entidades.add(nuevoInfectado);
		}
	}
}
