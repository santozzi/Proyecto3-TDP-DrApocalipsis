package GUI;


import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;

import java.util.HashMap;
import java.util.Map;


import javax.swing.JFrame;
import javax.swing.JPanel;



import audio.AudioPlayer;
import entidades.Entidad;
import entidades.personajes.infectados.InfectadoAlpha;
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

public class Mapa  extends JFrame implements IObservador{

	private Container contenedor;
	private JLabel lblNewLabel;
	protected Juego juego;
	protected JLabel jugador;
	protected JPanel pnlAreaDeJuego;
	protected JLabel lblFondo;
	protected Teclado teclado;

	private Thread audio;
	private AudioPlayer ap;
	private Map<Entidad,JLabel> mapeoEntidades;
	private Entidad ent1;
	private Entidad ent2;

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

		mapeoEntidades = new HashMap<Entidad, JLabel>();

		
		

		ap = new AudioPlayer("/audio/Digadig.mp3");
		audio = new Thread(ap);
		//audio.start();
		

		setTitle("Juego");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, Juego.DECORADO_IZQUIERDO+Juego.ANCHO_DE_COMBATE+Juego.DECORADO_DERECHO, 700);
		contenedor = getContentPane();
		
	
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
		
		

		
		JLabel lblMapaDerecha = new JLabel("");
		lblMapaDerecha.setBounds(Juego.ANCHO_DE_COMBATE+Juego.DECORADO_IZQUIERDO, 0, Juego.DECORADO_DERECHO, Juego.ALTO_DE_COMBATE);
		
		Imagen barandaDerecha = new Imagen();
		barandaDerecha.setAlto(Juego.ALTO_DE_COMBATE);
		barandaDerecha.setAncho(Juego.DECORADO_DERECHO);
		

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
		juego.cargarJugador();
		juego.cargarNivel();
	}
	private void pintarEntidades() {
		Entidad entidad;
        JLabel etiquetaDeEntidad;
		
        for(Latencia latencia : juego.getLista()) {
			entidad = latencia.getEntidad();
			//System.out.println("posicion en entidad: ("+entidad.getPosicion().x+";"+entidad.getPosicion().y+")");
			etiquetaDeEntidad = new JLabel();
			etiquetaDeEntidad.setBounds(
					entidad.getPosicion().x, entidad.getPosicion().y,
					entidad.getImagen().getAncho(), entidad.getImagen().getAlto());
			etiquetaDeEntidad.setIcon(entidad.getImagen().getImagen());
			mapeoEntidades.put(entidad,etiquetaDeEntidad);
		    contenedor.add(etiquetaDeEntidad);
		}
		
	}

	
	public void cargarEntidades() {
		// pintarEntidades();
		jugador = mapeoEntidades.get(juego.getJugador());
		
		if(jugador!=null) {
	    
			
		jugador.setIcon(juego.getJugador().getImagen().getImagen());

		jugador.setBounds((int)juego.getJugador().getPosicion().getX(),(int)juego.getJugador().getPosicion().getY(),
				juego.getJugador().getIma().getAncho(),
				juego.getJugador().getIma().getAlto());

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
					entidad.getPosicion().x, entidad.getPosicion().y,
					entidad.getImagen().getAncho(), entidad.getImagen().getAlto());
			etiquetaDeEntidad.setIcon(entidad.getImagen().getImagen());
			mapeoEntidades.put(entidad,etiquetaDeEntidad);
		    contenedor.add(etiquetaDeEntidad);
		    getContentPane().add(lblFondo);
		
	}

	@Override
	public void updateEntidad(Entidad entidad) {
        JLabel lblEntidad = mapeoEntidades.get(entidad);
		
		if(lblEntidad!=null) {
	    
			
			lblEntidad.setIcon(entidad.getImagen().getImagen());

			lblEntidad.setBounds(entidad.getPosicion().x,entidad.getPosicion().y,
					entidad.getImagen().getAncho(),
					entidad.getImagen().getAlto());

			lblEntidad.updateUI();
		}
	}
}
