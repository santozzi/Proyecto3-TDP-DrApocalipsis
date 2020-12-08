package niveles.fabricas;


import entidades.personajes.infectados.InfectadoAlpha;
import entidades.personajes.infectados.InfectadoBeta;
import entidades.personajes.infectados.InfectadoBossAlpha;
import logica.Juego;
import niveles.Nivel;

public class Nivel3InfectadosMixto extends FabricaDeTandas {

	public Nivel3InfectadosMixto(Juego j,Nivel nivel) {
		super(j,nivel,30);
	}



	@Override
	public void primeraTanda() {
		//crearTanda(1,new InfectadoBossAlpha(juego),9);
		crearTanda(cantidadInfectados, new InfectadoAlpha(juego),4,Juego.ALTO_DE_COMBATE*3);
		crearTanda(cantidadInfectados, new InfectadoBeta(juego),5,Juego.ALTO_DE_COMBATE*3);
	}

	@Override
	public void segundaTanda() {
		crearTanda(cantidadInfectados, new InfectadoAlpha(juego),4,Juego.ALTO_DE_COMBATE*3);
		crearTanda(cantidadInfectados, new InfectadoBeta(juego),5,Juego.ALTO_DE_COMBATE*3);
		//crearTanda(1,new InfectadoBossAlpha(juego),9);
		
	}

	@Override
	public void elJefe() {
		crearTanda(1,new InfectadoBossAlpha(juego),9,1);
	//	crearTanda(1,new InfectadoBossBeta(juego),9);
		
	}
}
