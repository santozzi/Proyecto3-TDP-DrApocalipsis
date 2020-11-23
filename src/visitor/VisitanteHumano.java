package visitor;

import entidades.personajes.Humano;
import entidades.personajes.infectados.InfectadoAlpha;
import entidades.personajes.infectados.InfectadoBeta;
import entidades.personajes.jugador.Jugador;
import entidades.proyectiles.Particula;
import entidades.proyectiles.Proyectil;
import entidades.proyectiles.ProyectilSanitario;

public class VisitanteHumano extends Visitante {
	
	private Humano humano;
	
	public VisitanteHumano(Humano ps) {
		this.humano = ps;
	}

	@Override
	public void visitarInfectadoAlpha(InfectadoAlpha ia) {

		
	}

	@Override
	public void visitarInfectadoBeta(InfectadoBeta ib) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarJugador(Jugador j) {
		//System.out.println("El alpha el pega al jugador");
		
	}

	@Override
	public void visitarProyectilSanitario(ProyectilSanitario p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarParticula(Particula par) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarHumano(Humano hum) {
		// TODO Auto-generated method stub
		
	}

	

}
