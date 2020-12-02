package entidades.premios.no_temporales;

import logica.Juego;
import visitor.VisitanteMoneda;
import visitor.VisitantePocion;
import visitor.Visitor;

public class Moneda extends ObjetoPrecioso{
    protected int valor;
    protected boolean agarro;
	public Moneda(Juego juego) {
		super(juego);
		v= new VisitanteMoneda(this);
		this.valor= 5;
		this.agarro= false;
	}

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		if(!agarro) {
		   juego.agregarItem(this.claveImagen, valor);
		   agarro= true;
		}
		   desaparecer();
		juego.notificarScore();
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
