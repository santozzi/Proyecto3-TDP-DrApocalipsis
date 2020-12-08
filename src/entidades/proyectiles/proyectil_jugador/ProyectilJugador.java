package entidades.proyectiles.proyectil_jugador;

import entidades.Entidad;
import entidades.proyectiles.Proyectil;
import logica.Juego;
/**
 * ProyectilJugador
 * Todo proyectil que usa el jugador.
 */
public abstract class ProyectilJugador extends Proyectil{

	public ProyectilJugador(Juego juego) {
		super(juego);
	}
	public boolean hayColision(Entidad entidad) {
		int posEntidadActualX =this.vector.getPosicion().x;
		int posEntidadActualY =this.vector.getPosicion().y;
		int posEntidadParametroX =entidad.getVector().getPosicion().x;
		int posEntidadConAnchoX= posEntidadParametroX+entidad.getImagen().getIconWidth();
		int posEntidadParametroY =entidad.getVector().getPosicion().y ;
		int posEntidadConAltoY= posEntidadParametroY +(entidad.getImagen().getIconHeight()/2);
		boolean colisionEnX = (posEntidadActualX<= posEntidadConAnchoX) && (posEntidadActualX >= posEntidadParametroX-10);
		boolean colisionEnY = (posEntidadActualY<=posEntidadConAltoY) && (posEntidadParametroY>=posEntidadParametroY-10);
		return colisionEnX && colisionEnY;
	}
}
