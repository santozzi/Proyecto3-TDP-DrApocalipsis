package reproductor_de_audio;

import java.io.InputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class AudioPlayer implements Runnable {
	
	protected String file;
	
	public AudioPlayer( String file ) {
		this.file = file;
	}

	@Override
	public void run() {
		try{
			/*
			File f = new File(this.getClass().getResource(this.file).toURI());
			File f = new File(System.getProperty("user.dir")+this.file);
			System.out.println(f);
			InputStream fis = new FileInputStream(f);
			*/
			InputStream fis = this.getClass().getResourceAsStream(file);
		    Player playMP3 = new Player(fis);
		    playMP3.play();
		    
		    
		}
		catch(JavaLayerException ex) {
			ex.printStackTrace();
		}
	}

}
