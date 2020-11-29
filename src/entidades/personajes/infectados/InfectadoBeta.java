package entidades.personajes.infectados;

import entidades.proyectiles.particulas.ParticulaBeta;
import logica.ColeccionDeImagenes;
import logica.Juego;
import visitor.VisitanteInfectadoBeta;
import visitor.Visitor;

/**
 * Este infectado tiene mayor resistencia
 * @author 
 *
 */
public class InfectadoBeta extends Infectado {
	
	public InfectadoBeta(Juego juego) {
        super(juego);
		this.rango = 100;
		this.puntos = 15;
		this.claveImagen = new String("InfectadoBeta");
		imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(this.claveImagen);
		v = new VisitanteInfectadoBeta(this);
		
	}
	@Override
	public void accept(Visitor v) {
		v.visitarInfectadoBeta(this);
	}
	public void tirarParticula() {
    	this.particula= new ParticulaBeta(juego,this);
    }
	@Override
	public InfectadoBeta clone() {
		// TODO Auto-generated method stub
		return new InfectadoBeta(juego);
	}
}
