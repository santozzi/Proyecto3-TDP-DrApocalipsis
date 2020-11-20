package entidades;

import java.awt.Point;
import java.util.List;

import javax.swing.ImageIcon;

import logica.ColeccionDeImagenes;
import logica.Juego;
import visitor.Visitante;
import visitor.Visitor;

abstract public class  Entidad {
	protected Visitante v;
	/**
	 * El vector contiene la velocidad y la direccion de la entidad
	 */
	protected Vector vector;
	protected Point posicion;
	protected Juego juego;
	protected ImageIcon imagen;
	protected String claveImagen;


	abstract public void accept(Visitor v);
	abstract public void desplazarse();
	abstract public ImageIcon getImagen();
	abstract public List<Entidad> detectarColisiones();
	abstract public void accionar();
	abstract public Vector getVector();
	abstract public Point getPosicion();
	abstract public void detenerse();
	abstract public boolean hayColision(Entidad entidad);
	

}
