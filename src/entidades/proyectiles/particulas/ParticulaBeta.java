package entidades.proyectiles.particulas;

import entidades.personajes.infectados.Infectado;
import logica.Juego;
import visitor.VisitanteParticulaBeta;
import visitor.Visitor;
/**
 * ParticulaBeta
 * Especializacion de particula
 *
 */
public class ParticulaBeta extends Particula{
	/**
	 * ParticulaBeta
	 * @param juego
	 * @param infectado
	 */
	public ParticulaBeta(Juego juego, Infectado infectado) {
		super(juego, infectado);
		rangoParticula= 0;
		this.letalidad = 2;
		v = new VisitanteParticulaBeta(this);
	}

	@Override
	public void accept(Visitor v) {
		v.visitarParticulaBeta(this);

	}

	@Override
	public void impacto(int letalidad) {

	}

}
