package niveles;

import java.util.List;

import javax.swing.ImageIcon;

import entidades.Entidad;
import logica.ColeccionDeImagenes;
import logica.ListaDeInfectados;
import logica.Juego;
import niveles.fabricas.FabricaDeTandas;

public abstract class Nivel {
	protected Juego juego;
	protected String claveIzq;
	protected String claveDer;
	protected String claveFondo;
	protected ImageIcon imagenIzq;
	protected ImageIcon imagenDer;
	protected ImageIcon imagenFondo;

	protected FabricaDeTandas fabrica;
	protected ListaDeInfectados compInf;

	public Nivel(Juego juego) {
		this.juego = juego;
		this.compInf = new ListaDeInfectados();

		String clase = this.getClass().getSimpleName();
		this.claveDer = clase+"_Derecha";
		this.claveIzq = clase+"_Izquierda";
		this.claveFondo = clase+"_Fondo";
		this.imagenDer = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(this.claveDer);
		this.imagenIzq = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(this.claveIzq);
		this.imagenFondo = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(this.claveFondo);

	}

	/**
	 * Crea la primera tanda del nivel
	 * -------------------------------
	 * @return Lista de infectados creados en la fabrica
	 */
	public List<Entidad> primeraTanda() {
		this.fabrica.primeraTanda();
		return this.compInf.getListaDeInfectados();
	}
	
	/**
	 * Crea la segunda tanda del nivel
	 * -------------------------------
	 * @return Lista de infectados creados en la fabrica
	 */
	public List<Entidad> segundaTanda() {
		this.fabrica.segundaTanda();
		return this.compInf.getListaDeInfectados();
	}
	
	/**
	 * Crea la tanda del jefe del nivel
	 * -------------------------------
	 * @return Lista de infectados con los jefes creados en la fabrica
	 */
	public List<Entidad> elJefe(){
		this.fabrica.elJefe();
		return this.compInf.getListaDeInfectados();
	}

	/**
	 * Retorna la lista de infectados del nivel actual
	 * -----------------------------------------------
	 * @return Lista de infectados del nivel actual
	 */
	public ListaDeInfectados getColeccionDeInfectados() {
		return this.compInf;
	}
	
	/**
	 * Retorna la clave de la imagen de fondo izquierda
	 * ------------------------------------------------
	 * @return Clave de la imagen de fondo izquierda
	 */
	public String getClaveIzq() {
		return claveIzq;
	}

	/**
	 * Carga la clave de la imagen izquierda de fondo pasada por parametro
	 * --------------------------------------------------------------
	 * @param claveIzq : Clave de la imagen izquierda de fondo
	 */
	public void setClaveIzq(String claveIzq) {
		this.claveIzq = claveIzq;
	}

	/**
	 * Retorna la clave de la imagen de fondo derecha
	 * ----------------------------------------------
	 * @return Clave de la imagen de fondo derecha
	 */
	public String getClaveDer() {
		return claveDer;
	}

	/**
	 * Carga la clave de la imagen derecha de fondo pasada por parametro
	 * --------------------------------------------------------------
	 * @param claveDer : Clave de la imagen derecha de fondo
	 */
	public void setClaveDer(String claveDer) {
		this.claveDer = claveDer;
	}

	/**
	 * Retorna la clave de la imagen central de fondo
	 * -----------------------------------------------
	 * @return Clave de la imagen central de fondo
	 */
	public String getClaveFondo() {
		return claveFondo;
	}

	/**
	 * Carga la clave de la imagen central de fondo pasada por parametro
	 * --------------------------------------------------------------
	 * @param claveFondo : Clave de la imagen central de fondo
	 */
	public void setClaveFondo(String claveFondo) {
		this.claveFondo = claveFondo;
	}

	/**
	 * Retorna la imagen izquierda de fondo
	 * ---------------------------------
	 * @return Imagen izquierda de fondo
	 */
	public ImageIcon getImagenIzq() {
		return ColeccionDeImagenes.getColeccionDeImagenes().getImagen(claveIzq);
	}

	/**
	 * Retorna la imagen derecha de fondo
	 * -------------------------------
	 * @return Imagen derecha de fondo
	 */
	public ImageIcon getImagenDer() {
		return ColeccionDeImagenes.getColeccionDeImagenes().getImagen(claveDer);
	}

	/**
	 * Retorna la imagen central de fondo
	 * -------------------------------
	 * @return Imagen central de fondo
	 */
	public ImageIcon getImagenFondo() {
		return ColeccionDeImagenes.getColeccionDeImagenes().getImagen(claveFondo);
	}

}
