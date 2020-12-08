package reproductor_de_audio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

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
			//File f = new File(this.getClass().getResource(this.file).toURI());
		//	this.getClass().getResource(ruta)
		//	File f = new File();
		//	System.out.println(f);
			//getClass().getResourceAsStream
			System.out.println(this.getClass().getResourceAsStream(file));
			
			InputStream fis = this.getClass().getResourceAsStream(file);
		    Player playMP3 = new Player(fis);
		    playMP3.play();
		    
		    
		}
		catch(JavaLayerException ex)	{  
			ex.printStackTrace();
		}
	}

}
