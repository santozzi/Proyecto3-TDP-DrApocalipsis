package niveles;

import logica.CompositeInfectado;
import logica.Juego;
import niveles.fabricas.Nivel2InfectadosBeta;

public class Nivel2 extends Nivel {
    public Nivel2(Juego juego) {
		this.juego = juego;
		compInf = new CompositeInfectado();
		this.claveDer= "fondoDerecha";
		this.claveIzq= "fondoIzquierda";
		this.claveFondo= "nivel2";
		this.fabrica = new Nivel2InfectadosBeta(juego, this);
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
