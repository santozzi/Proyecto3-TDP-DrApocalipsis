package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

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

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmScore extends JFrame implements IObservador{
	protected JLabel[][] matriz;
	private JPanel contentPane;
	protected IObservador obs;
	protected Juego  juego;
	protected JLabel lblTotal;


	public FrmScore(IObservador obs,Juego juego) {
		this.juego = juego;
		this.obs = obs;
		
		matriz = new JLabel[4][3];

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int anchoDelFrame = Juego.DECORADO_IZQUIERDO + Juego.ANCHO_DE_COMBATE + Juego.DECORADO_DERECHO + 20;

		setBounds(0, 0, anchoDelFrame, Juego.ALTO_DE_COMBATE + 80);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
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
		lblNewLabel.setBounds(294, 192, 102, 28);
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
		lblPuntos.setBounds(586, 192, 102, 28);
		panel.add(lblPuntos);
		//adentro de la matriz
		JLabel lblTipo00 = new JLabel("");
		lblTipo00.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo00.setForeground(Color.GREEN);
		lblTipo00.setFont(new Font("Tw Cen MT", Font.PLAIN, 21));
		lblTipo00.setBackground(Color.BLACK);
		lblTipo00.setBounds(241, 247, 221, 28);
		panel.add(lblTipo00);

		JLabel lblCant01 = new JLabel("");
		lblCant01.setHorizontalAlignment(SwingConstants.CENTER);
		lblCant01.setForeground(Color.GREEN);
		lblCant01.setFont(new Font("Tw Cen MT", Font.PLAIN, 21));
		lblCant01.setBackground(Color.BLACK);
		lblCant01.setBounds(470, 247, 72, 28);
		panel.add(lblCant01);

		JLabel lblPuntos02 = new JLabel("");
		lblPuntos02.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntos02.setForeground(Color.GREEN);
		lblPuntos02.setFont(new Font("Tw Cen MT", Font.PLAIN, 21));
		lblPuntos02.setBackground(Color.BLACK);
		lblPuntos02.setBounds(586, 247, 102, 28);
		panel.add(lblPuntos02);

		JLabel lblTipo10 = new JLabel("");
		lblTipo10.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo10.setForeground(Color.GREEN);
		lblTipo10.setFont(new Font("Tw Cen MT", Font.PLAIN, 21));
		lblTipo10.setBackground(Color.BLACK);
		lblTipo10.setBounds(241, 286, 221, 28);
		panel.add(lblTipo10);

		JLabel lblCant11 = new JLabel("");
		lblCant11.setHorizontalAlignment(SwingConstants.CENTER);
		lblCant11.setForeground(Color.GREEN);
		lblCant11.setFont(new Font("Tw Cen MT", Font.PLAIN, 21));
		lblCant11.setBackground(Color.BLACK);
		lblCant11.setBounds(470, 286, 72, 28);
		panel.add(lblCant11);

		JLabel lblPuntos12 = new JLabel("");
		lblPuntos12.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntos12.setForeground(Color.GREEN);
		lblPuntos12.setFont(new Font("Tw Cen MT", Font.PLAIN, 21));
		lblPuntos12.setBackground(Color.BLACK);
		lblPuntos12.setBounds(586, 286, 102, 28);
		panel.add(lblPuntos12);

		JLabel lblTipo30 = new JLabel("");
		lblTipo30.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo30.setForeground(Color.GREEN);
		lblTipo30.setFont(new Font("Tw Cen MT", Font.PLAIN, 21));
		lblTipo30.setBackground(Color.BLACK);
		lblTipo30.setBounds(241, 364, 218, 28);
	    panel.add(lblTipo30);
		
	    JLabel lblCant31 = new JLabel("");
		lblCant31.setHorizontalAlignment(SwingConstants.CENTER);
		lblCant31.setForeground(Color.GREEN);
		lblCant31.setFont(new Font("Tw Cen MT", Font.PLAIN, 21));
		lblCant31.setBackground(Color.BLACK);
		lblCant31.setBounds(470, 364, 72, 28);
		panel.add(lblCant31);

		JLabel lblPuntos32 = new JLabel("");
		lblPuntos32.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntos32.setForeground(Color.GREEN);
		lblPuntos32.setFont(new Font("Tw Cen MT", Font.PLAIN, 21));
		lblPuntos32.setBackground(Color.BLACK);
		lblPuntos32.setBounds(586, 364, 102, 28);
		panel.add(lblPuntos32);

		JLabel lblTipo20 = new JLabel("");
		lblTipo20.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo20.setForeground(Color.GREEN);
		lblTipo20.setFont(new Font("Tw Cen MT", Font.PLAIN, 21));
		lblTipo20.setBackground(Color.BLACK);
		lblTipo20.setBounds(241, 325, 221, 28);
		panel.add(lblTipo20);

		JLabel lblCant21 = new JLabel("");
		lblCant21.setHorizontalAlignment(SwingConstants.CENTER);
		lblCant21.setForeground(Color.GREEN);
		lblCant21.setFont(new Font("Tw Cen MT", Font.PLAIN, 21));
		lblCant21.setBackground(Color.BLACK);
		lblCant21.setBounds(470, 325, 72, 28);
		panel.add(lblCant21);

		JLabel lblPuntos22 = new JLabel("");
		lblPuntos22.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntos22.setForeground(Color.GREEN);
		lblPuntos22.setFont(new Font("Tw Cen MT", Font.PLAIN, 21));
		lblPuntos22.setBackground(Color.BLACK);
		lblPuntos22.setBounds(586, 325, 102, 28);
		panel.add(lblPuntos22);
	
		JLabel lblCantidad_1_4_1 = new JLabel("Total");
		lblCantidad_1_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad_1_4_1.setForeground(Color.GREEN);
		lblCantidad_1_4_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 21));
		lblCantidad_1_4_1.setBackground(Color.BLACK);
		lblCantidad_1_4_1.setBounds(421, 463, 159, 28);
		panel.add(lblCantidad_1_4_1);

		lblTotal = new JLabel("0");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setForeground(Color.GREEN);
		lblTotal.setFont(new Font("Tw Cen MT", Font.PLAIN, 21));
		lblTotal.setBackground(Color.BLACK);
		lblTotal.setBounds(586, 463, 102, 28);
		panel.add(lblTotal);

		//Inserto en el arreglo

		matriz[0][0] = lblTipo00;
		matriz[1][0] = lblTipo10;
		matriz[2][0] = lblTipo20;
		matriz[3][0] = lblTipo30;
		
		matriz[0][1] = lblCant01;
		matriz[1][1] = lblCant11;
		matriz[2][1] = lblCant21;
		matriz[3][1] = lblCant31;

		matriz[0][2] = lblPuntos02;
		matriz[1][2] = lblPuntos12;
		matriz[2][2] = lblPuntos22;
		matriz[3][2] = lblPuntos32;
		
		JButton btnReinicio = new JButton("Salir del juego");
		btnReinicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnReinicio.setBounds(639, 588, 128, 23);
		panel.add(btnReinicio);
		
		JButton btnReinicio_1 = new JButton("Volver a jugar");
		btnReinicio_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				obs.cerrar();
				Mapa mapa = new Mapa();
				mapa.setVisible(true);
				dispose();
				
			}
		});
		btnReinicio_1.setBounds(500, 588, 128, 23);
		panel.add(btnReinicio_1);
		
		JLabel lblCantidad_1 = new JLabel("Cantidad");
		lblCantidad_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad_1.setForeground(Color.GREEN);
		lblCantidad_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
		lblCantidad_1.setBackground(Color.BLACK);
		lblCantidad_1.setBounds(458, 192, 102, 28);
		panel.add(lblCantidad_1);


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
		for(Item item : datos) {
			puntosTotal +=item.getScore();
			matriz[cont][0].setText(item.getClave()); 
			matriz[cont][1].setText(item.getCantidad()+"");
			matriz[cont][2].setText(item.getScore()+"");
			
			cont++;
		}
       lblTotal.setText(puntosTotal+"");
	}

	@Override
	public void iniciar() {
		setVisible(true);

	}

	@Override
	public void cerrar() {
           dispose();		
	}
}
