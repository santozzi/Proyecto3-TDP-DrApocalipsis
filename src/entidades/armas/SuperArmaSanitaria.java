package entidades.armas;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import entidades.Vector;

import entidades.Entidad;
import logica.Imagen;
import visitor.Visitor;

/**
 * Los proyectiles de esta arma causan mas daño
 * @author 
 *
 */
public class SuperArmaSanitaria extends Arma{

	@Override
	public void disparar() {
		// TODO Auto-generated method stub
		
	}

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

}
