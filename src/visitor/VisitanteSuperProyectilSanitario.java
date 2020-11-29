package visitor;

import entidades.CuadroDeDialogo;
import entidades.personajes.Humano;
import entidades.personajes.infectados.InfectadoAlpha;
import entidades.personajes.infectados.InfectadoBeta;
import entidades.personajes.infectados.InfectadoBoss;
import entidades.personajes.infectados.InfectadoBossAlpha;
import entidades.personajes.infectados.InfectadoBossBeta;
import entidades.personajes.jugador.Jugador;
import entidades.premios.no_temporales.Pocion;
import entidades.premios.temporales.Cuarentena;
import entidades.premios.temporales.SuperArma;
import entidades.proyectiles.Proyectil;
import entidades.proyectiles.particulas.ParticulaAlpha;
import entidades.proyectiles.particulas.ParticulaBeta;
import entidades.proyectiles.proyectiljugador.ProyectilSanitario;
import entidades.proyectiles.proyectiljugador.SuperProyectilSanitario;

public class VisitanteSuperProyectilSanitario extends Visitante {
	
	private SuperProyectilSanitario superProyectilSanitario;
	
    

	public VisitanteSuperProyectilSanitario(SuperProyectilSanitario superProyectilSanitario) {
		this.superProyectilSanitario = superProyectilSanitario;
	}

	@Override
	public void visitarInfectadoAlpha(InfectadoAlpha ia) {
		 ia.impacto(superProyectilSanitario.getLetalidad());
			superProyectilSanitario.detenerse();
			superProyectilSanitario.desaparecer();
		
	}

	@Override
	public void visitarInfectadoBeta(InfectadoBeta ib) {
		 ib.impacto(superProyectilSanitario.getLetalidad());
			superProyectilSanitario.detenerse();
			superProyectilSanitario.desaparecer();
		
	}

	@Override
	public void visitarJugador(Jugador j) {
		
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

	@Override
	public void visitarParticulaBeta(ParticulaBeta par) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarSuperProyectilSanitario(SuperProyectilSanitario sps) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarSuperArma(SuperArma sarm) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void visitarInfectadoBossAlpha(InfectadoBossAlpha ifboss) {
		 ifboss.impacto(superProyectilSanitario.getLetalidad());
			superProyectilSanitario.detenerse();
			superProyectilSanitario.desaparecer();
		
	}

	@Override
	public void visitarInfectadoBossBeta(InfectadoBossBeta ifboss) {
		 ifboss.impacto(superProyectilSanitario.getLetalidad());
			superProyectilSanitario.detenerse();
			superProyectilSanitario.desaparecer();
		
	}

	@Override
	public void visitarCuadroDeDialogo(CuadroDeDialogo cd) {
		// TODO Auto-generated method stub
		
	}

	

}
