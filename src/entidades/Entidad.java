package entidades;

import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;

import logica.ColeccionDeImagenes;
import logica.Juego;
import logica.Latencia;
import visitor.Visitante;
import visitor.Visitor;

abstract public class  Entidad {
	protected Visitante v;
	/**
	 * El vector contiene la velocidad y la direccion de la entidad
	 */
	protected Vector vector;
	protected Point posicion;
	protected Juego juego;
	protected ImageIcon imagen;
	protected String claveImagen;


	abstract public void accept(Visitor v);
	public ImageIcon getImagen() {
		return this.imagen;
	}
	//abstract public List<Entidad> detectarColisiones();
	//abstract public void accionar();
	public Vector getVector() {
		return this.vector;
	}
	public Point getPosicion() {
		return this.posicion;
	}
	public void setPosicion(int x, int y) {
		this.posicion.x = x;
		this.posicion.y = y;
	}
	public void detenerse() {
		vector.setModulo(0);
	}
	public void desaparecer() {
		juego.agregarAEntidadesParaQuitar(this);

	}
	public boolean hayColision(Entidad entidad) {
		// entidad.getEntorno() this.entorno
		//entorno = [x;x+anchoEntidad]
		//entornoEnY= [[y;y+anchoEntidad]
		int posEntidadActualX =this.vector.getPosicion().x;
		int posEntidadActualY =this.vector.getPosicion().y;
		int posEntidadParametroX =entidad.getVector().getPosicion().x;
		int posEntidadConAnchoX= posEntidadParametroX+entidad.getImagen().getIconWidth();

		int posEntidadParametroY =entidad.getVector().getPosicion().y ;
		int posEntidadConAltoY= posEntidadParametroY +entidad.getImagen().getIconHeight();

		boolean colisionEnX = (posEntidadActualX<= posEntidadConAnchoX) && (posEntidadActualX >= posEntidadParametroX-10);
		boolean colisionEnY = (posEntidadActualY<=posEntidadConAltoY) && (posEntidadParametroY>=posEntidadParametroY-10);


		return colisionEnX &&colisionEnY;
		/*	
				(
				this.vector.getPosicion().y <= 
			(entidad.getVector().getPosicion().y+entidad.getImagen().getIconHeight())&&
						this.vector.getPosicion().y >= (entidad.getVector().getPosicion().y));
		 */
	}

	public void desplazarse() {
		//this.posicion.y++;
		this.vector.desplazarse();
		//detectarColisiones();
		accionar();
		//detectarColisiones();
		//pregunatar cuando se choca con el limite del mapa

	}
	public List<Entidad> detectarColisiones() {
		List<Entidad> listaDeColisiones = new LinkedList<Entidad>();
		List<Latencia> listaDeLatencia = juego.getLista();
		boolean esta = false;
		Entidad entidadDeLatencia;
		Entidad entidadActual = this;
		Entidad entVerificar;
		Iterator<Entidad> itEntidades ;
		for(Latencia latencia : listaDeLatencia) {
			entidadDeLatencia = latencia.getEntidad();
			itEntidades = listaDeColisiones.iterator();
			if(entidadActual!=entidadDeLatencia&&hayColision(entidadDeLatencia)) {

				while(itEntidades.hasNext()&&!esta) {
					entVerificar = itEntidades.next();
					esta= entVerificar == entidadDeLatencia;
				}
				if(!esta)
					listaDeColisiones.add(entidadDeLatencia);
				else
					esta = false;

			}			 
		}
		return listaDeColisiones;
	}  


	public void accionar() {
		for(Entidad ent : detectarColisiones()) {
			//visitor
			ent.accept(v);
		}

	}
}
