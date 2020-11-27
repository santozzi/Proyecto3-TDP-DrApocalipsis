package niveles;

import java.util.List;

import javax.swing.ImageIcon;

import entidades.Entidad;
import logica.ColeccionDeImagenes;
import logica.CompositeInfectado;
import logica.Juego;
import niveles.fabricas.FabricaDeTandas;
import niveles.fabricas.Nivel1InfectadosAlpha;

public class Nivel1 extends Nivel{
    protected Juego juego;
    protected String claveIzq;
    protected String claveDer;
    protected String claveFondo;
    protected ImageIcon imagenIzq;
    protected ImageIcon imagenDer;
    protected ImageIcon imagenFondo;
    public Nivel1(Juego juego) {
		this.juego = juego;
		compInf = new CompositeInfectado();
		this.claveDer= "fondoDerecha";
		this.claveIzq= "fondoIzquierda";
		this.claveFondo= "nivel1";
		
	}

	@Override
	public List<Entidad> primeraTanda() {
		FabricaDeTandas  fdt =  new Nivel1InfectadosAlpha(juego, this); 
	     fdt.primeraTanda();
		return this.compInf.getListaDeInfectados();
	}

	@Override
	public List<Entidad> segundaTanda() {
		FabricaDeTandas  fdt = new Nivel1InfectadosAlpha(juego, this); 
		fdt.segundaTanda();
		return this.compInf.getListaDeInfectados();
	}

	@Override
	public void crearTanda() {
		// TODO Auto-generated method stub
		
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
		return ColeccionDeImagenes.getColeccionDeImagenes().getImagen(claveDer);
	}



	public ImageIcon getImagenDer() {
		return ColeccionDeImagenes.getColeccionDeImagenes().getImagen(claveIzq);
	}



	public ImageIcon getImagenFondo() {
		return ColeccionDeImagenes.getColeccionDeImagenes().getImagen(claveFondo);
	}


	

}
