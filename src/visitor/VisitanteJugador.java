package visitor;

import entidades.personajes.Humano;
import entidades.personajes.infectados.InfectadoAlpha;
import entidades.personajes.infectados.InfectadoBeta;
import entidades.personajes.jugador.Jugador;
import entidades.proyectiles.Particula;
import entidades.proyectiles.Proyectil;
import entidades.proyectiles.ProyectilSanitario;

public class VisitanteJugador extends Visitante {
	private Jugador j;

	public VisitanteJugador(Jugador j) {
		this.j = j;
	}

	@Override
	public void visitarInfectadoAlpha(InfectadoAlpha ea) {
	//	System.out.println("jugador choca a alpha");
			
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

