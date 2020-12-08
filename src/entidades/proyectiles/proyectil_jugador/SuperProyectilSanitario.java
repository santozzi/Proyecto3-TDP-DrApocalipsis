package entidades.proyectiles.proyectil_jugador;

import logica.Juego;
import visitor.VisitanteSuperProyectilSanitario;
import visitor.Visitor;
/**
 * SuperProyectilSanitario
 * Especializacion de ProyectilJugador que tiene mas letalidad.
 */
public class SuperProyectilSanitario extends ProyectilJugador {
    public SuperProyectilSanitario(Juego juego) {
    	super(juego);
    	this.letalidad = 50;
    	v = new VisitanteSuperProyectilSanitario(this);
    }
	@Override
	public void accept(Visitor v) {
		v.visitarSuperProyectilSanitario(this);
	}
	@Override
	public void impacto(int letalidad) {
	}

}
