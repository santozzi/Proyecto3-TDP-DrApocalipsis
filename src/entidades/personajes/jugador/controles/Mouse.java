package entidades.personajes.jugador.controles;

import java.awt.event.MouseEvent;
/**
 * Configura la acción del mouse
 *
 */
public class Mouse extends InterfazDeControl{

	@Override
	public void mousePressed(MouseEvent e) {
		disparar=true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		disparar=false;
		llave=true;
	}

}
