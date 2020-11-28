package niveles.fabricas;

import logica.Juego;
import niveles.Nivel;

public class Nivel1InfectadosAlpha extends FabricaDeTandas{

	public Nivel1InfectadosAlpha(Juego j, Nivel nivel) {
		this.juego = j;
		this.nivel = nivel;
	}
	
	@Override
	public void crearTanda(int cantidadInfectados) {
		super.crearTanda(cantidadInfectados, new String("Alpha"));
	}

	@Override
	public void losJefes(int cantidadJefesInfectados) {
		super.crearTanda(cantidadJefesInfectados, new String("JefeAlpha"));
	}

}
