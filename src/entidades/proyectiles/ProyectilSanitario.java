package entidades.proyectiles;
import logica.Juego;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import entidades.Vector;

import entidades.Entidad;
import logica.Imagen;
import visitor.VisitanteJugador;
import visitor.Visitor;

public class ProyectilSanitario extends Proyectil{

	protected Imagen imagen;
	protected int letalidad;
	protected int velocidad;
	//constructor crear un vector con los datos, recibe a juego
	
	public ProyectilSanitario(Juego juego) {
		imagen = new Imagen();
		this.vector = new Vector(225,550,500);

		imagen.setImagen("Jeringa2.png");
		//v = new VisitanteProyectil(this);
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
		return imagen.getImagen();
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
	public Vector getVector() {//direccion, velocidad, sentido
		// TODO Auto-generated method stub
		return this.vector;
	}

}
