package entidades.personajes.jugador;

import java.awt.Point;

import javax.swing.ImageIcon;

import armas.Arma;
import armas.ArmaSanitaria;
import entidades.Vector;
import entidades.personajes.Personaje;
import logica.ColeccionDeImagenes;
import logica.Juego;
import visitor.VisitanteJugador;
import visitor.Visitor;


public class Jugador extends Personaje{

	protected Arma arma;

	public Jugador(Juego juego) {
		this.cargaViral = 0;
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

	public void detenerse() {
		if(!this.claveImagen.equals("Jugador_dispara") && !this.claveImagen.equals("recargar")) {
			this.claveImagen = "Jugador_dispara";
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
