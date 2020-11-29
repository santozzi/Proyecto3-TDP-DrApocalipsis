package entidades.proyectiles.particulas;


import entidades.personajes.infectados.Infectado;
import entidades.proyectiles.Proyectil;
import logica.Juego;

public abstract class Particula extends Proyectil{
    protected Infectado infectado;
    protected int rangoParticula;
	public Particula(Juego juego,Infectado infectado) {
            super(juego);
            rangoParticula= 0;
            vector.getDireccion().setLocation(0, 1);
       
    		vector.getPosicion().x= infectado.getVector().getPosicion().x+(infectado.getImagen().getIconWidth()/4);
    		vector.getPosicion().y= infectado.getVector().getPosicion().y+(infectado.getImagen().getIconHeight());//+100;
    		this.letalidad = 2;
    		this.infectado = infectado;
    }
	
	@Override
	public void desplazarse() {

		if(rangoParticula==infectado.getRango()) {
			System.out.println(vector.getModulo());
			detenerse();
			desaparecer();	
			
		}else {
			rangoParticula++;
		}
		accionar();  
		vector.desplazarse();
		juego.actualizarEntidad(this);
	}

/*
	public void reiniciarParticula() {
		rangoParticula=0;
		vector.getPosicion().x = infectado.getVector().getPosicion().x+
				(infectado.getImagen().getIconWidth()/4);
		vector.getPosicion().y = infectado.getVector().getPosicion().y+10;
	}
	*/
}
