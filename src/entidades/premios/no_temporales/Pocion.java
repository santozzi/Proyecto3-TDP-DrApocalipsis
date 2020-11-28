package entidades.premios.no_temporales;

import entidades.Vector;
import logica.ColeccionDeImagenes;
import logica.Juego;
import entidades.Entidad;
import visitor.VisitantePocion;
import visitor.Visitor;

public class Pocion extends NoTemporal {
    public Pocion(Juego juego) {
    	super(juego);
    	v= new VisitantePocion(this);
    	imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen("pocion");
    	
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
	

}
