package niveles.fabricas;

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
		this(j, 50);
	}

	public Nivel1InfectadosAlpha(Juego j, int cantInfectados) {
		this.juego = j;
		this.entidades = new LinkedList<Entidad>();
		this.cantidadInfectados = cantInfectados;
	}

	@Override
	public void primeraTanda() {
		int posicionEnX;
		int posicionEnY;
		Infectado nuevoInfectado;
		Random random = new Random();
		List<Integer> posicionesEnX = new LinkedList<Integer>();
		List<Integer> posicionesEnY = new LinkedList<Integer>();
		
		for(int i=0 ; i<cantidadInfectados ; i++) {
			
			posicionEnX = asignarPosicionEnX(posicionesEnX, random.nextInt(Juego.ANCHO_DE_COMBATE), random);
			posicionEnY = asignarPosicionEnY(posicionesEnY, random.nextInt(Juego.ALTO_DE_COMBATE), random);
			
			nuevoInfectado = new InfectadoAlpha(this.juego);
			nuevoInfectado.getPosicion().x = posicionEnX + Juego.DECORADO_IZQUIERDO;
			nuevoInfectado.getPosicion().y = posicionEnY;
			nuevoInfectado.getVector().setModulo(500);
			entidades.add(nuevoInfectado);
		}
	}

	private int asignarPosicionEnX(List<Integer> posicionesEnX, int x, Random random) {
		Iterator<Integer> itPosiciones;
		int aRetornar;
		int elem;
		boolean estaInsertado = false;
		itPosiciones = posicionesEnX.iterator();
		
		while(itPosiciones.hasNext() && !estaInsertado) {
			elem = itPosiciones.next();
			estaInsertado = x <= (elem + ANCHO_INFECTADO*2) && x >= (elem - ANCHO_INFECTADO*2);
		}
		
		if(estaInsertado)
			aRetornar = asignarPosicionEnX(posicionesEnX, random.nextInt(Juego.ANCHO_DE_COMBATE), random);
		else
			aRetornar = x;
		
		return aRetornar;
	}
	
	private int asignarPosicionEnY(List<Integer> posicionesEnY, int y, Random random) {
		Iterator<Integer> itPosiciones;
		int aRetornar;
		int elem;
		boolean estaInsertado = false;
		itPosiciones = posicionesEnY.iterator();
		
		while(itPosiciones.hasNext() && !estaInsertado) {
			elem = itPosiciones.next();
			estaInsertado = y <= (elem + ALTO_INFECTADO*2) && y >= (elem - ALTO_INFECTADO*2);
		}
		
		if(estaInsertado)
			aRetornar = asignarPosicionEnX(posicionesEnY, random.nextInt(Juego.ALTO_DE_COMBATE), random);
		else
			aRetornar = y;
		
		return aRetornar;
	}

	@Override
	public void segundaTanda() {
		Infectado nuevoInfectado;
		Random r1 = new Random();
		for(int i=0 ; i<cantidadInfectados*2 ; i++) {
			nuevoInfectado = new InfectadoAlpha(this.juego);
			
			nuevoInfectado.getPosicion().x = r1.nextInt(Juego.ANCHO_DE_COMBATE) + Juego.DECORADO_IZQUIERDO;
			nuevoInfectado.getPosicion().y =r1.nextInt(Juego.ALTO_DE_COMBATE);
			nuevoInfectado.getVector().setModulo(500);
			entidades.add(nuevoInfectado);
		}
	}

	@Override
	public List<Entidad> getEntidades() {
		return this.entidades;
	}


}
