package entidades.personajes.infectados;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import entidades.Entidad;
import entidades.Vector;
import entidades.personajes.Personaje;
import entidades.premios.Premio;
import entidades.premios.no_temporales.Pocion;
import entidades.premios.temporales.Cuarentena;
import entidades.premios.temporales.SuperArma;
import entidades.proyectiles.Particula;
import logica.Imagen;
import logica.Juego;
import visitor.VisitanteInfectadoAlpha;
import visitor.Visitor;

public abstract class Infectado extends Personaje {

	protected Particula particula;
	protected Premio premio;

	/**
	 * tirarParticulas
	 * ---------------
	 * Son las particulas que lanza el infectado
	 * estas particulas son de tipo Proyectil
	 */
	public void tirarParticula() {
		particula = new Particula(juego);
	}


	/**
	 * atacar
	 * ------
	 * Genera daño a lo que tenga adelante.
	 */
	public void atacar() {
		imagen.setImagen("infectado_atacar");
		v.visitarJugador(juego.getJugador());
	}

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
	public void desplazarse() {
		//this.posicion.y++;
		this.vector.desplazarse();
		//pregunatar cuando se choca con el limite del mapa
	}


	abstract public void accept(Visitor v);
	//	v.visitarInfectadoAlpha(this);
	
	public Imagen getImagen() {
		return imagen;
	}
    
	 public ArrayList<Entidad> detectarColisiones() {return null;}
	
	
	 public void  accionar() {}
	
	
	public Vector getVector() {
		return vector;
	}

	
	public Point getPosicion() {
		return posicion;
	}

   	
	public void detenerse() {
		vector.setModulo(0);

	}
}
