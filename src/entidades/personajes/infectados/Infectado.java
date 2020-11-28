package entidades.personajes.infectados;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
import entidades.proyectiles.particulas.Particula;
import entidades.proyectiles.particulas.ParticulaAlpha;
import logica.ColeccionDeImagenes;
import logica.HiloSecundario;
import logica.Juego;
import visitor.VisitanteInfectadoAlpha;
import visitor.Visitor;

public abstract class Infectado extends Personaje {

	protected Particula particula;
	protected int rango;
	

	public Infectado(Juego juego) {
		super(juego);
		this.vector = new Vector(0,1,6);
		this.tiempoDeEspera = 1000;
		this.rango = 100;
		this.cargaViral = 100;

		tirarParticula();
	}

	public boolean estaCurado() {
		return cargaViral<=0;
	}

	public void atacar() {
		imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen("infectado_atacar");

		v.visitarJugador(juego.getJugador());
	}


abstract public void tirarParticula() ;
protected int puntos;
	@Override
	public void setPosicion(int x, int y) {
		vector.getPosicion().x= x;
		vector.getPosicion().y= y;

		if(particula!=null) {
			particula.getVector().getPosicion().x = x;
			particula.getVector().getPosicion().y = y;
		}
	}
	@Override
	public void desaparecer() {
		super.desaparecer();
		this.juego.agregarItem(claveImagen, puntos);
		this.juego.notificarBajaDeInfectado(this);
		curar();
	}
	

	public void curar() {
		Entidad humano = new Humano(juego);
		humano.setPosicion(vector.getPosicion().x, vector.getPosicion().y);


		juego.agregarAEntidadesParaAgregar(humano);
		particula.desaparecer();

	}

	public int getRango() {
		return rango;
	}
/*
	public List<Entidad> detectarColisiones() {
		List<Entidad> listaDeColisiones = new LinkedList<Entidad>();
		List<Entidad> listaDeLatencia = juego.getLista();
		boolean esta = false;

		Entidad entidadActual = this;
		Entidad entVerificar;
		Iterator<Entidad> itEntidades ;
		for(Entidad entidadDeLatencia : listaDeLatencia) {
			itEntidades = listaDeColisiones.iterator();


			if(entidadActual!=entidadDeLatencia&&hayColision(entidadDeLatencia)) {
				//-----para que no haya repetidos----
				while(itEntidades.hasNext()&&!esta) {
					entVerificar = itEntidades.next();
					esta= entVerificar == entidadDeLatencia;
				}
				//-------------------------------------

				if(!esta)
					listaDeColisiones.add(entidadDeLatencia);
				else
					esta = false;

			} 

		}
		return listaDeColisiones;
	}  

*/

	
	@Override
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
	
	public void accionar() {
		for(Entidad ent : detectarColisiones()) {
			ent.accept(v);
		}

	}
	public void desplazarse() {
		//this.posicion.y++;
		//this.vector.setModulo(6);
		this.vector.desplazarse();
		juego.actualizarEntidad(this);
		//detectarColisiones();
		//accionar();
		//detectarColisiones();
		//pregunatar cuando se choca con el limite del mapa

	}
}
