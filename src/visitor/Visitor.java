package visitor;

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
import entidades.proyectiles.ParticulaAlpha;
import entidades.proyectiles.ParticulaBeta;
import entidades.proyectiles.Proyectil;
import entidades.proyectiles.ProyectilSanitario;
import entidades.proyectiles.SuperProyectilSanitario;

// Clase visitante general. Los nombres de lo métodos son diferentes para poder evitar posibles complicaciones al extender alguna clase concreta. Le pasamos como
// parámetro también los tipos específicos para poder aprovechar los métodos propios de cada clase diferente.

public abstract class Visitor
{
	abstract public void visitarInfectadoAlpha(InfectadoAlpha ea);
	
	abstract public void visitarInfectadoBeta(InfectadoBeta eb);
	
	abstract public void visitarJugador(Jugador J);
	
	abstract public void visitarProyectilSanitario(ProyectilSanitario p);
	
	abstract public void visitarParticulaAlpha(ParticulaAlpha par);
	abstract public void visitarParticulaBeta(ParticulaBeta par);
	abstract public void visitarHumano(Humano hum);
	
	abstract public void visitarPocion(Pocion pos);

	abstract public void visitarCuarentena(Cuarentena cuarentena);
	abstract public void visitarSuperProyectilSanitario(SuperProyectilSanitario sps);
	abstract public void visitarSuperArma(SuperArma sarm);
	abstract public void visitarInfectadoBossAlpha(InfectadoBossAlpha ifboss);	
	abstract public void visitarInfectadoBossBeta(InfectadoBossBeta ifboss);
}

