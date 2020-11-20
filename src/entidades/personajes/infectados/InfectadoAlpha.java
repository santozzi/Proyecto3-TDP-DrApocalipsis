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
		this.vector = new Vector(0, 1, 1000);
		this.energia = 80;
		this.posicion = new Point();
		this.claveImagen = new String("InfectadoAlpha_golpear");
		imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(this.claveImagen);

		v = new VisitanteInfectadoAlpha(this);
	}

	/**
	 * duplicarVelocidad
	 * -----------------
	 * Duplica la velocidad del personaje
	 * cuando este tiene menos del 20% de energia
	 */
	public void duplicarVelocidad() {
		vector.setModulo(vector.getModulo()*2);
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}
	
	
	 public List<Entidad> detectarColisiones() {
		
		 List<Entidad> listaDeColisiones = new LinkedList<Entidad>();
		 List<Latencia> listaDeLatencia = juego.getLista();
		 Entidad entidadDeLatencia;
		 Entidad entidadActual = this;
		 for(Latencia latencia : listaDeLatencia) {
			 entidadDeLatencia = latencia.getEntidad();
			 if(entidadActual!=entidadDeLatencia) {
				 if(this.vector.getPosicion().equals(entidadDeLatencia.getVector().getPosicion())) {
					 listaDeColisiones.add(entidadDeLatencia);
					 System.out.println("choque con infectado alfa");
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
