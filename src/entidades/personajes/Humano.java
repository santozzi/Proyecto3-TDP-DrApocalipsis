package entidades.personajes;

import java.util.Random;

import entidades.CuadroDeDialogo;
import entidades.premios.Premio;
import entidades.premios.no_temporales.Diamante;
import entidades.premios.no_temporales.Moneda;
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
	protected boolean soltoPremio;

	public Humano(Juego j) {
		super(j);
		this.cargaViral = 0;
		this.vector.setModulo(7);
		this.v = new VisitanteHumano(this);
		this.soltoPremio = false;

		crearPremio();

	}
	private void crearPremio() {
		Random random = new Random();
		int randomInt = random.nextInt(5);
		this.claveImagen = new String();

		if(randomInt == 0)
			premio = new Pocion(juego);
		else if(randomInt == 1)
			premio = new SuperArma(juego);
		else if(randomInt == 2)
			premio = new Moneda(juego);
		else if(randomInt == 3)
			premio = new Diamante(juego);
		else
			premio = new Cuarentena(juego);

		this.claveImagen = this.getClass().getSimpleName()+"_"+premio.getClaveImagen();
		this.imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(this.claveImagen);
	}

	public void accept(Visitor v) {
		v.visitarHumano(this);
	}
	/*
	@Override
	public void impacto(int infeccion) {
		if(cargaViral+infeccion<100) 
			this.cargaViral += infeccion;
		else
			infectar();
	} 
	 */
	@Override
	public void desplazarse() {
		super.desplazarse();
		if(this.vector.getPosicion().y >= Juego.ALTO_DE_COMBATE)
			this.desaparecer();
	}
	/**
	 *dejarCaerPremio
	 *---------------
	 *Genera un nuevo objerto de tipo premio
	 *y lo agrega a la colección de entidades.
	 */
	public void dejarCaerPremio() {
		CuadroDeDialogo dialogo = new CuadroDeDialogo(juego);
		this.claveImagen = this.getClass().getSimpleName()+"_Correr";
		this.imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(this.claveImagen);
		premio.getPosicion().setLocation(this.getPosicion());

		dialogo.getPosicion().x = getPosicion().x+10;
		dialogo.getPosicion().y = getPosicion().y-30;
		vector.setModulo(8);
		dialogo.getVector().setModulo(vector.getModulo());
		juego.agregarAEntidadesParaAgregar(premio);
		juego.agregarAEntidadesParaAgregar(dialogo);
		soltoPremio = true;
	}
	public boolean soltoPremio() {
		return this.soltoPremio;
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
