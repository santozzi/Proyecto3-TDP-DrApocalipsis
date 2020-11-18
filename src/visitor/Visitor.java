package visitor;

import entidades.personajes.infectados.InfectadoAlpha;
import entidades.personajes.infectados.InfectadoBeta;
import entidades.personajes.jugador.Jugador;
import entidades.proyectiles.Proyectil;

// Clase visitante general. Los nombres de lo métodos son diferentes para poder evitar posibles complicaciones al extender alguna clase concreta. Le pasamos como
// parámetro también los tipos específicos para poder aprovechar los métodos propios de cada clase diferente.

public abstract class Visitor
{
	public abstract void visitarInfectadoAlpha(InfectadoAlpha ea);
	
	public abstract void visitarInfectadoBeta(InfectadoBeta eb);
	
	public abstract void visitarJugador(Jugador J);
	
	public abstract void visitarProyectil(Proyectil p);
}

