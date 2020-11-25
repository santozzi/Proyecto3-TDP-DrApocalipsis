package armas;

import entidades.proyectiles.ProyectilSanitario;
import entidades.proyectiles.SuperProyectilSanitario;
import logica.ColeccionDeImagenes;
import logica.Juego;

/**
 * Los proyectiles de esta arma causan mas daño
 * @author 
 *
 */
public class SuperArmaSanitaria extends Arma{

	public SuperArmaSanitaria(Juego juego) {
		super(juego);
		this.claveImagen= "Jugador_dispara_sa";
		imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(claveImagen);
		
	}

	@Override
	public void disparar() {
		proyectil = new SuperProyectilSanitario(juego);
		
	}

}
