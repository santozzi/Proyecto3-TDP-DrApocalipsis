package entidades.proyectiles;

import entidades.Vector;
import entidades.personajes.jugador.Jugador;
import logica.ColeccionDeImagenes;
import logica.Juego;
import visitor.VisitanteSuperProyectilSanitario;
import visitor.Visitor;

public class SuperProyectilSanitario extends Proyectil {
	protected Jugador jugador;
    public SuperProyectilSanitario(Juego juego) {
    	this.juego= juego;
    	this.jugador = juego.getJugador();
    	this.letalidad = 80;
    	this.vector = new Vector(0,-1,9);
    	vector.getPosicion().x= jugador.getVector().getPosicion().x+24;
		vector.getPosicion().y= jugador.getVector().getPosicion().y-10;
		imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen("proyectilSanitario");
		juego.agregarAEntidadesParaAgregar(this);
    	v = new VisitanteSuperProyectilSanitario(this);
    	
    }
	@Override
	public void accept(Visitor v) {
		v.visitarSuperProyectilSanitario(this);
		
	}


}
