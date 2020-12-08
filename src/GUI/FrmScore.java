package GUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidades.Entidad;
import logica.ColeccionDeImagenes;
import logica.Juego;
import logica.contabilidad.Item;
import observador.IObservador;
import reproductor_de_audio.Musica;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Collection;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FrmScore extends JFrame implements IObservador{
	protected JLabel[][] matriz;
	private JPanel contentPane;
	protected IObservador obs;
	protected Juego  juego;
	protected JLabel lblTotal;
	protected JPanel panel;


	public FrmScore(IObservador obs,Juego juego) {
		this.juego = juego;
		this.obs = obs;

		matriz = new JLabel[6][3];

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int anchoDelFrame = Juego.DECORADO_IZQUIERDO + Juego.ANCHO_DE_COMBATE + Juego.DECORADO_DERECHO + 20;

		setBounds(0, 0, anchoDelFrame, Juego.ALTO_DE_COMBATE + 80);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 806, 650);


		JLabel lblDrApocalipsis = new JLabel("");
		lblDrApocalipsis.setBounds(22, 179, 238, 364);
		ImageIcon drApocalipsis = ColeccionDeImagenes.getColeccionDeImagenes().getImagen(this.getClass().getSimpleName()+"_FondoPresentacion");
		lblDrApocalipsis.setIcon(drApocalipsis);
		panel.add(lblDrApocalipsis);

		JLabel lblNewLabel = new JLabel("Tipo");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(292, 120, 102, 28);
		panel.add(lblNewLabel);
		contentPane.add(panel);

		JLabel lblCantidad = new JLabel("SCORE");
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad.setForeground(Color.GREEN);
		lblCantidad.setFont(new Font("Tw Cen MT", Font.PLAIN, 63));
		lblCantidad.setBackground(Color.BLACK);
		lblCantidad.setBounds(228, 26, 478, 83);
		panel.add(lblCantidad);

		JLabel lblPuntos = new JLabel("Puntos");
		lblPuntos.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntos.setForeground(Color.GREEN);
		lblPuntos.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
		lblPuntos.setBackground(Color.BLACK);
		lblPuntos.setBounds(586, 120, 102, 28);
		panel.add(lblPuntos);





		JLabel lblCantidad_1_4_1 = new JLabel("Total");
		lblCantidad_1_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad_1_4_1.setForeground(Color.GREEN);
		lblCantidad_1_4_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 21));
		lblCantidad_1_4_1.setBackground(Color.BLACK);
		lblCantidad_1_4_1.setBounds(425, 559, 159, 28);
		panel.add(lblCantidad_1_4_1);

		lblTotal = new JLabel("0");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setForeground(Color.GREEN);
		lblTotal.setFont(new Font("Tw Cen MT", Font.PLAIN, 21));
		lblTotal.setBackground(Color.BLACK);
		lblTotal.setBounds(590, 559, 102, 28);
		panel.add(lblTotal);


		JButton btnReinicio = new JButton("Salir del juego");
		btnReinicio.setFocusable(false);
		btnReinicio.setFocusTraversalKeysEnabled(false);
		btnReinicio.setFocusPainted(false);
		btnReinicio.setRequestFocusEnabled(false);
		btnReinicio.setRolloverEnabled(false);
		btnReinicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				obs.cerrar();

			}
		});

		btnReinicio.setBounds(637, 616, 128, 23);
		panel.add(btnReinicio);

		JButton btnReinicio_1 = new JButton("Volver a jugar");
		btnReinicio_1.setRolloverEnabled(false);
		btnReinicio_1.setRequestFocusEnabled(false);
		btnReinicio_1.setFocusable(false);
		btnReinicio_1.setFocusTraversalKeysEnabled(false);
		btnReinicio_1.setFocusPainted(false);
		btnReinicio_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				obs.cerrar();
				Mapa mapa = new Mapa();
				mapa.setVisible(true);
				dispose();

			}
		});
		btnReinicio_1.setBounds(500, 616, 128, 23);
		panel.add(btnReinicio_1);
		/*
		JLabel lblCantidad_1 = new JLabel("Cantidad");
		lblCantidad_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad_1.setForeground(Color.GREEN);
		lblCantidad_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
		lblCantidad_1.setBackground(Color.BLACK);
		lblCantidad_1.setBounds(456, 120, 102, 28);
		panel.add(lblCantidad_1);
		 */

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateEntidades(Entidad entidad) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateEntidad(Entidad entidad) {
		// TODO Auto-generated method stub

	}

	@Override
	public void quitarEntidad(Entidad entidad) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateEnergiaJugador() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateNivel(ImageIcon izq, ImageIcon fondo, ImageIcon der) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateScore(int score) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateEstedistica(Collection<Item> datos) {
		int cont = 0;
		int puntosTotal = 0;

		JLabel nuevaEtiqueta;
		int separacionX = 280;
		int separacionY = 180;
		int altoDeImagen =  30;
		int anchoDeImagen = 140;



		for(Item item : datos) {
			puntosTotal +=item.getScore();
			nuevaEtiqueta = armarJLabel(separacionX, separacionY, anchoDeImagen, altoDeImagen);
			nuevaEtiqueta.setIcon(ColeccionDeImagenes.getColeccionDeImagenes().getImagen(item.getClave()));
			panel.add(nuevaEtiqueta);

			nuevaEtiqueta = armarJLabel(separacionX+anchoDeImagen, separacionY, anchoDeImagen, altoDeImagen);
			nuevaEtiqueta.setText(item.getCantidad()+"");
			panel.add(nuevaEtiqueta);

			nuevaEtiqueta = armarJLabel(separacionX+(anchoDeImagen*2), separacionY, anchoDeImagen, altoDeImagen);
			nuevaEtiqueta.setText(item.getScore()+"");
			panel.add(nuevaEtiqueta);
			separacionY += altoDeImagen;

			//	matriz[cont][0].setText(item.getClave()); 
			//matriz[cont][1].setText(item.getCantidad()+"");
			//matriz[cont][2].setText(item.getScore()+"");

			cont++;
			separacionY += altoDeImagen;
		}
		lblTotal.setText(puntosTotal+"");
		panel.repaint();
	}
	protected JLabel armarJLabel(int x, int y, int ancho, int alto) {
		JLabel nuevaEtiqueta = new JLabel();
		nuevaEtiqueta.setHorizontalAlignment(SwingConstants.CENTER);
		nuevaEtiqueta.setForeground(Color.GREEN);
		nuevaEtiqueta.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
		nuevaEtiqueta.setBackground(Color.BLACK);
		nuevaEtiqueta.setBounds(x, y, ancho, alto);

		return nuevaEtiqueta;
	}

	@Override
	public void iniciar() {
		setVisible(true);

	}

	@Override
	public void cerrar() {
		Musica.parar();
		dispose();		
	}
}
