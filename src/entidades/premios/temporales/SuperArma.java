package entidades.premios.temporales;

import armas.SuperArmaSanitaria;
import entidades.Entidad;
import entidades.Vector;
import entidades.personajes.jugador.Jugador;
import logica.ColeccionDeImagenes;
import logica.Juego;
import visitor.VisitanteSuperArma;
import visitor.Visitor;

public class SuperArma extends Temporal {
	protected Jugador jugador;
    public SuperArma (Juego juego) {
        super(juego);
    	
    	this.jugador = juego.getJugador();
    	vector = new Vector(0,1,1);
    	v= new VisitanteSuperArma(this);
    	
    	this.claveImagen = new String("superArmaSanitaria");
    	imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(claveImagen);
    }
	@Override
	public void ejecutar() {
	    jugador.cambiarEstadoTemporal();
		jugador.cambiarArma(new SuperArmaSanitaria(juego));
		
	}
	@Override
	public void accept(Visitor v) {
		v.visitarSuperArma(this);
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
