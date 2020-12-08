package reproductor_de_audio;

public class Ambiente {

	private Thread hilo;
	private AudioPlayer ap;
	private static Ambiente audio;

	private Ambiente(String nombre) {
		//ap = new AudioPlayer("/src/media/ambiente/" + nombre + ".mp3");
		ap = new AudioPlayer("/media/ambiente/" + nombre + ".mp3");
		hilo = new Thread(ap);
		
		//System.out.println("No se encontro el archivo con el nombre del sonido de ambiente especificado");
	}

	public static void reproducir(String nombre) {
		if(!estaReproduciendo()) {
			audio = new Ambiente(nombre);
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
