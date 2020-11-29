package niveles.fabricas;


import entidades.personajes.infectados.InfectadoAlpha;
import entidades.personajes.infectados.InfectadoBossAlpha;
import logica.Juego;
import niveles.Nivel;

public class Nivel1InfectadosAlpha extends FabricaDeTandas{


	public Nivel1InfectadosAlpha(Juego j, Nivel nivel) {
		super(j, nivel, 4);

	}



	@Override 
	public void primeraTanda() {
		crearTanda(cantidadInfectados, new InfectadoAlpha(juego));
		posiciones.clear();
	}
	
	@Override
	public void segundaTanda() {
		crearTanda(8, new InfectadoAlpha(juego));
		posiciones.clear();
	}
	public void  elJefe() {
		crearTanda(1,new InfectadoBossAlpha(juego));
		posiciones.clear();
	}
	
}
