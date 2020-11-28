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
    
	protected FabricaDeTandas fabrica;
	protected CompositeInfectado compInf;
	
	abstract public void crearTanda();
	public CompositeInfectado getColeccionDeInfectados() {
		return this.compInf;
	}
	abstract public void losJefes();
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
