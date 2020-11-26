package entidades.personajes.infectados;



import entidades.Vector;

import logica.Juego;
import visitor.VisitanteInfectadoBeta;
import visitor.Visitor;

/**
 * Este infectado tiene mayor resistencia
 * @author 
 *
 */
public class InfectadoBeta extends Infectado {
	
	public InfectadoBeta(Juego juego) {
		this.juego = juego;
		this.vector = new Vector(0, -1, 5);
		this.cargaViral = 200;
		tirarParticula();
		v = new VisitanteInfectadoBeta(this);
	}
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
	}
	@Override
	public void actuar() {
		// TODO Auto-generated method stub
		
	}
}
