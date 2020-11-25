package entidades.personajes.infectados;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;

import entidades.Vector;
import entidades.premios.Premio;
import entidades.premios.no_temporales.Pocion;
import entidades.premios.temporales.Cuarentena;
import entidades.premios.temporales.SuperArma;
import entidades.proyectiles.ParticulaAlpha;
import entidades.proyectiles.Proyectil;
import entidades.Entidad;
import logica.Juego;
import logica.Latencia;
import visitor.VisitanteInfectadoAlpha;
import visitor.VisitanteInfectadoBeta;
import visitor.Visitor;

/**
 * Este infectado tiene mayor resistencia
 * @author 
 *
 */
public class InfectadoBeta extends Infectado {
	
	public InfectadoBeta(Juego juego) {
		this.juego = juego;
		this.vector = new Vector(0, -1, 5);
		this.cargaViral = 200;
		tirarParticula();
		v = new VisitanteInfectadoBeta(this);
	}
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
	}
	@Override
	public void actuar() {
		// TODO Auto-generated method stub
		
	}
}
