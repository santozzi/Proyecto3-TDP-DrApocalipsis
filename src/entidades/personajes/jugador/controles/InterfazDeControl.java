package entidades.personajes.jugador.controles;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * InterfazDeControl
 * Es una clase intermedia entre los Listeners y los perifericos
 */
public class InterfazDeControl implements KeyListener, MouseListener {
    protected boolean llave;
    protected boolean derecha;
    protected boolean izquierda;
    protected boolean disparar;

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
	
	//--------------métodos de MouseListener----------
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	//-------------------------------------------------
	//------------métodos de KeyListener---------------
	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyPressed(KeyEvent e) {
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}
	//-------------------------------------------------
}
