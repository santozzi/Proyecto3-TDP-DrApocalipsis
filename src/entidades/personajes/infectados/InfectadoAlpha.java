package entidades.personajes.infectados;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

import entidades.Vector;
import entidades.premios.*;
import entidades.premios.no_temporales.Pocion;
import entidades.premios.temporales.Cuarentena;
import entidades.premios.temporales.SuperArma;
import entidades.proyectiles.Particula;
import entidades.Entidad;
import logica.Imagen;
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
		this.vector = new Vector(0, 1, 1000);
		this.energia = 80;
		this.posicion = new Point();
		this.imagen = new Imagen();
		imagen.setImagen("InfectadoAlpha_golpear");

		v = new VisitanteInfectadoAlpha(this);
	}

	/**
	 * duplicarVelocidad
	 * -----------------
	 * Duplica la velocidad del personaje
	 * cuando este tiene menos del 20% de energia
	 */
	public void duplicarVelocidad() {
		vector.setModulo(vector.getModulo()*2);
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}
	

}
