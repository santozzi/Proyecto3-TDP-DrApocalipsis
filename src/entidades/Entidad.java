package entidades;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import logica.Imagen;
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
	protected Imagen imagen;


	abstract public void accept(Visitor v);
	abstract public void desplazarse();
	abstract public Imagen getImagen();
	abstract public List<Entidad> detectarColisiones();
	abstract public void accionar();
	abstract public Vector getVector();
	abstract public Point getPosicion();
	

}
