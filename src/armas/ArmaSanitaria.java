package armas;

import entidades.proyectiles.Proyectil;
import entidades.proyectiles.proyectil_jugador.ProyectilSanitario;
import logica.Juego;

public class ArmaSanitaria extends Arma{
     
	
	public ArmaSanitaria(Juego juego) {
		super(juego);
	}

	@Override
	public void disparar() {
		super.disparar();
		new ProyectilSanitario(juego);
	}




}
