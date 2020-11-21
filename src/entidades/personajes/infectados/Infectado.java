package entidades.personajes.infectados;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

import entidades.Entidad;
import entidades.Vector;
import entidades.personajes.Personaje;
import entidades.premios.Premio;
import entidades.premios.no_temporales.Pocion;
import entidades.premios.temporales.Cuarentena;
import entidades.premios.temporales.SuperArma;
import entidades.proyectiles.Particula;
import logica.ColeccionDeImagenes;
import logica.Juego;
import visitor.VisitanteInfectadoAlpha;
import visitor.Visitor;

public abstract class Infectado extends Personaje {

	protected Particula particula;
	protected Premio premio;
	protected int rango;

	/**
	 * tirarParticulas
	 * ---------------
	 * Son las particulas que lanza el infectado
	 * estas particulas son de tipo Proyectil
	 */
	


	/**
	 * atacar
	 * ------
	 * Genera daño a lo que tenga adelante.
	 */
	public void atacar() {
		imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen("infectado_atacar");
		
		v.visitarJugador(juego.getJugador());
	}
    public void tirarParticula() {}
	/**
	 *dejarCaerPremio
	 *---------------
	 *Genera un nuevo objerto de tipo premio
	 *y lo agrega a la colección de entidades.
	 */
	public void dejarCaerPremio() {
		Random random = new Random();
		int randomInt = random.nextInt(3);

		if(randomInt == 0)
			premio = new SuperArma();
		else if(randomInt == 1)
			premio = new Cuarentena();
		else
			premio = new Pocion();

		premio.getPosicion().setLocation(posicion);
	}

	public boolean estaMuerto() {
		return energia<=0;
	}



	abstract public void accept(Visitor v);
	//	v.visitarInfectadoAlpha(this);
	
	@Override
	public ImageIcon getImagen() {
		return imagen;
	}
    

	
	

	
	
	public Vector getVector() {
		return vector;
	}

	
	public Point getPosicion() {
		return posicion;
	}

   	
	public void detenerse() {
		vector.setModulo(0);

	}
	public int getRango() {
		return rango;
	}
}
