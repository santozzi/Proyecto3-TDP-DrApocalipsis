package armas;

import entidades.proyectiles.*;
import logica.Juego;

public abstract class Arma{
	protected Proyectil proyectil;
	protected Juego juego;
	protected String claveImagen;

	public Arma(Juego juego) {
		this.juego = juego;
		this.claveImagen = this.getClass().getSimpleName();
	}

	/**
	 * disparar
	 * --------
	 * Es el encargado de generar nuevos proyectiles	
	 */
	public void disparar() {
		this.claveImagen = this.getClass().getSimpleName()+"_Disparar";
	}
	public String getClaveImagen() {
		return claveImagen;
	}
}
