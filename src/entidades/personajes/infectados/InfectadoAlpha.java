package entidades.personajes.infectados;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import entidades.Vector;
import entidades.premios.*;
import entidades.premios.no_temporales.Pocion;
import entidades.premios.temporales.Cuarentena;
import entidades.premios.temporales.SuperArma;
import entidades.proyectiles.Particula;
import entidades.proyectiles.Proyectil;
import entidades.Entidad;
import logica.ColeccionDeImagenes;
import logica.Juego;
import logica.Latencia;
import visitor.*;
import visitor.Visitor;

/**
 * Estos infectados tienen menor resistencia y 
 * mayor letalidad.
 * @author 
 *
 */
public class InfectadoAlpha extends Infectado{

	public InfectadoAlpha(Juego juego) {
		this.juego = juego;
		this.vector = new Vector(0, 1, 350);
		this.energia = 80;
		this.posicion = new Point();
		this.claveImagen = new String("InfectadoAlpha_golpear");
		imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(this.claveImagen);
		
		this.rango = 100;
		v = new VisitanteInfectadoAlpha(this);
		tirarParticula();
	}
	
	//tiene que existir particulaAlpha y particulaBeta;
    public void tirarParticula() {
    	this.particula= new Particula(juego,this);
    	
    }
	/**
	 * duplicarVelocidad
	 * -----------------
	 * Duplica la velocidad del personaje
	 * cuando este tiene menos del 20% de energia
	 */
	public void duplicarVelocidad() {
		vector.setModulo(700);
		particula.getVector().setModulo(1000);
	}

    
	// v es de jugador
	@Override
	public void accept(Visitor v) {
		v.visitarInfectadoAlpha(this);
		
	}
	
	public int getRango() {
		return rango;
	}
	@Override
	public void impacto(int disparo) {
		super.impacto(disparo);
		  if(energia-disparo<=20) {
		     duplicarVelocidad();   
		   }
	}
	

}
