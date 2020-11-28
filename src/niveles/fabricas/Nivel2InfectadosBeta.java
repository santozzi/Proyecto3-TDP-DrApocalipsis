package niveles.fabricas;

import logica.Juego;
import niveles.Nivel;

public class Nivel2InfectadosBeta extends FabricaDeTandas {

	public Nivel2InfectadosBeta(Juego j, Nivel nivel) {
		this.juego = j;
		this.nivel = nivel;
	}

	@Override
	public void crearTanda(int cantidadInfectados) {
		super.crearTanda(cantidadInfectados, new String("Beta"));
	}

	@Override
	public void losJefes(int cantidadJefesInfectados) {
		super.crearTanda(cantidadJefesInfectados, new String("JefeBeta"));
	}
}
