package GUI;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import logica.ColeccionDeImagenes;

import javax.swing.JLabel;
import java.awt.Color;

public class PnlScore extends Panel {

	/**
	 * Create the panel.
	 */
	public PnlScore() {
		setLayout(null);
		setBackground(Color.BLACK);
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(-39, -27, 616, 579);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblDrApocalipsis = new JLabel("");
		lblDrApocalipsis.setBounds(46, 180, 238, 364);
		ImageIcon drApocalipsis = ColeccionDeImagenes.getColeccionDeImagenes().getImagen("fondoPresentacion");
		lblDrApocalipsis.setIcon(drApocalipsis);
		panel.add(lblDrApocalipsis);
		

	}

	@Override
	public void setImagenDeFondo(ImageIcon imagen) {
		// TODO Auto-generated method stub
		
	}
}
