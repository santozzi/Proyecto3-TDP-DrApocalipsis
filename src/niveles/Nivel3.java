package niveles;

import logica.Juego;
import niveles.fabricas.Nivel3InfectadosMixto;

public class Nivel3 extends Nivel {
	
	public Nivel3(Juego juego) {
		super(juego);
		this.fabrica = new Nivel3InfectadosMixto(juego, this);
	}
}
