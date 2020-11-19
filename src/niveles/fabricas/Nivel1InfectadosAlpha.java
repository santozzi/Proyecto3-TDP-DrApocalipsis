package niveles.fabricas;

import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import entidades.Entidad;
import entidades.personajes.infectados.Infectado;
import entidades.personajes.infectados.InfectadoAlpha;
import logica.Juego;

public class Nivel1InfectadosAlpha extends FabricaDeTandas{
	
	public Nivel1InfectadosAlpha(Juego j) {
		this(j, 10);
	}

	public Nivel1InfectadosAlpha(Juego j, int cantInfectados) {
		this.juego = j;
		this.entidades = new LinkedList<Entidad>();
		this.cantidadInfectados = cantInfectados;
		
	}

	@Override
	public void primeraTanda() {
		Point posicion;
		Infectado nuevoInfectado;
		Random random = new Random();
		List<Point> posiciones = new LinkedList<Point>();
		
		for(int i=0 ; i<cantidadInfectados ; i++) {
			
			posicion = asignarPosicion(posiciones, random.nextInt(Juego.ANCHO_DE_COMBATE - anchoInfectado), random.nextInt(Juego.limite), random);
			
			posiciones.add(posicion);
			
 			nuevoInfectado = new InfectadoAlpha(this.juego);
 			this.anchoInfectado = nuevoInfectado.getImagen().getAncho();
 			this.altoInfectado = nuevoInfectado.getImagen().getAlto();
			//nuevoInfectado.getVector().getDireccion().y=1;
			//nuevoInfectado.getVector().getDireccion().x=1;
			nuevoInfectado.getVector().getPosicion().x = posicion.x + Juego.DECORADO_IZQUIERDO;
			nuevoInfectado.getVector().getPosicion().y = posicion.y - Juego.limite;
			nuevoInfectado.getVector().setModulo(700);
			//nuevoInfectado.getVector().cambioDeSentido();
			entidades.add(nuevoInfectado);
		}
	}

	private Point asignarPosicion(List<Point> posiciones, int x, int y, Random random) {
		Iterator<Point> itPosiciones;
		Point aRetornar;
		Point elem;
		boolean estaInsertado = false;
		itPosiciones = posiciones.iterator();
		
		while(itPosiciones.hasNext() && !estaInsertado) {
			elem = itPosiciones.next();
			estaInsertado = (x <= (elem.x + anchoInfectado) && x >= (elem.x - anchoInfectado))
					&& (y <= (elem.y + anchoInfectado) && y >= (elem.y - altoInfectado));
		}
		
		if(estaInsertado)
			aRetornar = asignarPosicion(posiciones, random.nextInt(Juego.ANCHO_DE_COMBATE - anchoInfectado), random.nextInt(Juego.ANCHO_DE_COMBATE), random);
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
			entidades.add(nuevoInfectado);
		}
	}

	@Override
	public List<Entidad> getEntidades() {
		return this.entidades;
	}


}
