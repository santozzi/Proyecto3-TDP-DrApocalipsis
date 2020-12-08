package entidades.personajes.infectados;

import java.util.Random;

import entidades.proyectiles.particulas.ParticulaAlpha;
import entidades.proyectiles.particulas.ParticulaBeta;
import logica.HiloSecundario;
import logica.Juego;

/**
 * Este infectado tiene mayor resistencia y se mueve en varias direcciones,
 * es una especialización de infectado ya que puede moverse en varias 
 * direcciones.
 */
abstract public class InfectadoBoss extends Infectado {
        protected boolean cambioDireccionOpuesta;
        protected int tiempoDeDireccion;
        protected int contarTiempoDeDireccion;
        protected Random ran;
        
	public InfectadoBoss(Juego juego) {
		super(juego);
		contarTiempoDeDireccion=0;
		this.rango = Juego.ALTO_DE_COMBATE;
		tiempoDeDireccion= 300;
		cambioDireccionOpuesta=false;
		ran = new Random();
	}
	@Override
	public void tirarParticula() {
	
		int azar = ran.nextInt(3);
		if(azar==0)
			this.particula= new ParticulaAlpha(juego,this);
		else
			this.particula= new ParticulaBeta(juego,this);
	}
    /**
     * cambioDeDireccion
     * Determina en que dirección se va a desplazar el infectado.
     */
    private void cambioDeDireccion() {
    	int direccionX = ran.nextInt(2)-1;
    	int direccionY = ran.nextInt(2)-1;
    	if(vector.getPosicion().y<=0)
    		vector.getDireccion().setLocation(0, 1);
    	else {
    	if(contarTiempoDeDireccion>=tiempoDeDireccion) {
    		vector.getDireccion().setLocation(direccionX, direccionY);
    		contarTiempoDeDireccion=0;
    	}else {
    		contarTiempoDeDireccion++;
    		if(vector.getPosicion().x+imagen.getIconWidth()>=Juego.ANCHO_DE_COMBATE
    				||vector.getPosicion().y+imagen.getIconHeight()>=Juego.ALTO_DE_COMBATE
    				||vector.getPosicion().x<=0
    				||vector.getPosicion().y<=0) {
    			vector.cambioDeSentido();
    		}
    	}
    	}
    }
    @Override
	public void actuar() {
		int vueltasAEsperar;
		if(estadoTemporal) {
			vueltasAEsperar = tiempoDeEspera;
		}else {
			int velocidad = vector.getModulo();
			vueltasAEsperar =HiloSecundario.LATENCIA_MAXIMA-velocidad;
		}
		if(vueltasAEsperar>0) {
			if(latencia>=vueltasAEsperar) {
				cambioDeDireccion();
				desplazarse();
				juego.actualizarEntidad(this);
				accionar();
				latencia= 1;
				estadoTemporal= false;
			}else {
				latencia++;
			}
		}
	
		intervaloDeTirarParticula();
			if(entidad!=null&&atacar)
			 intervaloDeAtaque();
	}
	
}
