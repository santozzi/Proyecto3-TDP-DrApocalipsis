package entidades.premios.no_temporales;

import logica.Juego;
import visitor.VisitantePocion;
import visitor.Visitor;
/**
 *Pocion
 *Recarga la energia del jugador
 */
public class Pocion extends ObjetoPrecioso {
    public Pocion(Juego juego) {
    	super(juego);
    	v= new VisitantePocion(this);
    	
    }
	@Override
	public void ejecutar() {
		juego.getJugador().curar(20);
		juego.notificarCargaViralDeJugador();
	}

	@Override
	public void accept(Visitor v) {
		v.visitarPocion(this);
		
	}
	@Override
	public void impacto(int letalidad) {
		// TODO Auto-generated method stub
		
	}
	

}
