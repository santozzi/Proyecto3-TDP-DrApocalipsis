package entidades.personajes.jugador.comandos;

import entidades.personajes.jugador.Jugador;
/**
 *Detenerse
 *Detiene al jugador 
 *
 */
public class Detenerse implements IComando {
    protected Jugador jugador;
    /**
     * Detenerse
     * @param jugador
     */
	public Detenerse(Jugador jugador) {
		this.jugador = jugador;
	}

	@Override
	public void ejecutar() {
		jugador.detenerse();
	}

}
