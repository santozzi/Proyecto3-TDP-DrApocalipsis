package niveles.fabricas;


import entidades.personajes.infectados.InfectadoAlpha;
import entidades.personajes.infectados.InfectadoBeta;
import entidades.personajes.infectados.InfectadoBossAlpha;
import logica.Juego;
import niveles.Nivel;

public class Nivel3InfectadosMixto extends FabricaDeTandas {

	public Nivel3InfectadosMixto(Juego j,Nivel nivel) {
		super(j,nivel,20);
	}



	@Override
	public void primeraTanda() {
		//crearTanda(1,new InfectadoBossAlpha(juego),9);
		crearTanda(cantidadInfectados, new InfectadoAlpha(juego),4);
		crearTanda(cantidadInfectados, new InfectadoBeta(juego),5);
	}

	@Override
	public void segundaTanda() {
		crearTanda(cantidadInfectados, new InfectadoAlpha(juego),4);
		crearTanda(cantidadInfectados, new InfectadoBeta(juego),5);
		
	}

	@Override
	public void elJefe() {
		crearTanda(1,new InfectadoBossAlpha(juego),9);
		crearTanda(1,new InfectadoBossBeta(juego),9);
		
	}
}
