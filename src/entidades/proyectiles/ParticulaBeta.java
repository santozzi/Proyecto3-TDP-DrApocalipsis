package entidades.proyectiles;


import entidades.Entidad;
import entidades.Vector;
import entidades.personajes.infectados.Infectado;
import logica.ColeccionDeImagenes;
import logica.Juego;
import visitor.VisitanteParticulaAlpha;
import visitor.VisitanteParticulaBeta;

import visitor.Visitor;

public class ParticulaBeta extends Particula{

	public ParticulaBeta(Juego juego, Infectado infectado) {
		super(juego, infectado);
		vector.setModulo(8);
        this.letalidad = 5;
        rangoParticula= 0;
		imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen("ParticulaBeta");
		v = new VisitanteParticulaBeta(this);	
	}


	public void accept(Visitor v) {
		v.visitarParticulaBeta(this);
	}

	

}
