package visitor;

import entidades.personajes.infectados.InfectadoAlpha;
import entidades.personajes.infectados.InfectadoBeta;
import entidades.personajes.jugador.Jugador;
import entidades.proyectiles.Proyectil;

public class VisitanteInfectadoBeta extends Visitante {
	
	private InfectadoBeta infectadoBeta;
	
	public VisitanteInfectadoBeta(InfectadoBeta ib) {
		this.infectadoBeta = ib;
	}

	@Override
	public void visitarInfectadoAlpha(InfectadoAlpha ea) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarInfectadoBeta(InfectadoBeta eb) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarJugador(Jugador J) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarProyectil(Proyectil p) {
		// TODO Auto-generated method stub
		
	}

}
