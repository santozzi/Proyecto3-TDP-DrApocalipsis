package entidades.personajes;

import entidades.Entidad;
import logica.Juego;
/**
 * 
 * Es una especialización de la entidad, los enemigos del juego y el jugador mismo son
 * personajes. 
 *
 */
public abstract class Personaje extends Entidad {
	//Es la energia del personaje
	protected int cargaViral;


	public Personaje(Juego juego) {
		super(juego);
	}

	public void impacto(int disparo) {
		if(cargaViral-disparo>0) {
			this.cargaViral -=disparo;

		}else {
			desaparecer();
		}
	} 


	/**
	 * getCargaViral
	 * @return la cantidad de carga viral que tiene el personaje.
	 */
	public int getCargaViral() {
		return cargaViral;
	}

}
