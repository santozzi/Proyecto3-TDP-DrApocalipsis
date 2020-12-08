package logica;

import java.awt.Point;
/**
 * Vector
 * Encargada de darle direccion, posicion y modulo a las entidades
 */
public class Vector {
	protected Point direccion;
	protected Point posicion;
	protected int sentido;
	protected int modulo;
	/**
	 * Vetor
	 * @param x
	 * @param y
	 * @param modulo
	 */
	public Vector(int x, int y,int modulo) {
		this.direccion = new Point(x,y);
		this.posicion = new Point();
		this.sentido = 1;
		this.modulo = modulo;

	}
	/**
	 * getSentido
	 * Devuelve si es 1 o -1
	 * @return
	 */
	public int getSentido() {
		return sentido;
	}
     
	
    /**
     * getModulo
     * Devuelve el módulo del vector
     * @return
     */
	public int getModulo() {
		return modulo;
	}
    /**
     * setModulo
     * Cambia el módulo del vector
     * @param modulo
     */
	public void setModulo(int modulo) {
		this.modulo = modulo;
	}
	/**
	 * desplazarse
	 * desplaza a la entidad en funcion de su direccion
	 */
	public void desplazarse() {
		posicion.x +=direccion.x;
		posicion.y +=direccion.y;
	}


	/**
	 * cambioDeSentido
	 * Cambia el sentido de la direccion a su opuesto
	 */
	public void cambioDeSentido() {
		direccion.x *=-1;
		direccion.y *=-1;
	}   
	/**
	 * getPosicion
	 * Devuelve su pusición
	 * @return posición de tipo Point
	 */
	public Point getPosicion() {
		return posicion;
	}
	/**
	 * getDireccion
	 * Devuelve la direccion 
	 * @return dirección de tipo de tipo Point
	 */
	public Point getDireccion() {
		return direccion;
	}
}
