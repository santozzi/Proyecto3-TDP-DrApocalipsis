package entidades.personajes.jugador;

import java.awt.Point;

import javax.swing.ImageIcon;

import armas.Arma;
import armas.ArmaSanitaria;
import armas.SuperArmaSanitaria;
import entidades.Vector;
import entidades.personajes.Personaje;
import logica.ColeccionDeImagenes;
import logica.Juego;
import visitor.VisitanteJugador;
import visitor.Visitor;


public class Jugador extends Personaje{

	protected Arma arma;

	public Jugador(Juego juego) {
		arma = new ArmaSanitaria(juego);
		this.cargaViral = 100;
		this.juego= juego;
		this.vector = new Vector(1,0,3);
		this.vector.getPosicion().x=225;
		this.vector.getPosicion().y=550;
		//this.claveImagen = new String("Jugador_dispara");
		this.claveImagen = arma.getClaveImagen();
		// this.posicion = new Point(225,550);
		//imagen.setAlto(50);
		//imagen.setAncho(30);

		imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(claveImagen);

		v = new VisitanteJugador(this);

		
	}

	public void detenerse() {
		if(!this.claveImagen.equals("Jugador_dispara")) {
			this.claveImagen = arma.getClaveImagen();
			imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(claveImagen);
		}

	}

	public boolean estaInfectado() {
		return cargaViral>=100;
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

	public void curar(int cantidad) {
		if(cargaViral<=100-cantidad)
			this.cargaViral +=cantidad;
		else if(cargaViral<=100) {
			this.cargaViral = 100;
		}
	}
	public void disparar() {
		arma.disparar();
		this.claveImagen = "recargar";
		imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(claveImagen);
		imagen.getImage().flush();
	}

	@Override
	public void impacto(int disparo) {
		super.impacto(disparo);
		juego.notificarCargaViralDeJugador();
	}

	@Override
	public void actuar() {
		// TODO Auto-generated method stub
		
	}
	public void cambiarArma(Arma arma) {
		this.arma= arma;
	}
}
