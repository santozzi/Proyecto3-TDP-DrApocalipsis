package entidades.premios.no_temporales;

import entidades.premios.Premio;
import logica.Juego;
/**
 *NoTemporal
 *Son los premios que no dependen de un intervalo de tiempo 
 *
 */
public abstract class NoTemporal extends Premio {

	public NoTemporal(Juego juego) {
		super(juego);
	}

}
