package visitor;

import entidades.personajes.Humano;
import entidades.personajes.infectados.InfectadoAlpha;
import entidades.personajes.infectados.InfectadoBeta;
import entidades.personajes.jugador.Jugador;
import entidades.premios.no_temporales.Pocion;
import entidades.premios.temporales.Cuarentena;
import entidades.proyectiles.ParticulaAlpha;
import entidades.proyectiles.Proyectil;
import entidades.proyectiles.ProyectilSanitario;

public class VisitanteCuarentena extends Visitante {
	
	private Cuarentena cuarentena;
	
	public VisitanteCuarentena(Cuarentena c) {
		this.cuarentena = c;
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
		cuarentena.ejecutar();
		cuarentena.desplazarse();
        cuarentena.desaparecer();
	}

	@Override
	public void visitarProyectilSanitario(ProyectilSanitario p) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void visitarHumano(Humano hum) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarParticulaAlpha(ParticulaAlpha par) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarPocion(Pocion pos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarCuarentena(Cuarentena cuarentena) {
		// TODO Auto-generated method stub
		
	}

	

}
