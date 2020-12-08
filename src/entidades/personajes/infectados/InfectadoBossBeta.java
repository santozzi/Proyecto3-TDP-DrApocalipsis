package entidades.personajes.infectados;

import logica.Juego;
import visitor.VisitanteInfectadoBossBeta;
import visitor.Visitor;

/**
 * InfectadoBossBeta es un subtipo de infecta
 *
 */
public class InfectadoBossBeta extends InfectadoBoss {

        
	public InfectadoBossBeta(Juego juego) {
		super(juego);
		this.puntos = 2000;
		this.cargaViral=1000;
		this.letalidadFisica=15;
		this.getVector().setModulo(9);
		v = new VisitanteInfectadoBossBeta(this);

	}

	@Override
	public void accept(Visitor v) {
	   	v.visitarInfectadoBossBeta(this);
	}

	@Override
	public InfectadoBossBeta clone() {
		return new InfectadoBossBeta(juego);
	}

}
