package niveles.fabricas;


import entidades.personajes.infectados.InfectadoAlpha;
import entidades.personajes.infectados.InfectadoBeta;
import entidades.personajes.infectados.InfectadoBossAlpha;
import entidades.personajes.infectados.InfectadoBossBeta;
import logica.Juego;
import niveles.Nivel;

public class Nivel3InfectadosMixto extends FabricaDeTandas {

	public Nivel3InfectadosMixto(Juego j,Nivel nivel) {
		super(j,nivel,5);
	}



	@Override
	public void primeraTanda() {
		crearTanda(cantidadInfectados, new InfectadoAlpha(juego));
		crearTanda(cantidadInfectados, new InfectadoBeta(juego));
	}

	@Override
	public void segundaTanda() {
		crearTanda(cantidadInfectados, new InfectadoAlpha(juego));
		crearTanda(cantidadInfectados, new InfectadoBeta(juego));
		crearTanda(1,new InfectadoBossAlpha(juego));
		
	}

	@Override
	public void elJefe() {
		crearTanda(1,new InfectadoBossAlpha(juego));
		crearTanda(1,new InfectadoBossBeta(juego));
		
	}
}
