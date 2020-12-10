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
		
			InputStream fis = this.getClass().getResourceAsStream(file);
		    Player playMP3 = new Player(fis);
		    playMP3.play();
		    
		    
		}
		catch(JavaLayerException ex) {
			ex.printStackTrace();
		}
	}

}
