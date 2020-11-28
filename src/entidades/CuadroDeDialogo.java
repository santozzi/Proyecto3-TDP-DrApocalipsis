package entidades;

import logica.ColeccionDeImagenes;
import logica.HiloSecundario;
import logica.Juego;
import visitor.Visitor;

public class CuadroDeDialogo extends Entidad {

	public CuadroDeDialogo(Juego j) {
		super(j);
		
		this.claveImagen = new String("dialogo");
		this.imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(this.claveImagen);
		vector = new Vector(0, 1, 1);
		//this.v = new VisitanteCuadroDeDialogo(this);
	}
	
	@Override
	public void desplazarse() {
		this.vector.desplazarse();
		if(this.vector.getPosicion().y >= Juego.ALTO_DE_COMBATE)
			this.desaparecer();
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub

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
