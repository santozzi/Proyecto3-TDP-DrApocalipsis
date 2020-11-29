package armas;

import entidades.proyectiles.*;
import logica.Juego;

import javax.swing.ImageIcon;

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
		return imagen;
	}
	public String getClaveImagen() {
		return claveImagen;
	}
}
