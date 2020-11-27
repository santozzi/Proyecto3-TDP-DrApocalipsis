package entidades.personajes.infectados;

import java.util.Random;

import entidades.proyectiles.particulas.ParticulaAlpha;
import entidades.proyectiles.particulas.ParticulaBeta;
import logica.ColeccionDeImagenes;
import logica.HiloSecundario;
import logica.Juego;
import visitor.VisitanteInfectadoBeta;
import visitor.VisitanteInfectadoBossAlpha;
import visitor.VisitanteInfectadoBossBeta;
import visitor.Visitor;

/**
 * Este infectado tiene mayor resistencia
 * @author 
 *
 */
public class InfectadoBossBeta extends InfectadoBoss {

        
	public InfectadoBossBeta(Juego juego) {
		super(juego);
		this.puntos = 2000;
		this.cargaViral=1000;
		this.claveImagen = new String("InfectadoBossBeta");
		imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(this.claveImagen);
		v = new VisitanteInfectadoBossBeta(this);

	}

	@Override
	public void accept(Visitor v) {
	   	v.visitarInfectadoBossBeta(this);
	}

}
