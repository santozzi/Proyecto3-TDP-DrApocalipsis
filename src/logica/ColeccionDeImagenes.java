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


		System.out.println("Ejecuto constructor de ColeccionDeImagenes");
		this.contador = 0;
		this.ruta = new HashMap<Integer, ImageIcon>();
		Imagen imagen;
		
		imagen = new Imagen(new ImageIcon(this.getClass().getResource("/img/z_ataque_abajo.gif")), 40, 60);
		ruta.put("InfectadoAlpha_golpear".hashCode(), imagen.getImagen());
		
		imagen = new Imagen(new ImageIcon(this.getClass().getResource("/img/pistola_idle.png")), 70, 50);
		ruta.put("Jugador_dispara".hashCode(), imagen.getImagen());
		
		imagen = new Imagen(new ImageIcon(this.getClass().getResource("/img/Jugador_caminarDerecha.gif")), 70, 60);
		ruta.put("Jugador_caminarDerecha".hashCode(), imagen.getImagen());
		
		imagen = new Imagen(new ImageIcon(this.getClass().getResource("/img/Jugador_caminarIzquierda.gif")), 70, 60);
		ruta.put("Jugador_caminarIzquierda".hashCode(), imagen.getImagen());
		
		imagen = new Imagen(new ImageIcon(this.getClass().getResource("/img/calle.jpg")), Juego.ANCHO_DE_COMBATE+10, Juego.ALTO_DE_COMBATE);
		ruta.put("nivel1".hashCode(), imagen.getImagen());
		
		imagen = new Imagen(new ImageIcon(this.getClass().getResource("/img/drApocalipsis.png")), 70, 50);
		ruta.put("fondoPresentacion".hashCode(), imagen.getImagen());
		
		imagen = new Imagen(new ImageIcon(this.getClass().getResource("/img/plagueInc.PNG")), 50, 63);
		ruta.put("plagueInc".hashCode(), imagen.getImagen());
		
		imagen = new Imagen(new ImageIcon(this.getClass().getResource("/img/baranda_der.jpg")), Juego.DECORADO_DERECHO, Juego.ALTO_DE_COMBATE);
		ruta.put("mapaDerecha".hashCode(), imagen.getImagen());
		
		imagen = new Imagen(new ImageIcon(this.getClass().getResource("/img/baranda_izq.jpg")), Juego.DECORADO_IZQUIERDO, Juego.ALTO_DE_COMBATE);
		ruta.put("mapaIzquierda".hashCode(), imagen.getImagen());
		
		imagen = new Imagen(new ImageIcon(this.getClass().getResource("/img/fondo_izq.jpg")), Juego.DECORADO_IZQUIERDO, Juego.ALTO_DE_COMBATE);
		ruta.put("fondoIzquierda".hashCode(), imagen.getImagen());
		
		imagen = new Imagen(new ImageIcon(this.getClass().getResource("/img/fondo_der.jpg")), Juego.DECORADO_DERECHO, Juego.ALTO_DE_COMBATE);
		ruta.put("fondoDerecha".hashCode(), imagen.getImagen());
		
		imagen = new Imagen(new ImageIcon(this.getClass().getResource("/img/Jeringa2.png")), 20, 50);
		ruta.put("proyectilSanitario".hashCode(), imagen.getImagen());
		
		imagen = new Imagen(new ImageIcon(this.getClass().getResource("/img/recargar.gif")), 70, 50);
		ruta.put("recargar".hashCode(), imagen.getImagen());

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
			System.out.println("Ejecuto constructor de Imagen");
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
