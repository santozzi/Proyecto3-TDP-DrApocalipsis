package entidades.proyectiles;

import java.awt.Point;
import java.util.List;

import javax.swing.ImageIcon;

import entidades.Entidad;
import entidades.Vector;
import logica.Imagen;
import visitor.Visitor;

public class Particula extends Proyectil {
	
	protected int rango;

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void desplazarse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Imagen getImagen() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Entidad> detectarColisiones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accionar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector getVector() {
		// TODO Auto-generated method stub
		return null;
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
