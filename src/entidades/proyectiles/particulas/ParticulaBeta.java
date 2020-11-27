package entidades.proyectiles.particulas;

import entidades.personajes.infectados.Infectado;
import logica.ColeccionDeImagenes;
import logica.Juego;
import visitor.VisitanteParticulaBeta;
import visitor.Visitor;

public class ParticulaBeta extends Particula{

	public ParticulaBeta(Juego juego, Infectado infectado) {
		super(juego, infectado);
		rangoParticula= 0;
		imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen("particulaBeta");
		v = new VisitanteParticulaBeta(this);
	}

	@Override
	public void accept(Visitor v) {
		v.visitarParticulaBeta(this);
		
	}

}
