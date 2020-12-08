package niveles.fabricas;


import entidades.personajes.infectados.InfectadoAlpha;
import entidades.personajes.infectados.InfectadoBeta;
import entidades.personajes.infectados.InfectadoBossAlpha;
import entidades.personajes.infectados.InfectadoBossBeta;
import logica.Juego;
import niveles.Nivel;

public class Nivel1InfectadosAlpha extends FabricaDeTandas{


	public Nivel1InfectadosAlpha(Juego j, Nivel nivel) {
		super(j, nivel, 10);

	}



	@Override 
	public void primeraTanda() {
		crearTanda(cantidadInfectados, new InfectadoAlpha(juego),4);
	}
	
	@Override
	public void segundaTanda() {
		crearTanda(cantidadInfectados*2, new InfectadoAlpha(juego),4);
	}
	public void  elJefe() {
		crearTanda(1,new InfectadoBossAlpha(juego),9);
	}

	

	
}
