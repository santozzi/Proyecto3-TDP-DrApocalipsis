package entidades.personajes;

import entidades.Entidad;

public abstract class Personaje extends Entidad {
	
	protected int cargaViral;
	
   /**
    * estaMuerto
    * ----------
    * Verifica si el personaje tiene 0 de energia
    * @return Si tiene 0 o menos retorna true de lo contrario false
    */
	
   /**
    * desplazarse
    * -----------
    * Mueve al personaje en direccion correspondiente
    */
   //abstract public void desplazarse();
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
