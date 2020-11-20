

package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;



import audio.AudioPlayer;
import entidades.Entidad;
import entidades.personajes.jugador.Jugador;
import entidades.personajes.jugador.comandos.CaminarDerecha;
import entidades.personajes.jugador.comandos.CaminarIzquierda;
import entidades.personajes.jugador.comandos.Detenerse;
import entidades.personajes.jugador.comandos.Disparar;
import entidades.personajes.jugador.comandos.IComando;
import entidades.personajes.jugador.controles.Teclado;
import logica.ColeccionDeImagenes;
import logica.Juego;
import observador.IObservador;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class Mapa  extends JFrame implements IObservador{

	protected Juego juego;
	protected JLabel jugador;
	protected JLabel lblFondo;
	protected JPanel panelFondo;
	protected JPanel panelDeEntidades;
	protected Teclado teclado;

	private Thread audio;
	private AudioPlayer ap;
	private Map<Entidad,JLabel> mapeoEntidades;

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
	public Mapa() {

		juego = new Juego();

		teclado = new Teclado();
		addKeyListener(teclado);

		getContentPane().setLayout(null);
		
		//panelDeEntidades = new JPanel();

		mapeoEntidades = new HashMap<Entidad, JLabel>();

		/*
		try {
			AudioClip clip = Applet.newAudioClip(new URL("file: C:\\Users\\Lucio\\Desktop\\workspace\\Proyecto-3-TDP\\src\\audio\\Digadig.mp3"));
			clip.play();
			} catch (MalformedURLException murle) {
			System.out.println(murle);
			}
		 */

		ap = new AudioPlayer("/audio/Digadig.mp3");
		audio = new Thread(ap);
		//audio.start();

		setTitle("Dr. Apocalipasis");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, Juego.DECORADO_IZQUIERDO + Juego.ANCHO_DE_COMBATE + Juego.DECORADO_DERECHO + 20, Juego.ALTO_DE_COMBATE + 80);

		//ImageIcon imagendDeFondo = ColeccionDeImagenes.getColeccionDeImagenes().getImagen("nivel1");

		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(new Color(124, 252, 0));
		progressBar.setBackground(Color.RED);
		progressBar.setBounds(289, 620, 155, 33);
		getContentPane().add(progressBar);

		//lblFondo = new JLabel(imagendDeFondo);
		panelFondo = new FondoPanel();
		panelFondo.setLayout(null);
		//lblFondo.setBounds(Juego.DECORADO_IZQUIERDO, 0, Juego.ANCHO_DE_COMBATE, Juego.ALTO_DE_COMBATE);
		panelFondo.setBounds(Juego.DECORADO_IZQUIERDO, 0, Juego.ANCHO_DE_COMBATE, Juego.ALTO_DE_COMBATE);

		JLabel lblMapaDerecha = new JLabel("");
		lblMapaDerecha.setBounds(Juego.ANCHO_DE_COMBATE+Juego.DECORADO_IZQUIERDO, 0, Juego.DECORADO_DERECHO, Juego.ALTO_DE_COMBATE);

		ImageIcon barandaDerecha = ColeccionDeImagenes.getColeccionDeImagenes().getImagen("fondoDerecha");

		lblMapaDerecha.setIcon(barandaDerecha);
		getContentPane().add(lblMapaDerecha);

		JLabel lblMapaIzquierda = new JLabel("");
		lblMapaIzquierda.setBounds(0, 0, Juego.DECORADO_IZQUIERDO, Juego.ALTO_DE_COMBATE);
		ImageIcon barandaIzquierda = ColeccionDeImagenes.getColeccionDeImagenes().getImagen("fondoIzquierda");

		//barandaIzquierda.setImagen("mapaIzquierda");

		lblMapaIzquierda.setIcon(barandaIzquierda);
		getContentPane().add(lblMapaIzquierda);
		
		getContentPane().add(panelFondo);

		juego.agregarObservador(this);
		juego.cargarJugador();
		juego.cargarNivel();
		
	}



	public void cargarEntidades() {
		// pintarEntidades();
		jugador = mapeoEntidades.get(juego.getJugador());

		if(jugador!=null) {


			jugador.setIcon(juego.getJugador().getImagen());

			jugador.setBounds(
					juego.getJugador().getVector().getPosicion().x,
					juego.getJugador().getVector().getPosicion().y,
					juego.getJugador().getImagen().getIconWidth(),
					juego.getJugador().getImagen().getIconHeight());

			jugador.updateUI();
		}

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

		}else if(teclado.disparar&&teclado.llave) {
			comando = new Disparar(gamer);
			teclado.llave=false;


		}else {
			comando = new Detenerse(gamer);

		}
		comando.ejecutar();

		cargarEntidades();
	}

	@Override
	public void updateEntidades(Entidad entidad)  {

		JLabel etiquetaDeEntidad;

		//System.out.println("posicion en entidad: ("+entidad.getPosicion().x+";"+entidad.getPosicion().y+")");
		etiquetaDeEntidad = new JLabel();

		etiquetaDeEntidad.setBounds(


				entidad.getVector().getPosicion().x,
				entidad.getVector().getPosicion().y,
				entidad.getImagen().getIconWidth(),
				entidad.getImagen().getIconHeight());
		etiquetaDeEntidad.setIcon(entidad.getImagen());

		mapeoEntidades.put(entidad,etiquetaDeEntidad);
		panelFondo.add(etiquetaDeEntidad);
		//getContentPane().add(lblFondo);
		//getContentPane().add(panelFondo);
		panelFondo.repaint();

	}

	@Override
	public void updateEntidad(Entidad entidad) {
		JLabel lblEntidad = mapeoEntidades.get(entidad);

		if(lblEntidad!=null) {
			// esto es para que el infectado re aparezca por arriba una vez que salio del mapa
			// hay que tener en cuenta que hacer con los premios
			if(entidad.getVector().getPosicion().y>Juego.ALTO_DE_COMBATE) {
				entidad.getVector().getPosicion().y =  Juego.limite-entidad.getImagen().getIconHeight();
			}


			lblEntidad.setIcon(entidad.getImagen());

			lblEntidad.setBounds(
					entidad.getVector().getPosicion().x,
					entidad.getVector().getPosicion().y,
					entidad.getImagen().getIconWidth(),
					entidad.getImagen().getIconHeight());

			lblEntidad.updateUI();
		}
	}

	private class FondoPanel extends JPanel{

		private Image imagen;

		@Override
		public void paint(Graphics grafico) {
			
			imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen("nivel1").getImage();
			grafico.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
			setOpaque(false);
			super.paint(grafico);
			setVisible(true);

		}

	}
}