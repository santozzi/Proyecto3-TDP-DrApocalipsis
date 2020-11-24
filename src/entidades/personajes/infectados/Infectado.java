package entidades.personajes.infectados;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

import entidades.Entidad;
import entidades.Vector;
import entidades.personajes.Humano;
import entidades.personajes.Personaje;
import entidades.premios.Premio;
import entidades.premios.no_temporales.Pocion;
import entidades.premios.temporales.Cuarentena;
import entidades.premios.temporales.SuperArma;
import entidades.proyectiles.ParticulaAlpha;
import logica.ColeccionDeImagenes;
import logica.Juego;
import visitor.VisitanteInfectadoAlpha;
import visitor.Visitor;

public abstract class Infectado extends Personaje {

	protected ParticulaAlpha particula;

	protected int rango;

	/**
	 * tirarParticulas
	 * ---------------
	 * Son las particulas que lanza el infectado
	 * estas particulas son de tipo Proyectil
	 */
	
	 public boolean estaCurado() {
		   return cargaViral<=0;
	   }
	 
	/**
	 * atacar
	 * ------
	 * Genera daño a lo que tenga adelante.
	 */
	public void atacar() {
		imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen("infectado_atacar");

		v.visitarJugador(juego.getJugador());
	}


	public void tirarParticula() {
    	this.particula= new ParticulaAlpha(juego,this);
    }
	@Override
	public void setPosicion(int x, int y) {
		vector.getPosicion().x= x;
		vector.getPosicion().y= y;

		particula.getVector().getPosicion().x = x;
		particula.getVector().getPosicion().y = y;

	}


	public void impacto(int disparo) {
		if(cargaViral-disparo>0) { 
			this.cargaViral -=disparo;
		
		}else
			curar();
	} 
	public void curar() {
		Entidad humano = new Humano(juego);
		humano.setPosicion(vector.getPosicion().x, vector.getPosicion().y);
		
		
		juego.agregarAEntidadesParaAgregar(humano);
		particula.desaparecer();
		this.desaparecer();
		
	}
	
	public int getRango() {
		return rango;
	}
	public boolean hayColision(Entidad entidad) {
		// entidad.getEntorno() this.entorno
		//entorno = [x;x+anchoEntidad]
		//entornoEnY= [[y;y+anchoEntidad]
		int posEntidadActualX =this.vector.getPosicion().x;
		int posEntidadActualY =this.vector.getPosicion().y;
		int posEntidadParametroX =entidad.getVector().getPosicion().x;
		int posEntidadConAnchoX= posEntidadParametroX+entidad.getImagen().getIconWidth();

		int posEntidadParametroY =entidad.getVector().getPosicion().y ;
		int posEntidadConAltoY= posEntidadParametroY +entidad.getImagen().getIconHeight();

		boolean colisionEnX = (posEntidadActualX<= posEntidadConAnchoX) && (posEntidadActualX >= posEntidadParametroX-10);
		boolean colisionEnY = (posEntidadActualY+this.getImagen().getIconHeight()==posEntidadParametroY);// && (+this.getPosicion().y<=posEntidadParametroY);


		return colisionEnX &&colisionEnY;
		/*	
				(
				this.vector.getPosicion().y <= 
			(entidad.getVector().getPosicion().y+entidad.getImagen().getIconHeight())&&
						this.vector.getPosicion().y >= (entidad.getVector().getPosicion().y));
		 */
	}
}
