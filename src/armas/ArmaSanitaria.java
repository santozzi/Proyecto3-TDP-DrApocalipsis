package armas;
import entidades.proyectiles.*;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import entidades.Entidad;
import entidades.Vector;
import logica.Juego;
import visitor.VisitanteJugador;
import visitor.Visitor;

public class ArmaSanitaria extends Arma{
     
	
	public ArmaSanitaria(Juego juego) {
		super(juego);
		
	}

	@Override
	public void disparar() {
      
		proyectil = new ProyectilSanitario(juego);
		
		
	}


}
