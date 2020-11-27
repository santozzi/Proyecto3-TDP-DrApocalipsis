package entidades.personajes.infectados;

import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import entidades.Entidad;
import entidades.Vector;
import entidades.proyectiles.ParticulaAlpha;
import logica.ColeccionDeImagenes;
import logica.HiloSecundario;
import logica.Juego;
import visitor.*;
import visitor.Visitor;

/**
 * Estos infectados tienen menor resistencia y 
 * mayor letalidad.
 * @author 
 *
 */
public class InfectadoAlpha extends Infectado{
	
		public InfectadoAlpha(Juego juego) {
		super(juego);
	   	this.cargaViral = 80;
		this.claveImagen = new String("InfectadoAlpha_golpear");
		imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(this.claveImagen);
		v = new VisitanteInfectadoAlpha(this);
		
	}

	/**
	 * duplicarVelocidad
	 * -----------------
	 * Duplica la velocidad del personaje
	 * cuando este tiene menos del 20% de energia
	 */
	public void duplicarVelocidad() {

		// si no esta afectado por la cuarentena entonces duplico su velocidad
		if(this.vector.getModulo()>0) { 
			vector.setModulo(8);
			//vector.setModulo(vector.getModulo()*2);
			particula.getVector().setModulo(9);
		}
	}
	// v es de jugador
	@Override
	public void accept(Visitor v) {
		v.visitarInfectadoAlpha(this);
	}
	@Override
	public void impacto(int disparo) {
		super.impacto(disparo);
		if(cargaViral-disparo>0 && cargaViral-disparo<=20)
			duplicarVelocidad();
	}

	public void tirarParticula() {
    	this.particula= new ParticulaAlpha(juego,this);
    }

	

	

}
