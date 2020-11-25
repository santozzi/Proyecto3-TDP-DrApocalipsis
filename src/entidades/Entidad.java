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
    protected int latencia;
	protected Juego juego;
	protected ImageIcon imagen;
	protected String claveImagen;
	protected boolean estadoTemporal;


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
		return this.vector.getPosicion();
	}
	public void setPosicion(int x, int y) {
		this.vector.getPosicion().x = x;
		this.vector.getPosicion().y = y;
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
		juego.actualizarEntidad(this);
		//detectarColisiones();
		accionar();
		//detectarColisiones();
		//pregunatar cuando se choca con el limite del mapa
	}
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


	public void accionar() {
		for(Entidad ent : detectarColisiones()) {
			//visitor
			ent.accept(v);
		}
		
		

	}
	public abstract void actuar();
	public void cambiarEstadoTemporal() {
		estadoTemporal= true;
	}
}
