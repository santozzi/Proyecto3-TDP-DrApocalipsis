package reproductor_de_audio;

public class Musica {

	private Thread hilo;
	private AudioPlayer ap;
	private static Musica audio;

	private Musica(String nombre) {
		ap = new AudioPlayer("/media/musica/"+ nombre + ".mp3");
		hilo = new Thread(ap);
	}

	public static void reproducir(String nombre) {
		if(audio==null || !audio.hilo.isAlive()) {
			audio = new Musica(nombre);
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
