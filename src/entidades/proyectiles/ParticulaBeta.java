package entidades.proyectiles;

import entidades.personajes.infectados.Infectado;
import logica.Juego;
import visitor.Visitor;

public class ParticulaBeta extends Particula{

	public ParticulaBeta(Juego juego, Infectado infectado) {
		super(juego, infectado);
		
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}

}
