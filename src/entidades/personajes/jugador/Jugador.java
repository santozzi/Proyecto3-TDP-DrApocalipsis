package entidades.personajes.jugador;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;

import entidades.Vector;
import entidades.armas.*;
import entidades.personajes.Personaje;
import entidades.Entidad;
import logica.Imagen;
import logica.Juego;
import logica.Latencia;
import visitor.VisitanteJugador;
import visitor.Visitor;


public class Jugador extends Personaje{

	protected Arma arma;

	public Jugador(Juego juego) {
		this.energia = 100;
		this.juego= juego;
		imagen = new Imagen();
		this.vector = new Vector(1,0,500);
		this.vector.getPosicion().x=225;
		this.vector.getPosicion().y=550;
		
       // this.posicion = new Point(225,550);
		//imagen.setAlto(50);
		//imagen.setAncho(30);
		imagen.setAlto(70);
		imagen.setAncho(50);
		imagen.setImagen("Jugador_dispara");
		v = new VisitanteJugador(this);

		arma = new ArmaSanitaria(juego);
	}

	@Override
	public boolean estaMuerto() {

		return energia<=0;
	}

	@Override
	public void desplazarse() {
		vector.desplazarse();

	}
	public void detenerse() {
		if(!imagen.getNom().equals("Jugador_dispara") && !imagen.getNom().equals("recargar")) {
			//imagen.setAlto(50);
			//imagen.setAncho(30);
			imagen.setAlto(70);
			imagen.setAncho(50);
			imagen.setImagen("Jugador_dispara");
		}

	}


	/*
	public void desplazarse(char key) {

		if(key=='a') {
			if(vector.getSentido()==1) {
				vector.cambioDeSentido();


			}
			  if(!imagen.getNom().equals("Jugador_caminarIzquierda"))
			     imagen.setImagen("Jugador_caminarIzquierda");

			    vector.avanzarEnX();

		}else if(key=='d') {
			if(vector.getSentido()==-1) {
				vector.cambioDeSentido();

			}
			 if(!imagen.getNom().equals("Jugador_caminarDerecha"))
			  imagen.setImagen("Jugador_caminarDerecha");
				vector.avanzarEnX();
		}else
			imagen.setImagen("Jugador_dispara");


	}
	 */
	@Override
	public void accept(Visitor v) {
		v.visitarJugador(this);

	}

	@Override
	public Imagen getImagen() {

		return imagen;
	}
	//es para probar despues se borra
	public Imagen getIma() {
		return imagen;
	}
	@Override
	public List<Entidad> detectarColisiones() {
		List<Entidad> colisiones = new LinkedList<Entidad>();
		for(Latencia lat : juego.getLista()) {
			Entidad entidad = lat.getEntidad();
			//analizo si la entidad me toca y si lo hace lo agrego a la lista

			colisiones.add(entidad);
		}

		return colisiones;
	}

	@Override
	public void accionar() {
		for(Entidad ent : detectarColisiones()) {
			//visitor
			ent.accept(v);
		}

	}

	@Override
	public Vector getVector() {
		return this.vector;
	}
	public void desplazarseIzquierda() {
		if(this.vector.getPosicion().x>=Juego.DECORADO_IZQUIERDO) {
		if(vector.getDireccion().x==1) {
			vector.cambioDeSentido();


		}
		if(!imagen.getNom().equals("Jugador_caminarIzquierda")) {
			imagen.setAlto(70);
			imagen.setAncho(50);
			imagen.setImagen("Jugador_caminarIzquierda");

		}
		desplazarse();
		}
	
	}
	public void desplazarseDerecha() {
		if(this.vector.getPosicion().x<=Juego.ANCHO_DE_COMBATE+Juego.DECORADO_IZQUIERDO-30) {
		if(vector.getDireccion().x==-1) {
			vector.cambioDeSentido();
		}
		
		
		if(!imagen.getNom().equals("Jugador_caminarDerecha")) {
			imagen.setAlto(70);
			imagen.setAncho(50);
			imagen.setImagen("Jugador_caminarDerecha");
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
		imagen.setAlto(70);
		imagen.setAncho(50);
		imagen.setImagen("recargar");
	}

}
