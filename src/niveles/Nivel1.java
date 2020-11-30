package niveles;

import logica.Juego;
import niveles.fabricas.Nivel1InfectadosAlpha;

public class Nivel1 extends Nivel{

	public Nivel1(Juego juego) {
		super(juego);
		this.fabrica = new Nivel1InfectadosAlpha(juego, this);
	}
}
