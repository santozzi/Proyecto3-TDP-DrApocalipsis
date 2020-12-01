package armas;

import entidades.proyectiles.proyectil_jugador.SuperProyectilSanitario;
import logica.Juego;

/**
 * Los proyectiles de esta arma causan mas daño
 * @author 
 *
 */
public class SuperArmaSanitaria extends Arma{

	public SuperArmaSanitaria(Juego juego) {
		super(juego);
	}
	
	@Override
	public void disparar() {
		super.disparar();
		proyectil = new SuperProyectilSanitario(juego);
	}
	
}