package entidades.premios.temporales;

import entidades.Vector;
import logica.ColeccionDeImagenes;
import logica.Juego;
import entidades.Entidad;
import visitor.VisitanteCuarentena;
import visitor.Visitor;

public class Cuarentena extends Temporal{
    
	public Cuarentena(Juego juego) {
    	super(juego);
    	vector = new Vector(0,1,1);
    	v= new VisitanteCuarentena(this);
    	this.claveImagen = new String("cuarentena");
    	imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(claveImagen);
    }
    
	@Override
	public void ejecutar() {
		this.juego.cuarentena();
	}

	@Override
	public void accept(Visitor v) {
		v.visitarCuarentena(this);
	}
	
	


}
