package entidades.personajes;

import entidades.Entidad;

public abstract class Personaje extends Entidad {
	
	protected int energia;
	
   /**
    * estaMuerto
    * ----------
    * Verifica si el personaje tiene 0 de energia
    * @return Si tiene 0 o menos retorna true de lo contrario false
    */
	
   abstract public boolean estaMuerto();
   /**
    * desplazarse
    * -----------
    * Mueve al personaje en direccion correspondiente
    */
   //abstract public void desplazarse();
	public void impacto(int disparo) {
		if(energia-disparo>0)
		   this.energia -=disparo;
		else {
			desaparecer();
		    
		}
	} 
	public int getEnergia() {
		return energia;
	}
	
}
