package armas;

import entidades.proyectiles.proyectiljugador.ProyectilSanitario;
import logica.ColeccionDeImagenes;
import logica.Juego;

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
