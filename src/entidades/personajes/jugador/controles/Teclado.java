package entidades.personajes.jugador.controles;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener{
    static public boolean llave;
    static public boolean derecha;
    static public boolean izquierda;
    static public boolean disparar;

    
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

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
