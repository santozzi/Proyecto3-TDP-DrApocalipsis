package entidades.premios.temporales;

import armas.SuperArmaSanitaria;
import entidades.personajes.jugador.Jugador;
import logica.Juego;
import visitor.VisitanteSuperArma;
import visitor.Visitor;
/**
 *SuperArma
 *Modifica de forma temporal el arma del jugador 
 *
 */
public class SuperArma extends Temporal {
	protected Jugador jugador;
    public SuperArma (Juego juego) {
        super(juego);
    	this.jugador = juego.getJugador();
    	v= new VisitanteSuperArma(this);
    }
	@Override
	public void ejecutar() {
	    jugador.cambiarEstadoTemporal();
		jugador.cambiarArma(new SuperArmaSanitaria(juego));
	}
	@Override
	public void accept(Visitor v) {
		v.visitarSuperArma(this);
	}
	@Override
	public void impacto(int letalidad) {
		
	}
	
}
