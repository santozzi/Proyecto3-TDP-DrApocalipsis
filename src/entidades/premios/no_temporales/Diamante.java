package entidades.premios.no_temporales;

import logica.Juego;
import visitor.VisitanteDiamante;
import visitor.Visitor;

public class Diamante extends Moneda{

	public Diamante(Juego juego) {
		super(juego);
		v= new VisitanteDiamante(this);
		this.valor= 50;
	}



	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarDiamante(this);
	}

	@Override
	public void impacto(int letalidad) {
		// TODO Auto-generated method stub
		
	}
}
