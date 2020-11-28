package niveles;

import logica.CompositeInfectado;
import logica.Juego;
import niveles.fabricas.Nivel3InfectadosMixto;

public class Nivel3 extends Nivel {
	public Nivel3(Juego juego) {
		this.juego = juego;
		this.compInf = new CompositeInfectado();
		this.claveDer= "fondoDerecha";
		this.claveIzq= "fondoIzquierda";
		this.claveFondo= "nivel2";
		this.fabrica = new Nivel3InfectadosMixto(juego, this);
	}

	@Override
	public void crearTanda() {
		this.fabrica.crearTanda(4);
	}
	@Override
	public void losJefes() {
		this.fabrica.losJefes(1);
	}
}
