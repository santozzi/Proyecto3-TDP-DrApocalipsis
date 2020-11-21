package entidades.personajes.jugador;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;

import entidades.Vector;
import entidades.armas.*;
import entidades.personajes.Personaje;
import entidades.Entidad;
import logica.ColeccionDeImagenes;
import logica.Juego;
import logica.Latencia;
import visitor.VisitanteJugador;
import visitor.Visitor;


public class Jugador extends Personaje{

	protected Arma arma;

	public Jugador(Juego juego) {
		this.energia = 100;
		this.juego= juego;
		this.vector = new Vector(1,0,500);
		this.vector.getPosicion().x=225;
		this.vector.getPosicion().y=550;
		this.claveImagen = new String("Jugador_dispara");
		
       // this.posicion = new Point(225,550);
		//imagen.setAlto(50);
		//imagen.setAncho(30);
	
		imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(claveImagen);
		
		v = new VisitanteJugador(this);

		arma = new ArmaSanitaria(juego);
	}

	@Override
	public boolean estaMuerto() {

		return energia<=0;
	}


	public void detenerse() {
		if(!this.claveImagen.equals("Jugador_dispara") && !this.claveImagen.equals("recargar")) {
			this.claveImagen = "Jugador_dispara";
			imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(claveImagen);
		}

	}

	@Override
	public void accept(Visitor v) {
		v.visitarJugador(this);

	}

	@Override
	public ImageIcon getImagen() {

		return imagen;
	}




	@Override
	public Vector getVector() {
		return this.vector;
	}
	public void desplazarseIzquierda() {
		if(this.vector.getPosicion().x>=-15) {
		if(vector.getDireccion().x==1) {
			vector.cambioDeSentido();

		}
		if(!this.claveImagen.equals("Jugador_caminarIzquierda")) {
			this.claveImagen = "Jugador_caminarIzquierda";
			imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(claveImagen);

		}
		desplazarse();
		}
	
	}
	public void desplazarseDerecha() {
		if(this.vector.getPosicion().x<=Juego.ANCHO_DE_COMBATE-55) {
		if(vector.getDireccion().x==-1) {
			vector.cambioDeSentido();
		}
		
		
		if(!this.claveImagen.equals("Jugador_caminarDerecha")) {
			this.claveImagen = "Jugador_caminarDerecha";
			imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(claveImagen);
		}
		
	    desplazarse();
	    
	}
	}
	@Override
	public Point getPosicion() {
		return posicion;
	}
	
	public void disparar() {
		arma.disparar();
		this.claveImagen = "recargar";
		imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(claveImagen);
		imagen.getImage().flush();
	}


}
