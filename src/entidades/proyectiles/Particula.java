package entidades.proyectiles;

import java.util.List;

import javax.swing.ImageIcon;

import entidades.Entidad;
import entidades.Vector;
import logica.Imagen;
import logica.Juego;
import visitor.Visitor;

public class Particula extends Proyectil{

	protected int velocidad;
	protected Imagen imagen; 
	
	public Particula(Juego juego) {
		imagen = new Imagen();
		this.vector = new Vector(225,550,500);

		imagen.setImagen("Jeringa2.png");
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

}
