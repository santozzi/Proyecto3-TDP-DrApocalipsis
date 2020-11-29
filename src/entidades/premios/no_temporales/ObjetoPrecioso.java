package entidades.premios.no_temporales;

import logica.Juego;
import logica.Vector;

abstract public class ObjetoPrecioso extends NoTemporal {

	public ObjetoPrecioso(Juego juego) {
		super(juego);
		vector = new Vector(0,1,1);
	}

}
