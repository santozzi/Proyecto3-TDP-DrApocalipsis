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
import entidades.proyectiles.Particula;
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
		this.vector = new Vector(0, -1, 3);
		this.energia = 200;
		
		v = new VisitanteInfectadoBeta(this);
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Entidad> detectarColisiones() {
		 System.out.println("soy beta");
		 List<Entidad> listaDeColisiones = new LinkedList<Entidad>();
		 List<Latencia> listaDeLatencia = juego.getLista();
		 Entidad entidadDeLatencia;
		 Entidad entidadActual = this;
		 for(Latencia latencia : listaDeLatencia) {
			 entidadDeLatencia = latencia.getEntidad();
			 if(entidadActual!=entidadDeLatencia) {
				 if(this.vector.getPosicion().equals(entidadDeLatencia.getVector().getPosicion())) {
					 listaDeColisiones.add(entidadDeLatencia);
					 System.out.println("choque");
				 }
			 }
		 }
		 
		 return listaDeColisiones;
	}

	@Override
	public boolean hayColision(Entidad entidad) {
		// TODO Auto-generated method stub
		return false;
	}


}
