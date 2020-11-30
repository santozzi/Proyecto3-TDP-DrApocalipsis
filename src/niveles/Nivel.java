package niveles;

import java.util.List;

import javax.swing.ImageIcon;

import entidades.Entidad;
import logica.ColeccionDeImagenes;
import logica.CompositeInfectado;
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

	//protected int cantidadInfectados;
	protected FabricaDeTandas fabrica;
	protected CompositeInfectado compInf;

	public Nivel(Juego juego) {
		this.juego = juego;
		this.compInf = new CompositeInfectado();

		String clase = this.getClass().getSimpleName();
		this.claveDer = clase+"_Derecha";
		this.claveIzq = clase+"_Izquierda";
		this.claveFondo = clase+"_Fondo";
		this.imagenDer = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(this.claveDer);
		this.imagenIzq = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(this.claveIzq);
		this.imagenFondo = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(this.claveFondo);

	}


	public List<Entidad> primeraTanda() {
		this.fabrica.primeraTanda();
		return this.compInf.getListaDeInfectados();
	}
	public List<Entidad> segundaTanda() {
		this.fabrica.segundaTanda();
		return this.compInf.getListaDeInfectados();
	}
	public List<Entidad> elJefe(){
		this.fabrica.elJefe();
		return this.compInf.getListaDeInfectados();
	}

	public CompositeInfectado getColeccionDeInfectados() {
		return this.compInf;
	}
	public String getClaveIzq() {
		return claveIzq;
	}

	public void setClaveIzq(String claveIzq) {
		this.claveIzq = claveIzq;
	}

	public String getClaveDer() {
		return claveDer;
	}

	public void setClaveDer(String claveDer) {
		this.claveDer = claveDer;
	}

	public String getClaveFondo() {
		return claveFondo;
	}

	public void setClaveFondo(String claveFondo) {
		this.claveFondo = claveFondo;
	}

	public ImageIcon getImagenIzq() {
		return ColeccionDeImagenes.getColeccionDeImagenes().getImagen(claveIzq);
	}



	public ImageIcon getImagenDer() {
		return ColeccionDeImagenes.getColeccionDeImagenes().getImagen(claveDer);
	}



	public ImageIcon getImagenFondo() {
		return ColeccionDeImagenes.getColeccionDeImagenes().getImagen(claveFondo);
	}

}
