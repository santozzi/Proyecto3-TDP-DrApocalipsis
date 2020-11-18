package entidades.personajes.infectados;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

import entidades.Vector;
import entidades.premios.Premio;
import entidades.premios.no_temporales.Pocion;
import entidades.premios.temporales.Cuarentena;
import entidades.premios.temporales.SuperArma;
import entidades.proyectiles.Particula;
import entidades.Entidad;
import logica.Imagen;
import logica.Juego;
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
	public void tirarParticula() {
		particula = new Particula();
	}

	@Override
	public void atacar() {
		imagen.setImagen("infectado_atacar");
		v.visitarJugador(juego.getJugador());
	}

	@Override
	public void dejarCaerPremio() {
		Random random = new Random();
		int randomInt = random.nextInt(3);
		
		if(randomInt == 0)
			premio = new SuperArma();
		else if(randomInt == 1)
			premio = new Cuarentena();
		else
			premio = new Pocion();
		
		premio.getPosicion().setLocation(posicion);
	}

	@Override
	public boolean estaMuerto() {
		return energia<=0;
	}

	@Override
	public void desplazarse() {
		vector.avanzarEnY();
		//pregunatar cuando se choca con el limite del mapa
	}

	@Override
	public void accept(Visitor v) {
		v.visitarInfectadoBeta(this);
	}

	@Override
	public Imagen getImagen() {
		return imagen;
	}

	@Override
	public ArrayList<Entidad> detectarColisiones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accionar() {
		for(Entidad ent : detectarColisiones()) {
			//visitor
			ent.accept(v);
		}
	}

	@Override
	public Vector getVector() {
		return vector;
	}

	@Override
	public Point getPosicion() {
		return posicion;
	}

}
