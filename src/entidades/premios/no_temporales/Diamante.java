package entidades.premios.no_temporales;

import logica.Juego;
import visitor.VisitanteDiamante;
import visitor.Visitor;
/**
 * Es una especialización de la mondea. 
 *
 */
public class Diamante extends Moneda{

	public Diamante(Juego juego) {
		super(juego);
		v= new VisitanteDiamante(this);
		this.valor= 50;
	}



	@Override
	public void accept(Visitor v) {
		v.visitarDiamante(this);
	}

	@Override
	public void impacto(int letalidad) {
		
	}
}
