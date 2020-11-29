package entidades.personajes.infectados;

import entidades.Entidad;
import entidades.personajes.Humano;
import entidades.personajes.Personaje;
import entidades.proyectiles.particulas.Particula;
import logica.HiloSecundario;
import logica.Juego;
import logica.Vector;

public abstract class Infectado extends Personaje {
	   protected int tiempoDeParticula;
       protected int contarTiempoDeParticula;
       protected int tiempoDeAtaque;
       protected int contarTiempoDeAtaque;
       protected boolean atacar;
       
	protected Particula particula;
	protected int rango;
	protected int puntos;
	protected int letalidadFisica;
	protected Entidad entidad;
	

	public Infectado(Juego juego) {
		super(juego);
		this.vector = new Vector(0,1,4);
		this.tiempoDeEspera = 1000;
		this.rango = 150;
		this.cargaViral = 150;
		tiempoDeParticula=300;
		contarTiempoDeParticula=0;
		tiempoDeAtaque=300;
		contarTiempoDeAtaque=0;
		this.letalidadFisica=5;
		atacar= false;
		entidad = null;
	}



	/**
	 * tirarParticulas
	 * ---------------
	 * Son las particulas que lanza el infectado
	 * estas particulas son de tipo Proyectil
	 */

	public boolean estaCurado() {
		return cargaViral<=0;
	}
/*

	public void atacar() {
		imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen("infectado_atacar");

		v.visitarJugador(juego.getJugador());
	}
*/

	abstract public void tirarParticula();
	
	
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
		if(particula!=null)
		   particula.desaparecer();
		this.desaparecer();

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

    protected void intervaloDeTirarParticula() {
    
    	if(contarTiempoDeParticula>=tiempoDeParticula) {
    		tirarParticula();
    		contarTiempoDeParticula=0;
    	}else {
    		contarTiempoDeParticula++;
    	
    	}
    }
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
		intervaloDeTirarParticula();
		if(entidad!=null&&atacar)
		 intervaloDeAtaque();
	
		
		
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

	
    private void intervaloDeAtaque() {
        
    	if(contarTiempoDeAtaque>=tiempoDeAtaque) {
    		 entidad.impacto(letalidadFisica);
    		contarTiempoDeAtaque=0;
    	}else {
    		contarTiempoDeAtaque++;
    	
    	}
    	this.atacar = false;
    	entidad= null;
    }
    public void atacar(Entidad ent) {
    	this.atacar=true;
    	this.entidad= ent;
    	
    }

	public int getLetalidadFisica() {
		return letalidadFisica;
	}



	public void setLetalidadFisica(int letalidadFisica) {
		this.letalidadFisica = letalidadFisica;
	}
	abstract public Infectado clone();
}
