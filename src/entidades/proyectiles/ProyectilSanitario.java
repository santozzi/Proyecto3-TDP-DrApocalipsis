package entidades.proyectiles;
import logica.Juego;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import entidades.Vector;
import entidades.personajes.jugador.Jugador;
import entidades.Entidad;
import logica.Imagen;
import visitor.VisitanteJugador;
import visitor.Visitor;

public class ProyectilSanitario extends Proyectil{

	protected Imagen imagen;
	protected int letalidad;
	protected int velocidad;
	protected Jugador jugador;
	//constructor crear un vector con los datos, recibe a juego
	
	public ProyectilSanitario(Juego juego) {
		imagen = new Imagen();
		this.vector = new Vector(0,-1,1000);
		jugador= juego.getJugador();
		vector.getPosicion().x= jugador.getVector().getPosicion().x;
		vector.getPosicion().y= jugador.getVector().getPosicion().y;
		imagen.setImagen("proyectilSanitario");
		imagen.setAncho(40);
		imagen.setAlto(80);
		juego.agregarAEntidadesParaAgregar(this);
		//v = new VisitanteProyectil(this);
	}
	
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarProyectil(this);
	}

	@Override
	public void desplazarse() {
		vector.desplazarse();
		
	}


	public Imagen getImagen() {
		return imagen;
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
