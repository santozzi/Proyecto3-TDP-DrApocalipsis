package entidades.personajes.jugador.comandos;

import entidades.personajes.jugador.Jugador;

public class Detenerse implements IComando {
    protected Jugador jugador;
    
	public Detenerse(Jugador jugador) {
		this.jugador = jugador;
	}

	@Override
	public void ejecutar() {
		jugador.detenerse();
	}

}
