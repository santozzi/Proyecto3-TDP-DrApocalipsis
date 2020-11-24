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

public class VisitanteProyectilSanitario extends Visitante {
	
	private ProyectilSanitario proyectilSanitario;
	
	public VisitanteProyectilSanitario(ProyectilSanitario ps) {
		this.proyectilSanitario = ps;
	}

	@Override
	public void visitarInfectadoAlpha(InfectadoAlpha ia) {
	//	ia.detenerse();
	    ia.impacto(proyectilSanitario.getLetalidad());
	   
	    
	  //  System.out.println("infectadoAlpha energia "+ia.getEnergia());
		proyectilSanitario.detenerse();
		proyectilSanitario.desaparecer();
				
		
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
