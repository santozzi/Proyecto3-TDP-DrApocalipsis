package entidades.premios.temporales;

import logica.Juego;
import visitor.VisitanteCuarentena;
import visitor.Visitor;
/**
 *Cuarentena
 *Detiene el movimiento de los infectados por un tiempo determinado 
 *
 */
public class Cuarentena extends Temporal{
    
	public Cuarentena(Juego juego) {
    	super(juego);
    	v= new VisitanteCuarentena(this);
    }
    
	@Override
	public void ejecutar() {
		this.juego.cuarentena();
	}

	@Override
	public void accept(Visitor v) {
		v.visitarCuarentena(this);
	}

	@Override
	public void impacto(int letalidad) {
		
	}
	

}
