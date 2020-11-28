package niveles;

import java.util.List;


import entidades.Entidad;
import logica.CompositeInfectado;
import logica.Juego;
import niveles.fabricas.FabricaDeTandas;
import niveles.fabricas.Nivel1InfectadosAlpha;

public class Nivel1 extends Nivel{

	public Nivel1(Juego juego) {
		this.juego = juego;
		compInf = new CompositeInfectado();
		this.claveDer= "fondoDerecha";
		this.claveIzq= "fondoIzquierda";
		this.claveFondo= "nivel1";
		this.fabrica = new Nivel1InfectadosAlpha(juego, this);
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
