package entidades.premios.no_temporales;

import logica.Juego;
import visitor.VisitanteMoneda;
import visitor.Visitor;
/**
 * Moneda
 * Aumenta el score del jugador
 *
 */
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
		if(!agarro) {
		   juego.agregarItem(this.claveImagen, valor);
		   agarro= true;
		}
		   desaparecer();
		juego.notificarScore();
	}

	@Override
	public void accept(Visitor v) {
		v.visitarMoneda(this);
	}

	@Override
	public void impacto(int letalidad) {
		
	}
}
