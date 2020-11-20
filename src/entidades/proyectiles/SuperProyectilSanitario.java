package entidades.proyectiles;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import entidades.Vector;

import entidades.Entidad;
import visitor.Visitor;

public class SuperProyectilSanitario extends Proyectil {

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
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
	public ArrayList<Entidad> detectarColisiones() {
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

	@Override
	public boolean hayColision(Entidad entidad) {
		// TODO Auto-generated method stub
		return false;
	}
    
}
