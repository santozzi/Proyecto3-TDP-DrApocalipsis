package entidades.premios.temporales;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import entidades.Vector;
import logica.ColeccionDeImagenes;
import logica.Juego;
import entidades.Entidad;
import visitor.VisitanteCuarentena;
import visitor.VisitantePocion;
import visitor.Visitor;

public class Cuarentena extends Temporal{
    
	public Cuarentena(Juego juego) {
    	this.juego= juego;
    	vector = new Vector(0,1,1);
    	v= new VisitanteCuarentena(this);
    	this.claveImagen = new String("pocion");
    	imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(claveImagen);
    }
    
	@Override
	public void ejecutar() {
		for(Entidad entidad : this.juego.getNivel().getColeccionDeInfectados().getListaDeInfectados()) {
			entidad.detenerse();
		}
	}

	@Override
	public void accept(Visitor v) {
		v.visitarCuarentena(this);
	}
}
