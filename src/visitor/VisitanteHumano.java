package visitor;

import entidades.CuadroDeDialogo;
import entidades.personajes.Humano;
import entidades.personajes.infectados.InfectadoAlpha;
import entidades.personajes.infectados.InfectadoBeta;
import entidades.personajes.infectados.InfectadoBoss;
import entidades.personajes.infectados.InfectadoBossAlpha;
import entidades.personajes.infectados.InfectadoBossBeta;
import entidades.personajes.jugador.Jugador;
import entidades.premios.no_temporales.Diamante;
import entidades.premios.no_temporales.Moneda;
import entidades.premios.no_temporales.Pocion;
import entidades.premios.temporales.Cuarentena;
import entidades.premios.temporales.SuperArma;
import entidades.proyectiles.Proyectil;
import entidades.proyectiles.particulas.ParticulaAlpha;
import entidades.proyectiles.particulas.ParticulaBeta;
import entidades.proyectiles.proyectil_jugador.ProyectilSanitario;
import entidades.proyectiles.proyectil_jugador.SuperProyectilSanitario;

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
		if(!humano.soltoPremio()) {
			humano.dejarCaerPremio();
			humano.getVector().setModulo(8);
		}
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarInfectadoBossBeta(InfectadoBossBeta ifboss) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarCuadroDeDialogo(CuadroDeDialogo cd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarMoneda(Moneda mon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarDiamante(Diamante dia) {
		// TODO Auto-generated method stub
		
	}



}
