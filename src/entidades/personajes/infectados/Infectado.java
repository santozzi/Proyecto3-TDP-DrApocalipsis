package entidades.personajes.infectados;

import entidades.personajes.Personaje;
import entidades.premios.Premio;
import entidades.proyectiles.Particula;

public abstract class Infectado extends Personaje {

	protected Particula particula;
	protected Premio premio;

	/**
	 * tirarParticulas
	 * ---------------
	 * Son las particulas que lanza el infectado
	 * estas particulas son de tipo Proyectil
	 */

	abstract public void tirarParticula();

	/**
	 * atacar
	 * ------
	 * Genera daño a lo que tenga adelante.
	 */
	abstract public void atacar();

	/**
	 *dejarCaerPremio
	 *---------------
	 *Genera un nuevo objerto de tipo premio
	 *y lo agrega a la colección de entidades.
	 */
	abstract public void dejarCaerPremio();
	
}
