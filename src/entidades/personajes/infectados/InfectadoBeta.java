package entidades.personajes.infectados;

import java.util.Random;

import entidades.proyectiles.particulas.ParticulaBeta;
import logica.Juego;
import reproductor_de_audio.Sonidos;
import visitor.VisitanteInfectadoBeta;
import visitor.Visitor;

/**
 * Este infectado tiene mayor resistencia
 * @author 
 *
 */
public class InfectadoBeta extends Infectado {
	
	public InfectadoBeta(Juego juego) {
        super(juego);
		this.rango = 100;
		this.puntos = 15;
		v = new VisitanteInfectadoBeta(this);
		
	}
	@Override
	public void accept(Visitor v) {
		v.visitarInfectadoBeta(this);
	}
	@Override
	public void tirarParticula() {
    	this.particula= new ParticulaBeta(juego,this);
    }
	@Override
	public InfectadoBeta clone() {
		return new InfectadoBeta(juego);
	}
}
