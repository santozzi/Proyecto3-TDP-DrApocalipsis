package entidades.premios.temporales;

import entidades.premios.Premio;
import logica.Juego;

public abstract class Temporal extends Premio {
	
	protected int tiempo;
	public Temporal(Juego juego) {
		super(juego);
	}

	
}
