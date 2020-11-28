package niveles.fabricas;

import logica.Juego;
import niveles.Nivel;

public class Nivel3InfectadosMixto extends FabricaDeTandas {

	public Nivel3InfectadosMixto(Juego j, Nivel nivel) {
		this.juego = j;
		this.nivel = nivel;
	}
	
	@Override
	public void crearTanda(int cantidadInfectados) {
		super.crearTanda(cantidadInfectados, new String("Mixto"));
	}

	@Override
	public void losJefes(int cantidadJefesInfectados) {
		super.crearTanda(cantidadJefesInfectados, new String("JefeMixto"));
	}
}
