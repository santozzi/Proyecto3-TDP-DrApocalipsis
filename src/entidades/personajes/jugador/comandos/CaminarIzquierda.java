package entidades.personajes.jugador.comandos;

import entidades.personajes.jugador.Jugador;
/**
 * CaminarIzquierda
 * Ejecuta que el jugador camine hacia la izquierda 
 *
 */
public class CaminarIzquierda implements IComando {
    protected Jugador jugador;
    /**
     * CaminarIzquierda
     * @param jugador
     */
    public CaminarIzquierda(Jugador jugador) {
		this.jugador = jugador;
	}

	@Override
	public void ejecutar() {
		jugador.desplazarseIzquierda();
	}

}
