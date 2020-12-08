package entidades.personajes.infectados;

import entidades.Entidad;
import entidades.personajes.Humano;
import entidades.personajes.Personaje;
import entidades.proyectiles.particulas.Particula;
import logica.HiloSecundario;
import logica.Juego;

/**
 * Infectado
 * Todo enemigo del juego es un infectado es una especialización de personaje
 * 
 */

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
		this.vector.setModulo(4);
		this.rango = 150;
		this.cargaViral = 150;
		tiempoDeParticula=300;
		contarTiempoDeParticula=0;
		tiempoDeAtaque=300;
		contarTiempoDeAtaque=300;
		this.letalidadFisica=5;
		atacar= false;
		entidad = null;
	}

	/**
	 * estaCurado
	 * 
	 * @return Este metodo devuelve verdadero si el infectao esta curado y falso si no.
	 */
	public boolean estaCurado() {
		return cargaViral<=0;
	}
	/**
	 * tirarParticula
	 * ---------------
	 * Son las particulas que lanza el infectado
	 * estas particulas son de tipo Particula
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
	/**
	 * curar
	 * Acción a realizar cuando el infectado se cura.
	 */
	public void curar() {
		Entidad humano = new Humano(juego);
		humano.setPosicion(vector.getPosicion().x, vector.getPosicion().y);
		juego.agregarAEntidadesParaAgregar(humano);
		if(particula!=null)
			particula.desaparecer();
		this.desaparecer();
	}
	/**
	 * getRango
	 * Los infectados tienen un rango que representa hasta donde llegan las particulas.
	 * @return devuelve un entero con el rango de la particula.
	 */
	public int getRango() {
		return rango;
	}

	/**
	 * intervaloDeTirarParticula
	 * Determina cada cuanto se tira una nueva particula.
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
			vueltasAEsperar = tiempoDeEspera;
		}else {
			int velocidad = vector.getModulo();
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

	public void desplazarse() {
		this.vector.desplazarse();
		juego.actualizarEntidad(this);
	}

	/**
	 * intervaloDeAtaque
	 * Determina cada cuanto el infectado genera un impacto, en otra entidad
	 * cuando se detecta una colisión, este metodo se activa cuando atarcar = true
	 */
	protected void intervaloDeAtaque() {
		if(contarTiempoDeAtaque>=tiempoDeAtaque) {
			entidad.impacto(letalidadFisica);
			contarTiempoDeAtaque=0;
		}else {
			contarTiempoDeAtaque++;
		}
		this.atacar = false;
		entidad= null;
	}
	/**
	 * atacar
	 * Acciona el metodo intervaloDeAtaque volviendo a atacar= true
	 * @param ent entidad a la que se va a atacar
	 */
	public void atacar(Entidad ent) {
		this.atacar=true;
		this.entidad= ent;

	}

	/**
	 * getLetalidadFisica
	 * Los infectados atacan al contacto y tienen un valor de letalidad fisica
	 * @return la letalidad fisica del infectado.
	 */
	public int getLetalidadFisica() {
		return letalidadFisica;
	}

	/**
	 * Clona al infectado
	 */
	abstract public Infectado clone();
}
