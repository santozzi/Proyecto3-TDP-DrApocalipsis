package entidades.personajes.infectados;

import java.util.Random;

import entidades.proyectiles.ParticulaAlpha;
import entidades.proyectiles.ParticulaBeta;
import logica.ColeccionDeImagenes;
import logica.HiloSecundario;
import logica.Juego;
import visitor.VisitanteInfectadoBeta;
import visitor.VisitanteInfectadoBossAlpha;
import visitor.Visitor;

/**
 * Este infectado tiene mayor resistencia
 * @author 
 *
 */
abstract public class InfectadoBoss extends Infectado {
        protected boolean cambioDireccionOpuesta;
        protected int tiempoDeDireccion;
        protected int contarTiempoDeDireccion;
        
	public InfectadoBoss(Juego juego) {
		super(juego);
		contarTiempoDeDireccion=0;
		this.rango = 100;
		tiempoDeDireccion= 300;
		cambioDireccionOpuesta=false;
	
	}

	public void tirarParticula() {
		Random ran = new Random();
		int azar = ran.nextInt(3);
		if(azar==0)
			this.particula= new ParticulaAlpha(juego,this);
		else
			this.particula= new ParticulaBeta(juego,this);
	}
	
    private void cambioDeDireccion() {
    	Random ranDir = new Random();
    	int direccionX = ranDir.nextInt(2)-1;
    	int direccionY = ranDir.nextInt(2)-1;
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
	public void actuar() {

		int vueltasAEsperar;

		if(estadoTemporal) {
			//tiempo de espera es 1000
			vueltasAEsperar = tiempoDeEspera;
		}else {
			int velocidad = vector.getModulo();
			// {
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
	}
	
}
