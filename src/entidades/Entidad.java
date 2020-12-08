package entidades;

import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;

import entidades.personajes.jugador.Jugador;
import logica.ColeccionDeImagenes;
import logica.Juego;
import logica.Vector;
import visitor.Visitante;
import visitor.Visitor;
/**
 * Entidad
 * -------
 * Todo objeto que tiene movimiento,una posición y una representación gráfica
 * 
 *
 */
abstract public class  Entidad {
	protected Visitante v;
	/**
	 * El vector contiene la velocidad, la direccion y la posición de la entidad
	 */
	protected Vector vector;
	// La latencia es la cantidad de ciclos que pasan antes de realizar una acción determinada
	protected int latencia;
	// El juego es la clase que controla todo, la lógica de la aplicación
	protected Juego juego;
	// La imágen es la representacion gráfica de la entidad
	protected ImageIcon imagen;
	// Esta clave es utilizada para obtener la imagen de dentro de una colección de imagenes
	protected String claveImagen;
	//utilizado para los premios que tienen un tiempo determinado, si esta en verdadero espera tantos ciclos
	//como diga el tiempo de espera.
	protected boolean estadoTemporal;
	//La cantidad de ciclos de espera antes de realizar una acción cuando el estadoTemporal es verdadero.
	protected int tiempoDeEspera;
	//El jugador del juego, se obtiende desde el atributo juego.
	protected Jugador jugador;
	/**
	 * Aceptar
	 * -------
	 * Este metodo es para aceptar un visitante, se utiliza para resolver acciones 
	 * ante una colisión.
	 * @param v Es el visitante en cuestión.
	 */
	abstract public void accept(Visitor v);

	//Inicializo variables en el constructor.
	public Entidad (Juego juego) {
		this.juego = juego;
		this.estadoTemporal= false;
		this.vector = new Vector(0, 1, 1);
		this.claveImagen = this.getClass().getSimpleName();
		this.imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(this.claveImagen);
		tiempoDeEspera = 1000;
	}

	/**
	 * getImagen
	 * Para obtener la imagen de la entidad desde una clase cliente.
	 * @return ImageIcon: la representacion gráfica de la entidad.
	 */
	public ImageIcon getImagen() {
		return this.imagen;
	}

	/**
	 * getVector
	 * @return Devuelve el vector de la entidad
	 */
	public Vector getVector() {
		return this.vector;
	}
	/**
	 * getPosicion
	 * Devuelve la posicion de la entidad
	 * @return objeto de tipo Point 
	 */
	public Point getPosicion() {
		return this.vector.getPosicion();
	}
	/**
	 * setPosicion
	 * Posiciona a la entidad en las coordenadas x e y
	 * @param x coordenada en x
	 * @param y coordenada en y
	 */
	public void setPosicion(int x, int y) {
		this.vector.getPosicion().x = x;
		this.vector.getPosicion().y = y;
	}
	/**
	 * detenerse
	 * Detiene a la entidad
	 */
	public void detenerse() {
		vector.setModulo(0);
	}

	/**
	 * desaparecer
	 * Quita a la entidad del juego.
	 */
	public void desaparecer() {
		juego.agregarAEntidadesParaQuitar(this);
	}
	/**
	 * hayColision
	 * Detecta colisiones entre las entidades
	 * @param entidad 
	 * @return verdadero si hay colision y falseo de lo contrario
	 */
	//detecta de arriba hacia abajo
	public boolean hayColision(Entidad entidad) {
		int posEntidadActualX =this.vector.getPosicion().x;
		int posEntidadActualY =this.vector.getPosicion().y;
		int posEntidadParametroX =entidad.getVector().getPosicion().x;
		int posEntidadConAnchoX= posEntidadParametroX+entidad.getImagen().getIconWidth();
		int posEntidadParametroY =entidad.getVector().getPosicion().y ;
		//int posEntidadConAltoY= posEntidadParametroY +entidad.getImagen().getIconHeight();
		boolean colisionEnX = (posEntidadActualX<= posEntidadConAnchoX) && (posEntidadActualX >= posEntidadParametroX-10);
		boolean colisionEnY = (posEntidadActualY+this.getImagen().getIconHeight()>=posEntidadParametroY);// && (+this.getPosicion().y<=posEntidadParametroY);
		return colisionEnX &&colisionEnY;
	}

	/**
	 * desplazarse
	 * Mueve a la entidad 
	 */
	public void desplazarse() {
		this.vector.desplazarse();
		juego.actualizarEntidad(this);
		accionar();
	}

	/**
	 * detectarColisiones
	 * ------------------
	 * Si hay colision se guarda la entidad con la que se colisionó
	 * @return una lista de entidades
	 */
	public List<Entidad> detectarColisiones() {
		List<Entidad> listaDeColisiones = new LinkedList<Entidad>();
		List<Entidad> listaDeLatencia = juego.getLista();
		boolean esta = false;
		Entidad entidadActual = this;
		Entidad entVerificar;
		Iterator<Entidad> itEntidades ;
		for(Entidad entidadDeLatencia : listaDeLatencia) {
			itEntidades = listaDeColisiones.iterator();
			if(entidadActual!=entidadDeLatencia&&hayColision(entidadDeLatencia)) {
				//-----para que no haya repetidos----
				while(itEntidades.hasNext()&&!esta) {
					entVerificar = itEntidades.next();
					esta= entVerificar == entidadDeLatencia;
				}
				//-------------------------------------
				if(!esta)
					listaDeColisiones.add(entidadDeLatencia);
				else
					esta = false;

			} 

		}
		return listaDeColisiones;
	}  
	/**
	 * impacto
	 * -------
	 * Metodo para desidir que hacer cuando la entidad recibe un impacto
	 * @param letalidad es el valor que entrega la entidad que se colisiona.
	 */
	abstract public void impacto(int letalidad);

	/**
	 * accionar
	 * Acción a tomar cuando se visita la lista de colisiones
	 */
	public void accionar() {
		for(Entidad ent : detectarColisiones()) {
			//visitor
			ent.accept(v);
		}
	}

	/**
	 * actuar
	 * Es el disparador de eventos segun entidad.
	 */
	public abstract void actuar();

	/**
	 * cambiarEstadoTemporal
	 * Cambia el estado tempoaral a verdadero
	 */
	public void cambiarEstadoTemporal() {
		estadoTemporal= true;
	}
	/**
	 * getClaveImagen
	 * @return devuelve la clave con la que se obtiene la representacion gráfica de la entidad
	 */
	public String getClaveImagen() {
		return this.claveImagen;
	}
}
