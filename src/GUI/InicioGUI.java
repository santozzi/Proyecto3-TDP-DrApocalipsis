package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.ColeccionDeImagenes;
import reproductor_de_audio.Musica;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class InicioGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioGUI frame = new InicioGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InicioGUI() {


		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 700);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Musica.reproducir("fnv");

		JButton btnNewButton = new JButton("Jugar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Musica.parar();
				Mapa mapa = new Mapa();
				mapa.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(Color.LIGHT_GRAY);
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));

		btnNewButton.setBounds(587, 574, 160, 45);
		contentPane.add(btnNewButton);

		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(0, 541, 80, 130);
		ImageIcon logoInc = ColeccionDeImagenes.getColeccionDeImagenes().getImagen("InicioGUI_PlagueInc");
		lblLogo.setIcon(logoInc);

		contentPane.add(lblLogo);
		cargarFondo();
	}

	private void cargarFondo() {
		JLabel lblFondo = new JLabel("");

		ImageIcon imagenDeFondo = ColeccionDeImagenes.getColeccionDeImagenes().getImagen("InicioGUI_Ruinas");
		lblFondo.setIcon(imagenDeFondo);
		lblFondo.setBounds(0, 0, getWidth(), getHeight());
		contentPane.add(lblFondo);


	}
}
