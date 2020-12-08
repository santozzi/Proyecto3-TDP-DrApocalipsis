package reproductor_de_audio;

public class Ambiente {

	private Thread hilo;
	private AudioPlayer ap;
	private static Ambiente audio;

	private Ambiente(String nombre) {
		ap = new AudioPlayer("/media/ambiente/" + nombre + ".mp3");
		hilo = new Thread(ap);
		
		//System.out.println("No se encontro el archivo con el nombre del sonido de ambiente especificado");
	}

	public static void reproducir(String nombre) {
		if(audio==null || !audio.hilo.isAlive()) {
			audio = new Ambiente(nombre);
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
