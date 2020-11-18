package entidades.personajes.jugador.comandos;

import entidades.personajes.jugador.Jugador;

public class CaminarIzquierda implements IComando {
    protected Jugador jugador;
    
    
	public CaminarIzquierda(Jugador jugador) {
		this.jugador = jugador;
	}


	@Override
	public void ejecutar() {
		jugador.desplazarseIzquierda();

	}

}
