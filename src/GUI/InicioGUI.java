package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Imagen;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 562, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);



		JButton btnNewButton = new JButton("Jugar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mapa mapa = new Mapa();
				mapa.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(Color.LIGHT_GRAY);
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));

		btnNewButton.setBounds(373, 304, 160, 45);
		contentPane.add(btnNewButton);

		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(0, 305, 54, 77);
		Imagen logoInc = new Imagen();
		int x = 50;
		logoInc.setAncho(x);
		logoInc.setAlto((int)(x*1.26));
		logoInc.setImagen("plagueInc");
		lblLogo.setIcon(logoInc.getImagen());

		contentPane.add(lblLogo);
		cargarFondo();
	}

	private void cargarFondo() {
		JLabel lblFondo = new JLabel("");

		Imagen imagenDeFondo = new Imagen();
		imagenDeFondo.setAncho(getWidth());
		imagenDeFondo.setAlto(getHeight());
		imagenDeFondo.setImagen("fondoPresentacion");
		lblFondo.setBounds(0, 0, getWidth(), getHeight());
		lblFondo.setIcon(imagenDeFondo.getImagen());
		contentPane.add(lblFondo);


	}
}