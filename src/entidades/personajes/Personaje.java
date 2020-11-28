package entidades.personajes;

import entidades.Entidad;
import logica.Juego;

public abstract class Personaje extends Entidad {
	protected int cargaViral;
	protected int tiempoDeEspera;
	
	public Personaje(Juego juego) {
		super(juego);
	}
	

	public void impacto(int disparo) {
		if(cargaViral-disparo>0) {
		   this.cargaViral -=disparo;
		 
		}else {
			desaparecer();
		}
	} 
	public int getEnergia() {
		return cargaViral;
	}
	
	
}
