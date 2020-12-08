package reproductor_de_audio;

public class Musica {

	private Thread hilo;
	private AudioPlayer ap;
	private static Musica audio;

	private Musica(String nombre) {
		ap = new AudioPlayer("/src/media/musica/" + nombre + ".mp3");
		hilo = new Thread(ap);
		
		//System.out.println("No se encontro el archivo con el nombre de la musica especificada");
	}

	public static void reproducir(String nombre) {
		if(!estaReproduciendo()) {
			audio = new Musica(nombre);
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
