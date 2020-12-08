package entidades.premios;

import entidades.Entidad;
import logica.HiloSecundario;
import logica.Juego;
/**
 * Premio 
 * Es un tipo de entidad que modifica el comportamiento de otras entidades
 */
public abstract class Premio extends Entidad {
   
   public Premio (Juego juego) {
	   super(juego);
   }
   /**
    * Ejecuta la acción del premio dependiendo de que premio sea.
    */
   abstract public void ejecutar();
   @Override
   public void desplazarse() {
		super.desplazarse();
		if(this.vector.getPosicion().y >= Juego.ALTO_DE_COMBATE)
			this.desaparecer();
	}
   @Override
	public void actuar() {
		int vueltasAEsperar;
		int velocidad = vector.getModulo();
		vueltasAEsperar =HiloSecundario.LATENCIA_MAXIMA-velocidad;

		if(vueltasAEsperar>0&&vueltasAEsperar<HiloSecundario.LATENCIA_MAXIMA) {
			if(latencia>=vueltasAEsperar) {
				desplazarse();
				juego.actualizarEntidad(this);
				accionar();
				latencia= 1;
			}else {
				latencia++;
			}
		}

	}
  
}
