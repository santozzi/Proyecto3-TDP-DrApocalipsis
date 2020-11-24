package entidades.premios.no_temporales;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import entidades.Vector;
import logica.ColeccionDeImagenes;
import logica.Juego;
import entidades.Entidad;
import visitor.VisitantePocion;
import visitor.Visitor;

public class Pocion extends NoTemporal {
    public Pocion(Juego juego) {
    	this.juego = juego;
    	vector = new Vector(0,1,1);
    	v= new VisitantePocion(this);
    	imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen("pocion");
    	
    }
	@Override
	public void ejecutar() {
	
		juego.getJugador().curar(20);
		juego.notificarCargaViralDeJugador();

		
	}

	@Override
	public void accept(Visitor v) {
		v.visitarPocion(this);
		
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
		boolean colisionEnY = (posEntidadActualY+this.getImagen().getIconHeight()==posEntidadParametroY);// && (+this.getPosicion().y<=posEntidadParametroY);


		return colisionEnX &&colisionEnY;
		/*	
				(
				this.vector.getPosicion().y <= 
			(entidad.getVector().getPosicion().y+entidad.getImagen().getIconHeight())&&
						this.vector.getPosicion().y >= (entidad.getVector().getPosicion().y));
		 */
	}
}
