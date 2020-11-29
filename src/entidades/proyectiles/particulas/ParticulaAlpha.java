package entidades.proyectiles.particulas;

import entidades.personajes.infectados.Infectado;
import logica.ColeccionDeImagenes;
import logica.Juego;
import visitor.VisitanteParticulaAlpha;
import visitor.Visitor;

public class ParticulaAlpha extends Particula{

	public ParticulaAlpha(Juego juego,Infectado infectado) {
	    super(juego,infectado);
	
        this.letalidad = 5;
   		imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen("particula");
		v = new VisitanteParticulaAlpha(this);	
	}

	@Override
	public void accept(Visitor v) {
		v.visitarParticulaAlpha(this);
	}

	@Override
	public void impacto(int letalidad) {
		// TODO Auto-generated method stub
		
	}



	
}
