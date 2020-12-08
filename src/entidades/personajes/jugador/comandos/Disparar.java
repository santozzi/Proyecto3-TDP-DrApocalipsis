package entidades.personajes.jugador.comandos;

import entidades.personajes.jugador.Jugador;
/**
 * Disparar
 * El jugador dispara
 */
public class Disparar implements IComando {
    protected Jugador jugador;
    /**
     * Disparar
     * @param jugador
     */
	public Disparar(Jugador jugador) {
		this.jugador = jugador;
	}

	@Override
	public void ejecutar() {
		jugador.disparar();
	}

}
