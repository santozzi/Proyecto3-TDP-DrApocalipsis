package armas;
import entidades.proyectiles.*;
import logica.Juego;
import entidades.Entidad;
import entidades.personajes.jugador.Jugador;

public abstract class Arma{
	protected Proyectil proyectil;
	protected Juego juego;

	
public Arma(Juego juego) {
		this.juego = juego;
	}

/**
 * disparar
 * --------
 * Es el encargado de generar nuevos proyectiles	
 */
abstract public void disparar();

}
