package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import audio.AudioPlayer;
import entidades.Entidad;
import entidades.personajes.jugador.Jugador;
import entidades.personajes.jugador.comandos.CaminarDerecha;
import entidades.personajes.jugador.comandos.CaminarIzquierda;
import entidades.personajes.jugador.comandos.Detenerse;
import entidades.personajes.jugador.comandos.IComando;
import entidades.personajes.jugador.controles.Teclado;
import logica.Imagen;
import logica.Juego;
import logica.Latencia;
import observador.IObservador;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class Mapa extends JFrame implements IObservador{

	private Container contenedor;
	private JLabel lblNewLabel;
	protected Juego juego;
	protected JLabel jugador;
	protected JPanel pnlAreaDeJuego;
	protected JLabel lblFondo;
	protected Teclado teclado;

	private Thread audio;
	private AudioPlayer ap;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mapa frame = new Mapa();
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
	public Mapa() {

		juego = new Juego();
		teclado = new Teclado();
		addKeyListener(teclado);

		getContentPane().setLayout(null);


		// getContentPane().add(contentPane);
		
		ap = new AudioPlayer("/audio/Digadig.mp3");
		audio = new Thread(ap);
		audio.start();
		

		setTitle("Juego");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 627, 700);
		contenedor = getContentPane();


		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));

		//setContentPane(contentPane);

		//URL url = this.getClass().getResource("/img/z_ataque_abajo.gif");
		//Icon icon = new ImageIcon(url);
		//JLabel label = new JLabel(icon);
		//label.setBounds(100, 500, 50, 40);
		//contentPane.add(label);

		//ImageIcon iconJugador = new ImageIcon(this.getClass().getResource("/img/pistola_idle.png"));



		/*
		ImageIcon iconJeringa = new ImageIcon(this.getClass().getResource("/img/jeringa2.png"));
		JLabel jeringa = new JLabel(iconJeringa);
		contentPane.add(jeringa, BorderLayout.CENTER);
		 */
		jugador = new JLabel();
		cargarEntidades();
		//contentPane.add(pnlAreaDeJuego);
		contenedor.add(jugador);

		//contenedor.add(new FondoPanel());
		Imagen imagendDeFondo = new Imagen();
		imagendDeFondo.setAlto(619);
		imagendDeFondo.setAncho(454);
		imagendDeFondo.setImagen("nivel1");

		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(new Color(124, 252, 0));
		progressBar.setBackground(Color.RED);
		progressBar.setBounds(289, 620, 155, 33);
		getContentPane().add(progressBar);

		lblFondo = new JLabel(imagendDeFondo.getImagen());
		lblFondo.setBounds(Juego.DECORADO_IZQUIERDO, 0, Juego.ANCHO_DE_COMBATE, Juego.ALTO_DE_COMBATE);
		getContentPane().add(lblFondo);
		

		
		JLabel lblMapaDerecha = new JLabel("");
		lblMapaDerecha.setBounds(Juego.ANCHO_DE_COMBATE+Juego.DECORADO_IZQUIERDO, 0, Juego.DECORADO_DERECHO, Juego.ALTO_DE_COMBATE);
		
		Imagen barandaDerecha = new Imagen();
		barandaDerecha.setAlto(Juego.ALTO_DE_COMBATE);
		barandaDerecha.setAncho(Juego.DECORADO_DERECHO);
		//barandaDerecha.setImagen("mapaDerecha");
		barandaDerecha.setImagen("fondoDerecha");
		lblMapaDerecha.setIcon(barandaDerecha.getImagen());
		getContentPane().add(lblMapaDerecha);
		
		JLabel lblMapaIzquierda = new JLabel("");
		lblMapaIzquierda.setBounds(0, 0, Juego.DECORADO_IZQUIERDO, Juego.ALTO_DE_COMBATE);
		Imagen barandaIzquierda = new Imagen();
		barandaIzquierda.setAlto(Juego.ALTO_DE_COMBATE);
		barandaIzquierda.setAncho(Juego.DECORADO_IZQUIERDO);
		//barandaIzquierda.setImagen("mapaIzquierda");
		barandaIzquierda.setImagen("fondoIzquierda");
		
		lblMapaIzquierda.setIcon(barandaIzquierda.getImagen());
		getContentPane().add(lblMapaIzquierda);
		
		juego.agregarObservador(this);
	}
	/*
	private class FondoPanel extends JPanel{

		private Image imagen;

		@Override
		public void paint(Graphics grafico) {

			imagen = new ImageIcon(this.getClass().getResource("/img/street.png")).getImage();
			grafico.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
			setOpaque(false);
			super.paint(grafico);
			setVisible(true);			//super.setLayout(null);

		}
	}
	 */	
	/*
	@Override
	public void keyTyped(KeyEvent e) {


	}

	@Override
	public void keyPressed(KeyEvent e) {
		Jugador enJugador = juego.getJugador();
		enJugador.desplazarse(e.getKeyChar());

		jugador.setBounds(enJugador.getVector().getX(), enJugador.getVector().getY(), enJugador.getIma().getAncho(), enJugador.getIma().getAlto());

		System.out.println(e.getKeyChar());

	}

	@Override
	public void keyReleased(KeyEvent e) {

		if(e.getKeyChar()=='a'||e.getKeyChar()=='d') {
			System.out.println("suelto letra "+e.getKeyChar());
			juego.getJugador().desplazarse(' ');
		jugador.setIcon(juego.getJugador().getImagen());
		jugador.updateUI();
		}

	}
	 */
	public void cargarEntidades() {
		Entidad entidad;
		JLabel lblEntidad;
		
        for(Latencia latencia: juego.getLista()) {
        	entidad = latencia.getEntidad();
        	 lblEntidad = new JLabel();
        	 
        }

		jugador.setIcon(juego.getJugador().getImagen().getImagen());

		jugador.setBounds((int)juego.getJugador().getPosicion().getX(), (int)juego.getJugador().getPosicion().getY(),
				juego.getJugador().getIma().getAncho(), juego.getJugador().getIma().getAlto());

		jugador.updateUI();

		//pnlAreaDeJuego.updateUI();
	}

	@Override
	public void update() {

		IComando comando;
		Jugador gamer = juego.getJugador();
		if(teclado.derecha) {
			comando = new CaminarDerecha(gamer);
		}else if(teclado.izquierda) {
			comando = new CaminarIzquierda(gamer);
		}else {
			comando = new Detenerse(gamer);

		}
		comando.ejecutar();

		cargarEntidades();
	}
}
