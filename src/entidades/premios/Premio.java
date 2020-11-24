package entidades.premios;

import entidades.Entidad;
import logica.Juego;

public abstract class Premio extends Entidad {
   abstract public void ejecutar() ;
   
   @Override
   public void desplazarse() {
		super.desplazarse();
		if(this.vector.getPosicion().y >= Juego.ALTO_DE_COMBATE)
			this.desaparecer();
	}
}
