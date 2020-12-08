package entidades.personajes.jugador.comandos;

import entidades.personajes.jugador.Jugador;
/**
 * CaminarDerecha
 * Ejecuta que el jugador camine hacia la derecha
 */
public class CaminarDerecha implements IComando {
    protected Jugador jugador;
	/**
	 * CaminarDerecha
	 * @param jugador
	 */
	public CaminarDerecha(Jugador jugador) {
		this.jugador = jugador;
	}
	
	@Override
	public void ejecutar() {
		jugador.desplazarseDerecha();
	}

}
