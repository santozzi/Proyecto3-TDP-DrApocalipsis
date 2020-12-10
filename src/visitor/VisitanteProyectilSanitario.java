package visitor;

import entidades.CuadroDeDialogo;
import entidades.personajes.Humano;
import entidades.personajes.infectados.InfectadoAlpha;
import entidades.personajes.infectados.InfectadoBeta;
import entidades.personajes.infectados.InfectadoBossAlpha;
import entidades.personajes.infectados.InfectadoBossBeta;
import entidades.personajes.jugador.Jugador;
import entidades.premios.no_temporales.Diamante;
import entidades.premios.no_temporales.Moneda;
import entidades.premios.no_temporales.Pocion;
import entidades.premios.temporales.Cuarentena;
import entidades.premios.temporales.SuperArma;
import entidades.proyectiles.particulas.ParticulaAlpha;
import entidades.proyectiles.particulas.ParticulaBeta;
import entidades.proyectiles.proyectil_jugador.ProyectilSanitario;
import entidades.proyectiles.proyectil_jugador.SuperProyectilSanitario;

public class VisitanteProyectilSanitario extends Visitante {
	
	private ProyectilSanitario proyectilSanitario;
	
	public VisitanteProyectilSanitario(ProyectilSanitario ps) {
		this.proyectilSanitario = ps;
	}

	@Override
	public void visitarInfectadoAlpha(InfectadoAlpha ia) {
	    ia.impacto(proyectilSanitario.getLetalidad());
		proyectilSanitario.detenerse();
		proyectilSanitario.desaparecer();
		
	}

	@Override
	public void visitarInfectadoBeta(InfectadoBeta ib) {
	    ib.impacto(proyectilSanitario.getLetalidad());
		proyectilSanitario.detenerse();
		proyectilSanitario.desaparecer();
		
	}

	@Override
	public void visitarJugador(Jugador j) {
		
	}

	@Override
	public void visitarProyectilSanitario(ProyectilSanitario p) {
		
	}



	@Override
	public void visitarHumano(Humano hum) {
		
	}

	@Override
	public void visitarParticulaAlpha(ParticulaAlpha par) {
		
	}

	@Override
	public void visitarPocion(Pocion pos) {
		
	}

	@Override
	public void visitarCuarentena(Cuarentena cuarentena) {
		
	}

	@Override
	public void visitarParticulaBeta(ParticulaBeta par) {
		
	}

	@Override
	public void visitarSuperProyectilSanitario(SuperProyectilSanitario sps) {
		
	}

	@Override
	public void visitarSuperArma(SuperArma sarm) {
		
	}



	@Override
	public void visitarInfectadoBossAlpha(InfectadoBossAlpha ifboss) {
		ifboss.impacto(proyectilSanitario.getLetalidad());
		proyectilSanitario.detenerse();
		proyectilSanitario.desaparecer();
		
	}

	@Override
	public void visitarInfectadoBossBeta(InfectadoBossBeta ifboss) {
		ifboss.impacto(proyectilSanitario.getLetalidad());
		proyectilSanitario.detenerse();
		proyectilSanitario.desaparecer();
		
	}

	@Override
	public void visitarCuadroDeDialogo(CuadroDeDialogo cd) {
		
	}

	@Override
	public void visitarMoneda(Moneda mon) {
		
	}

	@Override
	public void visitarDiamante(Diamante dia) {
		
	}

	

}
