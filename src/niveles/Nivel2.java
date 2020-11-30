package niveles;

import logica.Juego;
import niveles.fabricas.Nivel2InfectadosBeta;

public class Nivel2 extends Nivel {
	
	public Nivel2(Juego juego) {
		super(juego);
		this.fabrica = new Nivel2InfectadosBeta(juego, this);
	}
}
