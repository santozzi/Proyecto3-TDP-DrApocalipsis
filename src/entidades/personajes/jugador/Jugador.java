package entidades.personajes.jugador;

import javax.swing.ImageIcon;

import armas.Arma;
import armas.ArmaSanitaria;
import entidades.personajes.Personaje;
import logica.ColeccionDeImagenes;
import logica.Juego;
import logica.Vector;
import visitor.VisitanteJugador;
import visitor.Visitor;

/**
 * 
 * Es un tipo de personaje con la habilidad de disparar y ser
 * manejado por el usuario.
 *
 */
public class Jugador extends Personaje{

	protected Arma arma;

	public Jugador(Juego juego) {
		super(juego);
		arma = new ArmaSanitaria(juego);
		this.vector = new Vector(1, 0, 3);
		this.cargaViral = 100;
		this.juego= juego;
		this.vector.getPosicion().x=225;
		this.vector.getPosicion().y=550;
		
		setImagen(arma.getClaveImagen());

		v = new VisitanteJugador(this);

	}
	@Override
	public void detenerse() {
		if(!this.claveImagen.equals(arma.getClaveImagen())) {
			setImagen(arma.getClaveImagen());
		}
	}
    
	/**
	 * estaInfectado
	 * Determina si el el jugador no tiene mas energia.
	 * @return verdadero si cargaViral es 0 y falso de lo contrario
	 */
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
	
	/**
	 * desplazarseIzquierda
	 * Mueve al jugador hacia la izquierda
	 */
	public void desplazarseIzquierda() {
		if(this.vector.getPosicion().x>=-15 && this.cargaViral>0) {
			if(vector.getDireccion().x==1) {
				vector.cambioDeSentido();
			}
			if(!this.claveImagen.equals("Jugador_CaminarIzquierda")) {
				setImagen("Jugador_CaminarIzquierda");

			}
			
			desplazarse();
		}

	}
	
	/**
	 * desplazarseDerecha
	 * Mueve al jugador hacia la derecha
	 */
	public void desplazarseDerecha() {
		if(this.vector.getPosicion().x<=Juego.ANCHO_DE_COMBATE-55 && this.cargaViral>0) {
			if(vector.getDireccion().x==-1) {
				vector.cambioDeSentido();
			}
			if(!this.claveImagen.equals("Jugador_CaminarDerecha")) {
				setImagen("Jugador_CaminarDerecha");
			}
			desplazarse();
		}
	}
    /**
     * curar
     * Recupera la energia del jugador, en cantidad de cantidad.
     * @param cantidad, la cantidad de energia a recuperar.
     */
	public void curar(int cantidad) {
		if(cargaViral<=100-cantidad)
			this.cargaViral +=cantidad;
		else if(cargaViral<=100) {
			this.cargaViral = 100;
		}
	}
	/**
	 * disparar
	 * Da la orden para disparar un nuevo proyectil
	 */
	public void disparar() {
		arma.disparar();
		setImagen(arma.getClaveImagen());
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
	/**
	 * cambiarArma
	 * Cambia el arma del jugador
	 * @param arma, es el arma con la que se cambia
	 */
	public void cambiarArma(Arma arma) {
		this.arma= arma;
	}
	public void desaparecer() {
		super.desaparecer();
		juego.matarJugador();
		juego.finalizarJuego();
	}
	private void setImagen(String comando) {
		this.claveImagen = comando;
		imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(claveImagen);
	}
}
