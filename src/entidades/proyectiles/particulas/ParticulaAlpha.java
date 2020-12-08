package entidades.proyectiles.particulas;

import entidades.personajes.infectados.Infectado;
import logica.Juego;
import visitor.VisitanteParticulaAlpha;
import visitor.Visitor;
/**
 * ParticulaAlpha
 * Especialización de Particula
 *
 */
public class ParticulaAlpha extends Particula{

	public ParticulaAlpha(Juego juego,Infectado infectado) {
	    super(juego,infectado);
        this.letalidad = 5;
		v = new VisitanteParticulaAlpha(this);	
	}

	@Override
	public void accept(Visitor v) {
		v.visitarParticulaAlpha(this);
	}

	@Override
	public void impacto(int letalidad) {
		
	}



	
}
