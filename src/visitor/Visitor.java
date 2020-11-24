package visitor;

import entidades.personajes.Humano;
import entidades.personajes.infectados.InfectadoAlpha;
import entidades.personajes.infectados.InfectadoBeta;
import entidades.personajes.jugador.Jugador;
import entidades.premios.no_temporales.Pocion;
import entidades.proyectiles.ParticulaAlpha;
import entidades.proyectiles.Proyectil;
import entidades.proyectiles.ProyectilSanitario;

// Clase visitante general. Los nombres de lo métodos son diferentes para poder evitar posibles complicaciones al extender alguna clase concreta. Le pasamos como
// parámetro también los tipos específicos para poder aprovechar los métodos propios de cada clase diferente.

public abstract class Visitor
{
	public abstract void visitarInfectadoAlpha(InfectadoAlpha ea);
	
	public abstract void visitarInfectadoBeta(InfectadoBeta eb);
	
	public abstract void visitarJugador(Jugador J);
	
	public abstract void visitarProyectilSanitario(ProyectilSanitario p);
	
	abstract public void visitarParticulaAlpha(ParticulaAlpha par);
	
	abstract public void visitarHumano(Humano hum);
	
	abstract public void visitarPocion(Pocion pos);
}

