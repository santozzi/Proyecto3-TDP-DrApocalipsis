package armas;

import entidades.proyectiles.proyectil_jugador.SuperProyectilSanitario;
import logica.Juego;

/**
 * Los proyectiles de esta arma causan mas daño
 * Crea un SuperProyectilSanitario por disparo
 */
public class SuperArmaSanitaria extends Arma{
    /**
     * SuperArmaSanitaria
     * @param juego
     */
	public SuperArmaSanitaria(Juego juego) {
		super(juego);
	}
	
	@Override
	public void disparar() {
		super.disparar();
        new SuperProyectilSanitario(juego);
	}
	
}