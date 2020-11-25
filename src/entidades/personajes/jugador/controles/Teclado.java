package entidades.personajes.jugador.controles;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener{
    protected boolean llave;
    protected boolean derecha;
    protected boolean izquierda;
    protected boolean disparar;

    
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

	public boolean isLlave() {
		return llave;
	}

	public void setLlave(boolean llave) {
		this.llave = llave;
	}

	public boolean isDerecha() {
		return derecha;
	}

	public void setDerecha(boolean derecha) {
		this.derecha = derecha;
	}

	public boolean isIzquierda() {
		return izquierda;
	}

	public void setIzquierda(boolean izquierda) {
		this.izquierda = izquierda;
	}

	public boolean isDisparar() {
		return disparar;
	}

	public void setDisparar(boolean disparar) {
		this.disparar = disparar;
	}

	

}
