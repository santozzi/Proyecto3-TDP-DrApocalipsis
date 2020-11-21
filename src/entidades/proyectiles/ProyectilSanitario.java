package entidades.proyectiles;
import logica.Juego;
import logica.Latencia;

import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;

import entidades.Vector;
import entidades.personajes.jugador.Jugador;
import entidades.Entidad;
import logica.ColeccionDeImagenes;
import visitor.VisitanteJugador;
import visitor.VisitanteProyectilSanitario;
import visitor.Visitor;

public class ProyectilSanitario extends Proyectil{

	protected int letalidad;
	protected int velocidad;
	protected Jugador jugador;
	//constructor crear un vector con los datos, recibe a juego
	
	public ProyectilSanitario(Juego juego) {
		this.juego = juego;
		this.vector = new Vector(0,-1,1000);
		jugador= juego.getJugador();
		vector.getPosicion().x= jugador.getVector().getPosicion().x+24;
		vector.getPosicion().y= jugador.getVector().getPosicion().y-100;
		//Image newImg = imagen.getImagen().getImage().getScaledInstance(imagen.getAncho(), imagen.getAlto(), Image.SCALE_SMOOTH);
		//imagen.getImagen().setImage(newImg);
		
		imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen("proyectilSanitario");
		juego.agregarAEntidadesParaAgregar(this);
		v = new VisitanteProyectilSanitario(this);
	}
	
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarProyectilSanitario(this);
	}



	@Override
	public ImageIcon getImagen() {
		return imagen;
	}

	@Override
	public List<Entidad> detectarColisiones() {
		 List<Entidad> listaDeColisiones = new LinkedList<Entidad>();
	
		 List<Latencia> listaDeLatencia = juego.getLista();
		 
		 Entidad entidadDeLatencia;
		 Entidad entidadActual = this;
		 
		 for(Latencia latencia : listaDeLatencia) {
			 entidadDeLatencia = latencia.getEntidad();
			 if(entidadActual!=entidadDeLatencia) {
				 if(hayColision(entidadDeLatencia)) {
					 listaDeColisiones.add(entidadDeLatencia);
					 System.out.println("choque con proyectil");
				 }
			 }
		 }
		 
		 return listaDeColisiones;
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

	public void desaparecer() {
		juego.agregarAEntidadesParaQuitar(this);
		
	}



}
