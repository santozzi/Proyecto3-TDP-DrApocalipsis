package entidades.personajes.jugador.comandos;

import entidades.personajes.jugador.Jugador;

public class CaminarDerecha implements IComando {
    protected Jugador jugador;
	
	public CaminarDerecha(Jugador jugador) {
		this.jugador = jugador;
	}
	
	@Override
	public void ejecutar() {
		jugador.desplazarseDerecha();
	}

}
