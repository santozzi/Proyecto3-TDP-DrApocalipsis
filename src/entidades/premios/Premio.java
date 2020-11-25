package entidades.premios;

import entidades.Entidad;
import logica.HiloSecundario;
import logica.Juego;

public abstract class Premio extends Entidad {
   abstract public void ejecutar() ;
   
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
