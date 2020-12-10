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

public class VisitanteMoneda extends Visitante{

	protected Moneda moneda;
	
	public VisitanteMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	@Override
	public void visitarInfectadoAlpha(InfectadoAlpha ea) {
		
	}

	@Override
	public void visitarInfectadoBeta(InfectadoBeta eb) {
		
	}

	@Override
	public void visitarJugador(Jugador J) {
		moneda.ejecutar();
		//moneda.detenerse();
       
		
	}

	@Override
	public void visitarProyectilSanitario(ProyectilSanitario p) {
		
	}

	@Override
	public void visitarParticulaAlpha(ParticulaAlpha par) {
		
	}

	@Override
	public void visitarParticulaBeta(ParticulaBeta par) {
		
	}

	@Override
	public void visitarHumano(Humano hum) {
		
	}

	@Override
	public void visitarPocion(Pocion pos) {
		
	}

	@Override
	public void visitarCuarentena(Cuarentena cuarentena) {
		
	}

	@Override
	public void visitarSuperProyectilSanitario(SuperProyectilSanitario sps) {
		
	}

	@Override
	public void visitarSuperArma(SuperArma sarm) {
		
	}

	@Override
	public void visitarInfectadoBossAlpha(InfectadoBossAlpha ifboss) {
		
	}

	@Override
	public void visitarInfectadoBossBeta(InfectadoBossBeta ifboss) {
		
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
