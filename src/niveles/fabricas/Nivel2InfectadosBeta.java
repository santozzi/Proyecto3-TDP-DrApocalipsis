package niveles.fabricas;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import entidades.Entidad;
import entidades.personajes.infectados.Infectado;
import entidades.personajes.infectados.InfectadoBeta;
import logica.Juego;

public class Nivel2InfectadosBeta extends FabricaDeTandas {
	
	public Nivel2InfectadosBeta(Juego j) {
		this(j, 50);
	}

	public Nivel2InfectadosBeta(Juego j, int cantInfectados) {
		this.juego = j;
		this.cantidadInfectados = cantInfectados;
	}

	@Override
	public void primeraTanda() {
		Infectado nuevoInfectado;
		Random r1 = new Random();
		for(int i=0 ; i<cantidadInfectados ; i++) {
			nuevoInfectado = new InfectadoBeta(this.juego);
			
			nuevoInfectado.getPosicion().x = r1.nextInt(Juego.ANCHO_DE_COMBATE) + Juego.DECORADO_IZQUIERDO;
			nuevoInfectado.getPosicion().y =r1.nextInt(Juego.ALTO_DE_COMBATE);
			nuevoInfectado.getVector().setModulo(500);
			//entidades.add(nuevoInfectado);
		}
	}

	@Override
	public void segundaTanda() {
		Infectado nuevoInfectado;
		Random r1 = new Random();
		for(int i=0 ; i<cantidadInfectados*2 ; i++) {
			nuevoInfectado = new InfectadoBeta(this.juego);
			
			nuevoInfectado.getPosicion().x = r1.nextInt(Juego.ANCHO_DE_COMBATE) + Juego.DECORADO_IZQUIERDO;
			nuevoInfectado.getPosicion().y =r1.nextInt(Juego.ALTO_DE_COMBATE);
			nuevoInfectado.getVector().setModulo(500);
			//entidades.add(nuevoInfectado);
		}
	}

	@Override
	public void elJefe() {
		// TODO Auto-generated method stub
		
	}
}
