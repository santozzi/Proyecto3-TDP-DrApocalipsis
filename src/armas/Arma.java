package armas;

import logica.Juego;
/**
 * Arma
 * Es el arma que tiene el jugador su objetivo es crear proyectiles
 */
public abstract class Arma{
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
