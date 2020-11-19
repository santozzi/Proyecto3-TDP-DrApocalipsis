package entidades.personajes.jugador.comandos;

import entidades.personajes.jugador.Jugador;

public class Disparar implements IComando {
    protected Jugador jugador;
    
	public Disparar(Jugador jugador) {
		this.jugador = jugador;
	}

	@Override
	public void ejecutar() {
		jugador.disparar();

	}

}
