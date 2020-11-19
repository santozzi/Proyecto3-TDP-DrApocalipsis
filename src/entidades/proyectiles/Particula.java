package entidades.proyectiles;

import java.awt.Point;
import java.util.List;

import javax.swing.ImageIcon;

import entidades.Entidad;
import entidades.Vector;
import logica.ColeccionDeImagenes;
import logica.Juego;
import visitor.Visitor;

public class Particula extends Proyectil{

	protected int velocidad;
	
	public Particula(Juego juego) {
		this.vector = new Vector(225,550,500);
		
        this.juego = juego;
		imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen("Jeringa2.png");
		//v = new VisitanteParticula(this);	
	}
	
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarProyectil(this);
	}

	@Override
	public void desplazarse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ImageIcon getImagen() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Entidad> detectarColisiones() {
		// TODO Auto-generated method stub
		return null;
	}

    public void accionar() {
		// TODO Auto-generated method stub
		
	}

	public Vector getVector() {
		return this.vector;
	}

	@Override
	public Point getPosicion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void detenerse() {
		// TODO Auto-generated method stub
		
	}

}
