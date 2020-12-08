package entidades.premios.no_temporales;

import logica.Juego;

/**
 *ObjetoPrecioso
 *Son los premios que le dan una habilidad o recargan la vida del jugador 
 *
 */

abstract public class ObjetoPrecioso extends NoTemporal {

	public ObjetoPrecioso(Juego juego) {
		super(juego);
	}

}
