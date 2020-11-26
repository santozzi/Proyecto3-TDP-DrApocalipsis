package entidades.proyectiles;

import entidades.personajes.infectados.Infectado;
import logica.ColeccionDeImagenes;
import logica.Juego;
import visitor.VisitanteParticulaAlpha;
import visitor.Visitor;

public class ParticulaAlpha extends Particula{

	public ParticulaAlpha(Juego juego,Infectado infectado) {
	    super(juego,infectado);
		vector.setModulo(8);
        this.letalidad = 5;
        rangoParticula= 0;
		imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen("particula");
		v = new VisitanteParticulaAlpha(this);	
	}

	@Override
	public void accept(Visitor v) {
		v.visitarParticulaAlpha(this);
	}



	
}
