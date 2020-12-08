package entidades.personajes.jugador.controles;

import java.awt.event.KeyEvent;

/**
 * Configura la acción del teclado
 *
 */

public class Teclado extends InterfazDeControl {

	@Override
	public void keyPressed(KeyEvent e) {

		if(KeyEvent.VK_D==e.getKeyCode()) {
			derecha=true;
		}
		if(KeyEvent.VK_A==e.getKeyCode()) {
			izquierda=true;
		}
		if(KeyEvent.VK_SPACE==e.getKeyCode()) {
			disparar=true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(KeyEvent.VK_D==e.getKeyCode()) {
			derecha=false;
		}
		if(KeyEvent.VK_A==e.getKeyCode()) {
			izquierda=false;
		}
		if(KeyEvent.VK_SPACE==e.getKeyCode()) {
			disparar=false;
			llave=true;
		}
	}

	

}
