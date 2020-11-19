package entidades.armas;
import entidades.proyectiles.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import entidades.Entidad;
import entidades.Vector;
import logica.Imagen;
import visitor.VisitanteJugador;
import visitor.Visitor;

public class ArmaSanitaria extends Arma{

	@Override
	public void disparar() {

		proyectil = new ProyectilSanitario(juego);
		
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		//v = new VisitanteAr(this);
	}

	@Override
	public void desplazarse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ImageIcon getImagen() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Entidad> detectarColisiones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accionar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector getVector() {
		// TODO Auto-generated method stub
		return null;
	}

}
