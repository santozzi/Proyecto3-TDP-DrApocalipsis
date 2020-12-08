package armas;

import entidades.proyectiles.proyectil_jugador.ProyectilSanitario;
import logica.Juego;
/**
 * ArmaSanitaria
 * Crea un proyectilSanitario por disparo
 */
public class ArmaSanitaria extends Arma{
     
	/**
	 * Arma sanitaria
	 * @param juego
	 */
	public ArmaSanitaria(Juego juego) {
		super(juego);
	}

	@Override
	public void disparar() {
		super.disparar();
		new ProyectilSanitario(juego);
	}




}
