package armas;
import entidades.proyectiles.*;
import logica.Juego;

import javax.swing.ImageIcon;

import entidades.Entidad;
import entidades.personajes.jugador.Jugador;

public abstract class Arma{
	protected Proyectil proyectil;
	protected Juego juego;
	protected ImageIcon imagen;
	protected String claveImagen;

	public Arma(Juego juego) {
		this.juego = juego;
	}

	/**
	 * disparar
	 * --------
	 * Es el encargado de generar nuevos proyectiles	
	 */
	abstract public void disparar();

	public ImageIcon getImagen() {
		// TODO Auto-generated method stub
		return imagen;
	}
	public String getClaveImagen() {
		return claveImagen;
	}
}
