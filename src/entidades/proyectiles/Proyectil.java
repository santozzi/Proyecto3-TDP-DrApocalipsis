package entidades.proyectiles;

import entidades.Entidad;
import logica.HiloSecundario;

public abstract class Proyectil extends Entidad {
	protected int letalidad;

	public int getLetalidad() {
		return this.letalidad;
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
	@Override
	public void desplazarse() {
		this.vector.desplazarse();
		//accionar();
		if(this.vector.getPosicion().y<=0)
			this.desaparecer();

		juego.actualizarEntidad(this);
	}


}
