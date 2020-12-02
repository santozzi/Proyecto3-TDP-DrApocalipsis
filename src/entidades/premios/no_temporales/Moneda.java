package entidades.premios.no_temporales;

import logica.Juego;
import visitor.VisitanteMoneda;
import visitor.VisitantePocion;
import visitor.Visitor;

public class Moneda extends ObjetoPrecioso{

	public Moneda(Juego juego) {
		super(juego);
		v= new VisitanteMoneda(this);
	}

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		juego.agregarItem(this.claveImagen, 5);
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarMoneda(this);
	}

	@Override
	public void impacto(int letalidad) {
		// TODO Auto-generated method stub
		
	}
}
