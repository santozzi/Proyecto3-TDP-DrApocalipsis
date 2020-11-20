package logica;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

public class ColeccionDeImagenes {

	//private Imagen [] imagenes;
	private Map<Integer, ImageIcon> ruta;
	private static ColeccionDeImagenes colDeImg;
	private int contador;

	public static ColeccionDeImagenes getColeccionDeImagenes() {
		if(colDeImg == null) {
			colDeImg = new ColeccionDeImagenes();
		}
		return colDeImg;
	}

	private ColeccionDeImagenes() {


		//System.out.println("Ejecuto constructor de ColeccionDeImagenes");
		this.contador = 0;
		this.ruta = new HashMap<Integer, ImageIcon>();
		
		agregarRuta("InfectadoAlpha_golpear", "/img/z_ataque_abajo.gif", 40, 60);
		
		agregarRuta("Jugador_dispara", "/img/pistola_idle.png", 70, 50);
		
		agregarRuta("Jugador_caminarDerecha", "/img/Jugador_caminarDerecha.gif", 70, 60);
		
		agregarRuta("Jugador_caminarIzquierda", "/img/Jugador_caminarIzquierda.gif", 70, 60);
		
		agregarRuta("nivel1", "/img/calle.jpg", Juego.ANCHO_DE_COMBATE+10, Juego.ALTO_DE_COMBATE);
		
		agregarRuta("fondoPresentacion", "/img/drApocalipsis.png", 70, 50);
		
		agregarRuta("plagueInc", "/img/plagueInc.PNG", 50, 63);
		
		agregarRuta("mapaDerecha", "/img/baranda_der.jpg", Juego.DECORADO_DERECHO, Juego.ALTO_DE_COMBATE);
		
		agregarRuta("mapaIzquierda", "/img/baranda_izq.jpg", Juego.DECORADO_IZQUIERDO, Juego.ALTO_DE_COMBATE);
		
		agregarRuta("fondoIzquierda", "/img/fondo_izq.jpg", Juego.DECORADO_IZQUIERDO, Juego.ALTO_DE_COMBATE);
		
		agregarRuta("fondoDerecha", "/img/fondo_der.jpg", Juego.DECORADO_DERECHO, Juego.ALTO_DE_COMBATE);
		
		agregarRuta("proyectilSanitario", "/img/Jeringa2.png", 20, 50);
		
		agregarRuta("recargar", "/img/recargar.gif", 70, 50);

	}
	
	private void agregarRuta(String clave, String ruta, int ancho, int alto) {
		Imagen imagen = new Imagen(new ImageIcon(this.getClass().getResource(ruta)), ancho, alto);
		this.ruta.put(clave.hashCode(), imagen.getImagen());
	}

	public ImageIcon getImagen(String ruta) {
		//System.out.println("Buscar imagen " + ruta + " " + this.contador++);
		return this.ruta.get(ruta.hashCode());
	}
	
	
	
	private class Imagen {

		private int ancho;
		private int alto;
		private ImageIcon imagen;

		public Imagen(ImageIcon icono, int ancho, int alto) {
			//System.out.println("Ejecuto constructor de Imagen");
			this.ancho = ancho;
			this.alto = alto;
			this.imagen = icono;
			this.imagen.setImage(this.imagen.getImage().getScaledInstance(this.ancho, this.alto, 0));
			
		}
		public int getAncho() { 
			return ancho;
		}
		public int getAlto() { 
			return alto;
		}
		public ImageIcon getImagen() {
			return imagen;
		}
		public void setAlto(int alto) {
			this.alto = alto;
			Image newImg = this.imagen.getImage().getScaledInstance(this.ancho, this.alto, Image.SCALE_SMOOTH);
			this.imagen.setImage(newImg);
		}
		public void setAncho(int ancho) {
			this.ancho = ancho;
			Image newImg = this.imagen.getImage().getScaledInstance(this.ancho, this.alto, Image.SCALE_SMOOTH);
			this.imagen.setImage(newImg);
		}
	}
	
}
