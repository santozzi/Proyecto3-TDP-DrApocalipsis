package entidades.personajes;



import entidades.Vector;
import entidades.personajes.infectados.Infectado;
import entidades.personajes.infectados.InfectadoAlpha;
import logica.ColeccionDeImagenes;
import logica.Juego;
import visitor.VisitanteHumano;
import visitor.Visitor;

public class Humano extends Personaje {
	
	public Humano(Juego j) {
		this.juego = j;
		this.cargaViral = 0;
	
		this.vector = new Vector(0, 1, 3);
		this.claveImagen = new String("humano");
		this.imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(this.claveImagen);
		this.v = new VisitanteHumano(this);
		
		
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
	private void infectar() {
		Infectado ia = new InfectadoAlpha(this.juego);
		ia.setPosicion(this.getPosicion().x, this.getPosicion().y);
	}

}
