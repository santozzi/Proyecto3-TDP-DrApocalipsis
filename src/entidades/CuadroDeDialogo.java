package entidades;

import logica.ColeccionDeImagenes;
import logica.Juego;
import visitor.VisitanteCuadroDeDialogo;
import visitor.Visitor;

public class CuadroDeDialogo extends Entidad {

	public CuadroDeDialogo(Juego j) {
		this.juego = j;
		this.claveImagen = new String("dialogo");
		this.imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(this.claveImagen);
		this.vector = new Vector(0, 1, 1);
		this.v = new VisitanteCuadroDeDialogo(this);
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

}
