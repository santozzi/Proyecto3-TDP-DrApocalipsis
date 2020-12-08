package reproductor_de_audio;

public class Sonidos {

	private Thread hilo;
	private AudioPlayer ap;
	private static Sonidos audio;

	private Sonidos(String nombre) {
		ap = new AudioPlayer("/src/media/sonidos/" + nombre + ".mp3");
		hilo = new Thread(ap);

		//System.out.println("No se encontro el archivo con el nombre del efecto de sonido especificado");
	}

	public static void reproducir(String nombre) {
		if(audio==null || !audio.hilo.isAlive()) {
			audio = new Sonidos(nombre);
			audio.hilo.start();
		}
	}

	public static void parar() {
		if(audio!=null && audio.hilo.isAlive()) {
			audio.hilo.interrupt();
			audio.hilo.stop();
			audio = null;
		}
	}

}
