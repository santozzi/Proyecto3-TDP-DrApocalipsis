package entidades.proyectiles;

import entidades.Entidad;
import logica.HiloSecundario;
import logica.Juego;
import logica.Vector;
/**
 *Proyectil
 *Toda entidad que es arrojada por un personaje o arma 
 *
 */
public abstract class Proyectil extends Entidad {
	protected int letalidad;
    
	
	public Proyectil(Juego juego){
        super(juego);
		this.vector = new Vector(0,-1,9);
		jugador= juego.getJugador();
		vector.getPosicion().x= jugador.getVector().getPosicion().x+24;
		vector.getPosicion().y= jugador.getVector().getPosicion().y-10;
		juego.agregarAEntidadesParaAgregar(this);
	
	}	
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
		if(this.vector.getPosicion().y<=0)
			this.desaparecer();

		juego.actualizarEntidad(this);
	}


}
