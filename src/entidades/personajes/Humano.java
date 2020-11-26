package entidades.personajes;

import java.util.Random;

import entidades.CuadroDeDialogo;
import entidades.Entidad;
import entidades.Vector;
import entidades.personajes.infectados.Infectado;
import entidades.personajes.infectados.InfectadoAlpha;
import entidades.premios.Premio;
import entidades.premios.no_temporales.Pocion;
import entidades.premios.temporales.Cuarentena;
import entidades.premios.temporales.SuperArma;
import logica.ColeccionDeImagenes;
import logica.HiloSecundario;
import logica.Juego;
import visitor.VisitanteHumano;
import visitor.Visitor;

public class Humano extends Personaje {
	protected Premio premio;
	protected CuadroDeDialogo dialogo;
	protected boolean soltoPremio;

	public Humano(Juego j) {
		this.juego = j;
		this.cargaViral = 0;

		this.vector = new Vector(0, 1, 7);
		//this.claveImagen = new String("humano");
		//this.imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(this.claveImagen);
		this.v = new VisitanteHumano(this);
		this.soltoPremio = false;
		
		crearPremio();

	}

	private void crearPremio() {
		Random random = new Random();
		int randomInt = random.nextInt(3);
		this.claveImagen = new String();
		
		if(randomInt == 0) {
			premio = new Pocion(juego);
			this.claveImagen = "humanoPocion";
		}
		else if(randomInt == 1) {
			premio = new SuperArma(juego);
			this.claveImagen = "humanoSuperArma";
		}
		else {
			premio = new Cuarentena(juego);
			this.claveImagen = "humanoCuarentena";
		}
		this.imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(this.claveImagen);
	}

	/*
	 *dejarCaerPremio
	 *---------------
	 *Genera un nuevo objerto de tipo premio
	 *y lo agrega a la colección de entidades.

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
	 */

	public void accept(Visitor v) {
		v.visitarHumano(this);
	}
	@Override
	public void impacto(int infeccion) {
		if(cargaViral+infeccion<100) 
			this.cargaViral += infeccion;
		else
			infectar();
	} 
	@Override
	public void desplazarse() {
		super.desplazarse();
		if(this.vector.getPosicion().y >= Juego.ALTO_DE_COMBATE)
			this.desaparecer();
	}
	private void infectar() {
		Infectado ia = new InfectadoAlpha(this.juego);
		ia.setPosicion(this.getPosicion().x, this.getPosicion().y);
	}
	/**
	 *dejarCaerPremio
	 *---------------
	 *Genera un nuevo objerto de tipo premio
	 *y lo agrega a la colección de entidades.
	 */
	public void dejarCaerPremio() {
		dialogo = new CuadroDeDialogo(juego);
		this.claveImagen = "humanoCorrer";
		this.imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(this.claveImagen);
		premio.getPosicion().setLocation(this.getPosicion());
		//premio.getPosicion().x = getPosicion().x;
		//premio.getPosicion().y = getPosicion().y-50;
		dialogo.getPosicion().x = getPosicion().x+10;
		dialogo.getPosicion().y = getPosicion().y-30;
		this.dialogo.getVector().setModulo(8);
		juego.agregarAEntidadesParaAgregar(premio);
		juego.agregarAEntidadesParaAgregar(dialogo);
		soltoPremio = true;
	}
	public boolean soltoPremio() {
		return this.soltoPremio;
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

	public void actuar() {
		int vueltasAEsperar;

		int velocidad = vector.getModulo();

		vueltasAEsperar =HiloSecundario.LATENCIA_MAXIMA-velocidad;

		if(vueltasAEsperar>0&&vueltasAEsperar<HiloSecundario.LATENCIA_MAXIMA) {
			if(latencia>=vueltasAEsperar) {
				desplazarse();
				juego.actualizarEntidad(this);
				accionar();
				latencia= 1;
			}else {
				latencia++;
			}
		}

	}
}
