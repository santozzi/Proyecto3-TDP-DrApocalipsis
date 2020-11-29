package entidades.personajes.jugador;

import java.awt.Point;

import javax.swing.ImageIcon;

import armas.Arma;
import armas.ArmaSanitaria;
import armas.SuperArmaSanitaria;
import entidades.personajes.Personaje;
import logica.ColeccionDeImagenes;
import logica.Juego;
import logica.Vector;
import visitor.VisitanteJugador;
import visitor.Visitor;


public class Jugador extends Personaje{

	protected Arma arma;

	public Jugador(Juego juego) {
		super(juego);
		arma = new ArmaSanitaria(juego);
		this.cargaViral = 100;
		this.juego= juego;
		this.vector = new Vector(1,0,3);
		this.vector.getPosicion().x=225;
		this.vector.getPosicion().y=550;
		this.claveImagen = arma.getClaveImagen();
		tiempoDeEspera = 1000;
		imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(claveImagen);
		

		v = new VisitanteJugador(this);

	}

	public void detenerse() {
		if(!this.claveImagen.equals(arma.getClaveImagen())) {
			this.claveImagen = arma.getClaveImagen();
			imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(claveImagen);
		}
	}

	public boolean estaInfectado() {
		return cargaViral<=0;
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
		if(this.vector.getPosicion().x>=-15 && this.cargaViral>0) {
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
		if(this.vector.getPosicion().x<=Juego.ANCHO_DE_COMBATE-55 && this.cargaViral>0) {
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
		if(cargaViral-disparo>0) {
			this.cargaViral -= disparo;

		}else {
			this.cargaViral = 0;
			desaparecer();
		}
		juego.notificarCargaViralDeJugador();
	}

	@Override
	public void actuar() {
		if(estadoTemporal) {
			if(latencia>=tiempoDeEspera) {
				arma = new ArmaSanitaria(juego);
				estadoTemporal = false;
				latencia = 1;
			}else
				latencia++;
		}

	}
	public void cambiarArma(Arma arma) {
		this.arma= arma;
	}
	public void desaparecer() {
		super.desaparecer();
		//juego.agregarAEntidadesParaQuitar(this);
		juego.matarJugador();
		juego.finalizarJuego();
	}
}
