package logica;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

public class ColeccionDeImagenes {

	//private Imagen [] imagenes;
	private Map<Integer, ImageIcon> ruta;
	private static ColeccionDeImagenes colDeImg;
	private int contador;// es para probar, despues se borra

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
		agregarRuta("InfectadoBeta","/img/InfectadoBeta.gif",50,50);
		agregarRuta("ParticulaBeta","/img/ParticulaBeta.png",50,50);
		
		agregarRuta("InfectadoAlpha_golpear", "/img/z_ataque_abajo.gif", 40, 60);
		
		agregarRuta("Jugador_dispara", "/img/pistola_idle.png", 70, 50);
		agregarRuta("Jugador_dispara_sa", "/img/superArma.png", 70, 50);
		
		agregarRuta("Jugador_caminarDerecha", "/img/Jugador_caminarDerecha.gif", 70, 60);
		
		agregarRuta("Jugador_caminarIzquierda", "/img/Jugador_caminarIzquierda.gif", 70, 60);
		
		agregarRuta("nivel1", "/img/calle.jpg", Juego.ANCHO_DE_COMBATE+10, Juego.ALTO_DE_COMBATE);
		
		agregarRuta("fondoPresentacion", "/img/drApocalipsis.png", 562, 411);
		
		agregarRuta("ruinas", "/img/ruinas.gif", 785, 700);
		
		agregarRuta("plagueInc", "/img/plagueInc.PNG", 80, 130);
		
		agregarRuta("mapaDerecha", "/img/baranda_der.jpg", Juego.DECORADO_DERECHO, Juego.ALTO_DE_COMBATE);
		
		agregarRuta("mapaIzquierda", "/img/baranda_izq.jpg", Juego.DECORADO_IZQUIERDO, Juego.ALTO_DE_COMBATE);
		
		agregarRuta("fondoIzquierda", "/img/fondo_izq.jpg", Juego.DECORADO_IZQUIERDO, Juego.ALTO_DE_COMBATE);
		
		agregarRuta("fondoDerecha", "/img/fondo_der.jpg", Juego.DECORADO_DERECHO, Juego.ALTO_DE_COMBATE);
		
		agregarRuta("proyectilSanitario", "/img/Jeringa2.png", 20, 50);
		
		agregarRuta("recargar", "/img/recargar.gif", 70, 50);
	
		agregarRuta("particula", "/img/particula.png", 20, 20);
		
		agregarRuta("humano", "/img/Humano.png", 40, 60);
		
		agregarRuta("pocion","/img/pocion.png", 50, 50);
		agregarRuta("superArmaSanitaria","/img/superArmaSanitaria.jpg", 50, 50);
		
		agregarRuta("cuarentena","/img/cuarentena.png", 40, 40);
		
		agregarRuta("dialogo","/img/dialogo.png", 80, 40);


	}
	
	private void agregarRuta(String clave, String ruta, int ancho, int alto) {
		ImageIcon icono = new ImageIcon(this.getClass().getResource(ruta));
		icono.setImage(icono.getImage().getScaledInstance(ancho, alto, 0));
		this.ruta.put(clave.hashCode(), icono);
		
	}

	public ImageIcon getImagen(String ruta) {
		//System.out.println("Buscar imagen " + ruta + " " + this.contador++);
		return this.ruta.get(ruta.hashCode());
	}
	
}
