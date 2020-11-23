package entidades.personajes.infectados;

import java.awt.Point;

import entidades.Vector;
import entidades.proyectiles.Particula;
import logica.ColeccionDeImagenes;
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
		this.juego = juego;

		this.vector = new Vector(0, 1, 3);
		this.cargaViral = 80;
	
		this.claveImagen = new String("InfectadoAlpha_golpear");
		imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(this.claveImagen);


		this.rango = 100;
		v = new VisitanteInfectadoAlpha(this);
		tirarParticula();
	}
	//tiene que existir particulaAlpha y particulaBeta;

	/**
	 * duplicarVelocidad
	 * -----------------
	 * Duplica la velocidad del personaje
	 * cuando este tiene menos del 20% de energia
	 */
	public void duplicarVelocidad() {
       
		vector.setModulo(6);

		//vector.setModulo(vector.getModulo()*2);

		//particula.getVector().setModulo(8);
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


}
