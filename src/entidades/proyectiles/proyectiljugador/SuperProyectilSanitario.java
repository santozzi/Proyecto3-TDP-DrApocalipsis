package entidades.proyectiles.proyectiljugador;

import logica.ColeccionDeImagenes;
import logica.Juego;
import visitor.VisitanteSuperProyectilSanitario;
import visitor.Visitor;

public class SuperProyectilSanitario extends ProyectilJugador {
    public SuperProyectilSanitario(Juego juego) {
    	super(juego);
    	
    	this.letalidad = 80;
    	vector.getPosicion().x= jugador.getVector().getPosicion().x+24;
		vector.getPosicion().y= jugador.getVector().getPosicion().y-10;
		

		imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen("superProyectilSanitario");

    	v = new VisitanteSuperProyectilSanitario(this);
    	
    }
	@Override
	public void accept(Visitor v) {
		v.visitarSuperProyectilSanitario(this);
		
	}
	@Override
	public void impacto(int letalidad) {
		// TODO Auto-generated method stub
		
	}


}
