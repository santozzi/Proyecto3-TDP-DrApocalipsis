package entidades.premios.no_temporales;

import logica.ColeccionDeImagenes;
import logica.Juego;
import visitor.VisitantePocion;
import visitor.Visitor;

public class Pocion extends ObjetoPrecioso {
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
	@Override
	public void impacto(int letalidad) {
		// TODO Auto-generated method stub
		
	}
	

}
