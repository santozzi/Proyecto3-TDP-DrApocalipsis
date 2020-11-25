package niveles.fabricas;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import entidades.Entidad;
import entidades.personajes.infectados.Infectado;
import entidades.personajes.infectados.InfectadoAlpha;
import entidades.personajes.infectados.InfectadoBeta;
import logica.Juego;

public class Nivel3InfectadosMixto extends FabricaDeTandas {

	public Nivel3InfectadosMixto(Juego j) {
		this(j, 1);
	}

	public Nivel3InfectadosMixto(Juego j, int cantInfectados) {
		this.juego = j;
		this.cantidadInfectados = cantInfectados;

	}

	@Override
	public void primeraTanda() {
	
		    
	}
	public List<Entidad> pTanda() {
		List<Entidad> infectados = new LinkedList<Entidad>();
		Infectado nuevoInfectado = new InfectadoAlpha(juego);
	
			nuevoInfectado.setPosicion(Juego.ANCHO_DE_COMBATE/2,Juego.ANCHO_DE_COMBATE/2) ;
			
			nuevoInfectado.getVector().setModulo(3);
		    infectados.add(nuevoInfectado);	
		    return infectados;
		    
	}
	@Override
	public void segundaTanda() {
		Random r1 = new Random();
		int randInt;
		Infectado nuevoInfectado = new InfectadoAlpha(juego);
		
		for(int i=0 ; i<cantidadInfectados*2 ; i++) {
			randInt = r1.nextInt(2);

			if(randInt == 0)
				nuevoInfectado = new InfectadoAlpha(juego);
			else if(randInt == 1)
				nuevoInfectado = new InfectadoBeta(juego);
			
			nuevoInfectado.getPosicion().x = r1.nextInt(Juego.ANCHO_DE_COMBATE) + Juego.DECORADO_IZQUIERDO;
			nuevoInfectado.getPosicion().y = r1.nextInt(Juego.ALTO_DE_COMBATE);
			nuevoInfectado.getVector().setModulo(500);
			//entidades.add(nuevoInfectado);
		}
	}
}
