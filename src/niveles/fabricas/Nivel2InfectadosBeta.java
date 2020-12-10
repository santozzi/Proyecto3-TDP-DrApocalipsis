package niveles.fabricas;

import entidades.personajes.infectados.InfectadoBeta;
import entidades.personajes.infectados.InfectadoBossBeta;
import logica.Juego;
import niveles.Nivel;

public class Nivel2InfectadosBeta extends FabricaDeTandas {
	

	public Nivel2InfectadosBeta(Juego j, Nivel nivel) {
		super(j, nivel, 10);

	}



	@Override
	public void primeraTanda() {
		crearTanda(cantidadInfectados, new InfectadoBeta(juego),4,Juego.ALTO_DE_COMBATE);
	}

	@Override
	public void segundaTanda() {
		crearTanda(cantidadInfectados*2, new InfectadoBeta(juego),5,Juego.ALTO_DE_COMBATE*2);
	}

	@Override
	public void elJefe() {	
		crearTanda(1,new InfectadoBossBeta(juego),9,1);
	}
}
