package entidades.personajes.infectados;

import logica.Juego;
import visitor.VisitanteInfectadoBossAlpha;
import visitor.Visitor;

/**
 * Este infectado tiene mayor resistencia
 * @author 
 *
 */
public class InfectadoBossAlpha extends InfectadoBoss {
  
        
	public InfectadoBossAlpha(Juego juego) {
		super(juego);
		this.puntos = 1500;
		this.cargaViral=750;
		this.letalidadFisica=10;
	    this.getVector().setModulo(8);
		v = new VisitanteInfectadoBossAlpha(this);

	}

	@Override
	public void accept(Visitor v) {
	   	v.visitarInfectadoBossAlpha(this);
	}

	@Override
	public InfectadoBossAlpha clone() {
		// TODO Auto-generated method stub
		return new InfectadoBossAlpha(juego);
	}


	
	
	
}
