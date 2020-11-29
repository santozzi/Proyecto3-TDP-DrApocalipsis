

package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
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
import entidades.proyectiles.particulas.ParticulaAlpha;
import logica.ColeccionDeImagenes;
import logica.Juego;
import observador.IObservador;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class Mapa  extends JFrame implements IObservador{

	protected Juego juego;
	protected JLabel jugador;
	protected JLabel lblFondo;
	protected FondoPanel panelFondo;
	protected JPanel panelDeEntidades;
	protected Teclado teclado;
	protected JProgressBar progressBar;
	private Thread audio;
	private AudioPlayer ap;
	private Map<Entidad,JLabel> mapeoEntidades;
	protected JLabel lblMapaDerecha;
	protected JLabel lblMapaIzquierda;
	private JLabel lblSalud;
	private JLabel lblScore;
	public Mapa() {
		juego = new Juego();

		teclado = new Teclado();
		addKeyListener(teclado);

		getContentPane().setLayout(null);
		setResizable(false);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

		//panelDeEntidades = new JPanel();

		mapeoEntidades = new HashMap<Entidad, JLabel>();



		ap = new AudioPlayer("/audio/Digadig.mp3");
		audio = new Thread(ap);
		//audio.start();

		setTitle("Dr. Apocalipsis");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int anchoDelFrame = Juego.DECORADO_IZQUIERDO + Juego.ANCHO_DE_COMBATE + Juego.DECORADO_DERECHO + 20;
		System.out.println(anchoDelFrame);
		setBounds(0, 0, anchoDelFrame, Juego.ALTO_DE_COMBATE + 80);

		//ImageIcon imagendDeFondo = ColeccionDeImagenes.getColeccionDeImagenes().getImagen("nivel1");

		progressBar = new JProgressBar();
		progressBar.setValue(100);
		progressBar.setForeground(new Color(124, 252, 0));
		progressBar.setBackground(Color.RED);
		progressBar.setBounds(598, 11, 110, 22);
		//getContentPane().add(progressBar);

		//lblFondo = new JLabel(imagendDeFondo);
		panelFondo = new FondoPanel();
		panelFondo.setLayout(null);
		//lblFondo.setBounds(Juego.DECORADO_IZQUIERDO, 0, Juego.ANCHO_DE_COMBATE, Juego.ALTO_DE_COMBATE);
		panelFondo.setBounds(Juego.DECORADO_IZQUIERDO, 0, Juego.ANCHO_DE_COMBATE, Juego.ALTO_DE_COMBATE);

		JLabel lblAuto = new JLabel("");
		lblAuto.setBounds(722, 295, 75, 156);
		//getContentPane().add(lblAuto);

		ImageIcon autoEnLlamas = ColeccionDeImagenes.getColeccionDeImagenes().getImagen("autoEnLlamas");
		lblAuto.setIcon(autoEnLlamas);

		//ImageIcon barandaDerecha = ColeccionDeImagenes.getColeccionDeImagenes().getImagen("fondoDerecha");

		lblMapaDerecha = new JLabel("");
		lblMapaDerecha.setBounds(Juego.ANCHO_DE_COMBATE+Juego.DECORADO_IZQUIERDO, 0, Juego.DECORADO_DERECHO, Juego.ALTO_DE_COMBATE);


		getContentPane().add(lblMapaDerecha);

		lblMapaIzquierda = new JLabel("");
		lblMapaIzquierda.setBounds(0, 0, Juego.DECORADO_IZQUIERDO, Juego.ALTO_DE_COMBATE);
		//ImageIcon barandaIzquierda = ColeccionDeImagenes.getColeccionDeImagenes().getImagen("fondoIzquierda");

		//barandaIzquierda.setImagen("mapaIzquierda");


		getContentPane().add(lblMapaIzquierda);

		getContentPane().add(panelFondo);
		
		JPanel panelAbajo = new JPanel();
		panelAbajo.setBackground(Color.BLACK);
		
		panelAbajo.setBounds(0, 620, 826, 50);
		panelAbajo.setLayout(null);
		JLabel lblPanelScore = new JLabel();
		ImageIcon panelDeAbajoIcon = ColeccionDeImagenes.getColeccionDeImagenes().getImagen("panelDeScore");
		lblPanelScore.setBounds(125, 0, 619, 39);
		lblPanelScore.setIcon(panelDeAbajoIcon);
	
		
		
		
		panelAbajo.add(progressBar);
		
		
		
		getContentPane().add(panelAbajo);
		
		lblSalud = new JLabel("Salud");
		lblSalud.setBackground(Color.WHITE);
		lblSalud.setForeground(Color.GREEN);
		lblSalud.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalud.setBounds(487, 11, 110, 22);
		panelAbajo.add(lblSalud);
		
		
		lblScore = new JLabel();
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setText("0");
		lblScore.setForeground(Color.GREEN);
		lblScore.setBounds(309, 11, 133, 21);
		panelAbajo.add(lblScore);
      
        
        JLabel lblPts = new JLabel();
        lblPts.setText("PTS.");
        lblPts.setHorizontalAlignment(SwingConstants.CENTER);
        lblPts.setForeground(Color.GREEN);
        lblPts.setBounds(266, 11, 33, 21);
        panelAbajo.add(lblPts);
          panelAbajo.add(lblPanelScore);
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


	public void update() {

		IComando comando;
		Jugador gamer = juego.getJugador();
		if(!gamer.estaInfectado()) {
			if(teclado.isDerecha()) {
				comando = new CaminarDerecha(gamer);
			}else if(teclado.isIzquierda()) {

				comando = new CaminarIzquierda(gamer);

			}else if(teclado.isDisparar()&&teclado.isLlave()) {
				comando = new Disparar(gamer);
				teclado.setLlave(false);


			}else {
				comando = new Detenerse(gamer);

			}
			comando.ejecutar();
		}

		cargarEntidades();
	}


	public void updateEntidades(Entidad entidad)  {
		// System.out.println(entidad.getImagen());
		JLabel etiquetaDeEntidad;

		//System.out.println("posicion en entidad: ("+entidad.getPosicion().x+";"+entidad.getPosicion().y+")");
		etiquetaDeEntidad = new JLabel();

		//	System.out.println(entidad.toString());
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
	public void updateEntidad(Entidad entidad) {
		JLabel lblEntidad = mapeoEntidades.get(entidad);

		if(lblEntidad!=null) {
			// esto es para que el infectado re aparezca por arriba una vez que salio del mapa
			// hay que tener en cuenta que hacer con los premios
			actualizarLimiteVirtual(entidad);
			lblEntidad.setIcon(entidad.getImagen());

			lblEntidad.setBounds(
					entidad.getVector().getPosicion().x,
					entidad.getVector().getPosicion().y,
					entidad.getImagen().getIconWidth(),
					entidad.getImagen().getIconHeight());

			lblEntidad.updateUI();
		}
	}
	private void actualizarLimiteVirtual(Entidad entidad) {
		if(entidad.getVector().getPosicion().y>Juego.ALTO_DE_COMBATE) {

			if(juego.getLimite().x >= Juego.ANCHO_DE_COMBATE-entidad.getImagen().getIconWidth()) {
				entidad.getVector().getPosicion().y =  juego.getLimite().y-entidad.getImagen().getIconHeight();
				juego.getLimite().x = 0;
			}
			else {
				entidad.getVector().getPosicion().x = juego.getLimite().x;
				entidad.getVector().getPosicion().y = juego.getLimite().y;
				juego.getLimite().x += entidad.getImagen().getIconWidth();
			}
		}
		//entidad.getVector().getPosicion().x = juego.getLimite().x;
		//entidad.getVector().getPosicion().y = juego.getLimite().y;
		//System.out.println("Limite: X=" + juego.getLimite().x + " ; Y=" + juego.getLimite().y + " (Mapa)");
	}

	private class FondoPanel extends JPanel{

		private Image imagen;

		@Override
		public void paint(Graphics grafico) {

			//imagen = ColeccionDeImagenes.getColeccionDeImagenes().getImagen("nivel1").getImage();
			grafico.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
			setOpaque(false);
			super.paint(grafico);
			setVisible(true);

		}
		public void setImagenDeFondo(ImageIcon imagen) {
			this.imagen = imagen.getImage();

		}

	}

	public void quitarEntidad(Entidad entidad) {
		JLabel etiquetaEliminada = mapeoEntidades.remove(entidad);

		if(etiquetaEliminada!=null) {
			panelFondo.remove(etiquetaEliminada);
			panelFondo.repaint();
		}
	} 


	//cambia la barra de energia
	@Override
	public void updateEnergiaJugador() {
		Jugador jugador = juego.getJugador();
		progressBar.setValue(jugador.getCargaViral());

		if(jugador.estaInfectado()) {
			JLabel lblJugador = new JLabel("");
			ImageIcon jugadorMuerto = ColeccionDeImagenes.getColeccionDeImagenes().getImagen("Jugador_muerto");
			lblJugador.setBounds(jugador.getPosicion().x, jugador.getPosicion().y, jugadorMuerto.getIconWidth(), jugadorMuerto.getIconHeight());
			lblJugador.setIcon(jugadorMuerto);
			panelFondo.add(lblJugador);
			panelFondo.repaint();
		}
	}



	@Override
	public void updateNivel(ImageIcon izq, ImageIcon fondo, ImageIcon der) {
		panelFondo.setImagenDeFondo(fondo);
		panelFondo.repaint();
		lblMapaDerecha.setIcon(der);
		lblMapaIzquierda.setIcon(izq);

	}



	@Override
	public void updateScore(int score) {
		lblScore.setText(score+"");
		
	}
}