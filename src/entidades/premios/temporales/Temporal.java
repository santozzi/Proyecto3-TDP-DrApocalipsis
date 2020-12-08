package entidades.premios.temporales;

import entidades.premios.Premio;
import logica.Juego;
/**
 * Temporal
 * Son los premios que se ejecutan solo por un determinado itervalo de tiempo.
 *
 */
public abstract class Temporal extends Premio {
	
	protected int tiempo;
	public Temporal(Juego juego) {
		super(juego);
	}

	
}
