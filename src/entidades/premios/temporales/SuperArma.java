package entidades.premios.temporales;

import armas.SuperArmaSanitaria;
import entidades.Entidad;
import entidades.Vector;
import entidades.personajes.jugador.Jugador;
import logica.ColeccionDeImagenes;
import logica.Juego;
import visitor.VisitanteSuperArma;
import visitor.Visitor;

public class SuperArma extends Temporal {
	protected Jugador jugador;
    public SuperArma (Juego juego) {
        super(juego);
    	
    	this.jugador = juego.getJugador();
    	vector = new Vector(0,1,1);
    	v= new VisitanteSuperArma(this);
    	
    	this.claveImagen = new String("superArmaSanitaria");
    	imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(claveImagen);
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
	

}
