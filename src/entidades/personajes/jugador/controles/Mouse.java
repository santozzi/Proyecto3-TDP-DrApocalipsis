package entidades.personajes.jugador.controles;

import java.awt.event.MouseEvent;

public class Mouse extends InterfazDeControl{
	@Override
	public void mouseClicked(MouseEvent e) {
	
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		disparar=true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		disparar=false;
		llave=true;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
