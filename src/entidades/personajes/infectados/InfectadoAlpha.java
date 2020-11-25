package entidades.personajes.infectados;

import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import entidades.Entidad;
import entidades.Vector;
import entidades.proyectiles.ParticulaAlpha;
import logica.ColeccionDeImagenes;
import logica.HiloSecundario;
import logica.Juego;
import visitor.*;
import visitor.Visitor;

/**
 * Estos infectados tienen menor resistencia y 
 * mayor letalidad.
 * @author 
 *
 */
public class InfectadoAlpha extends Infectado{
	protected ParticulaAlpha particula;
	protected final int VELOCIDAD_BASE = 6;
	
	public InfectadoAlpha(Juego juego) {
		this.juego = juego;

		this.vector = new Vector(0, 1, 6);
		this.cargaViral = 80;

		this.claveImagen = new String("InfectadoAlpha_golpear");
		imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(this.claveImagen);
		estadoTemporal= false;
		tiempoDeEspera = 1000;

		this.rango = 100;
		v = new VisitanteInfectadoAlpha(this);
		tirarParticula();
	}
	//tiene que existir particulaAlpha y particulaBeta;

	/**
	 * duplicarVelocidad
	 * -----------------
	 * Duplica la velocidad del personaje
	 * cuando este tiene menos del 20% de energia
	 */
	public void duplicarVelocidad() {

		// si no esta afectado por la cuarentena entonces duplico su velocidad
		if(this.vector.getModulo()>0) { 
			vector.setModulo(8);
			//vector.setModulo(vector.getModulo()*2);
			particula.getVector().setModulo(9);
		}
	}
	
	public void tirarParticula() {
    	this.particula= new ParticulaAlpha(juego,this);
    }
	
	// v es de jugador
	@Override
	public void accept(Visitor v) {
		v.visitarInfectadoAlpha(this);
	}
	@Override
	public void impacto(int disparo) {
		super.impacto(disparo);
		if(cargaViral-disparo>0 && cargaViral-disparo<=20)
			duplicarVelocidad();
	}

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
	public void accionar() {
		for(Entidad ent : detectarColisiones()) {
			ent.accept(v);
		}

	}

	@Override
	public void actuar() {
      int vueltasAEsperar;
		if(estadoTemporal) {
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

}
