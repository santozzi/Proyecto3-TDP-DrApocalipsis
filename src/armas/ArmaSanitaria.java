package armas;
import entidades.proyectiles.*;
import entidades.proyectiles.proyectiljugador.ProyectilSanitario;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import entidades.Entidad;
import entidades.Vector;
import logica.ColeccionDeImagenes;
import logica.Juego;
import visitor.VisitanteJugador;
import visitor.Visitor;

public class ArmaSanitaria extends Arma{
     
	
	public ArmaSanitaria(Juego juego) {
		super(juego);
		imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen("Jugador_dispara");
		this.claveImagen= "Jugador_dispara";
	}

	@Override
	public void disparar() {
      
		proyectil = new ProyectilSanitario(juego);
		
		
	}




}
