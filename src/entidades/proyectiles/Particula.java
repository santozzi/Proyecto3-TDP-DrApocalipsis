package entidades.proyectiles;

import entidades.Entidad;
import entidades.Vector;
import entidades.personajes.infectados.Infectado;
import logica.Juego;

public abstract class Particula extends Proyectil{
    protected Infectado infectado;
    protected int rangoParticula;
	public Particula(Juego juego,Infectado infectado) {
            super(juego);
            vector.getDireccion().setLocation(0, 1);
    		vector.getPosicion().x= infectado.getVector().getPosicion().x;
    		vector.getPosicion().y= infectado.getVector().getPosicion().y+100;
    		this.infectado = infectado;
    }
	
	@Override
	public void desplazarse() {

		if(rangoParticula==infectado.getRango()) {
			reiniciarParticula();
		}else {
			rangoParticula++;
		}
		accionar();  
		vector.desplazarse();
		juego.actualizarEntidad(this);
	}


	private void reiniciarParticula() {
		rangoParticula=0;
		vector.getPosicion().x = infectado.getVector().getPosicion().x+
				(infectado.getImagen().getIconWidth()/4);
		vector.getPosicion().y = infectado.getVector().getPosicion().y+10;
	}
	public boolean hayColision(Entidad entidad) {
		
		int posEntidadActualX =this.vector.getPosicion().x;
		int posEntidadActualY =this.vector.getPosicion().y;
		int posEntidadParametroX =entidad.getVector().getPosicion().x;
		int posEntidadConAnchoX= posEntidadParametroX+entidad.getImagen().getIconWidth();

		int posEntidadParametroY =entidad.getVector().getPosicion().y ;
		int posEntidadConAltoY= posEntidadParametroY +entidad.getImagen().getIconHeight();

		boolean colisionEnX = (posEntidadActualX<= posEntidadConAnchoX) && (posEntidadActualX >= posEntidadParametroX-10);
		boolean colisionEnY = (posEntidadActualY+this.getImagen().getIconHeight()==posEntidadParametroY);// && (+this.getPosicion().y<=posEntidadParametroY);


		return colisionEnX &&colisionEnY;
	
	}
}
