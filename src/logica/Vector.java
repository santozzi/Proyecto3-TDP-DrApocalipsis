package logica;

import java.awt.Point;

public class Vector {
	protected Point direccion;
	protected Point posicion;
	protected int sentido;
	protected int modulo;

	public Vector(int x, int y,int modulo) {
		this.direccion = new Point(x,y);
		this.posicion = new Point();
		this.sentido = 1;
		this.modulo = modulo;
		
		
	}
    public Vector() {
    	this(0,0,0);
    }
	public int getX() {
		return (int)direccion.getX();
	}
	public int getY() {
		return (int)direccion.getY();
	}
	public void setX(int x) {
		direccion.setLocation(x, getY());

	}
	public void setY(int y) {
		direccion.setLocation(getX(), y);

	}

	public int getSentido() {
		return sentido;
	}

	public void setSentido(int sentido) {
		this.sentido = sentido;
	}

	public int getModulo() {
		return modulo;
	}

	public void setModulo(int modulo) {
		this.modulo = modulo;
	}
	public void desplazarse() {
	    posicion.x +=direccion.x;
		posicion.y +=direccion.y;
	}
	
	public void avanzarEnX() {

		setX(getX()+sentido);
	}
	public void avanzarEnY() {
		setY(getY()+sentido);
	}

	public void cambioDeSentido() {
	//	this.sentido= (-1)*this.sentido;
		direccion.x *=-1;
		direccion.y *=-1;
	}   
	public Point getPosicion() {
		return posicion;
	}
	public Point getDireccion() {
		return direccion;
	}
}
