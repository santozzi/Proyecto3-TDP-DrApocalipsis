package reproductor_de_audio;

public class Sonidos {

	private Thread hilo;
	private AudioPlayer ap;
	private static Sonidos audio;

	private Sonidos(String nombre) {
		ap = new AudioPlayer("/media/sonidos/" + nombre + ".mp3");
		hilo = new Thread(ap);

	}

	public static void reproducir(String nombre) {
		if(!estaReproduciendo()) {
			audio = new Sonidos(nombre);
			audio.hilo.start();
		}
	}

	public static void parar() {
		if(estaReproduciendo()) {
			audio.hilo.interrupt();
			audio.hilo.stop();
			audio = null;
		}
	}
	
	public static boolean estaReproduciendo() {
		return audio!=null && audio.hilo.isAlive();
	}

}
