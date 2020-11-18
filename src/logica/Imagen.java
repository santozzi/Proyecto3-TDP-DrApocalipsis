package logica;

import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;

public class Imagen {
   
    private int ancho;
    private int alto;
    private String nom ;
    private ImageIcon imagen;
    
    private Map<Integer,String> ruta;
    
	
    public Imagen() {
    	/**
    	 * integer es el nombre del infectado.hashCode();
    	 */
		this.ruta = new HashMap<Integer, String>();
		this.ancho = 40;
		this.alto = 60;
	    imagen = new ImageIcon();
		
	
			ruta.put("InfectadoAlpha_golpear".hashCode(),"/img/z_ataque_abajo.gif");
			ruta.put("Jugador_dispara".hashCode(),"/img/pistola_idle.png");
			ruta.put("Jugador_caminarDerecha".hashCode(),"/img/Jugador_caminarDerecha.gif");
			ruta.put("Jugador_caminarIzquierda".hashCode(),"/img/Jugador_caminarIzquierda.gif");
			ruta.put("nivel1".hashCode(),"/img/calle.jpg");
			ruta.put("fondoPresentacion".hashCode(),"/img/drApocalipsis.png");
			ruta.put("plagueInc".hashCode(), "/img/plagueInc.PNG");

			ruta.put("mapaDerecha".hashCode(), "/img/baranda_der.jpg");
			ruta.put("mapaIzquierda".hashCode(), "/img/baranda_izq.jpg");
			ruta.put("fondoIzquierda".hashCode(), "/img/fondo_izq.jpg");
			ruta.put("fondoDerecha".hashCode(), "/img/fondo_der.jpg");

		
		
	}
	public int getAncho() { 
		return ancho;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	public int getAlto() { 
		return alto;
	}
	public void setAlto(int alto) {
		this.alto = alto;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setImagen(String personaje) {
        this.nom = personaje;
        System.out.println(this.ruta.get(personaje.hashCode()));
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource(this.ruta.get(personaje.hashCode())));
	   	this.imagen.setImage(imageIcon.getImage().getScaledInstance(ancho, alto,0));
	   
	}
	public ImageIcon getImagen() {
		   
	return imagen;
	}
	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}
	public void agregarRuta(int num, String ruta) {
		this.ruta.put(num,ruta);
	}
}
