package niveles.fabricas;


import entidades.personajes.infectados.InfectadoAlpha;
import entidades.personajes.infectados.InfectadoBeta;
import entidades.personajes.infectados.InfectadoBossAlpha;
import entidades.personajes.infectados.InfectadoBossBeta;
import logica.Juego;
import niveles.Nivel;

public class Nivel1InfectadosAlpha extends FabricaDeTandas{


	public Nivel1InfectadosAlpha(Juego j, Nivel nivel) {
		super(j, nivel, 5);

	}



	@Override 
	public void primeraTanda() {
		crearTanda(cantidadInfectados, new InfectadoAlpha(juego),4);
		crearTanda(cantidadInfectados, new InfectadoBeta(juego),4);
		crearTanda(1,new InfectadoBossAlpha(juego),9);
		crearTanda(1,new InfectadoBossBeta(juego),9);
	}
	
	@Override
	public void segundaTanda() {
		crearTanda(cantidadInfectados*2, new InfectadoAlpha(juego),4);
	}
	public void  elJefe() {
		crearTanda(1,new InfectadoBossAlpha(juego),9);
	}

	

	
}
