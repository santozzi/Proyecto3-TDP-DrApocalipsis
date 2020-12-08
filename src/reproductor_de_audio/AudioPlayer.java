package reproductor_de_audio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;

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
			File f = new File(System.getProperty("user.dir")+this.file);
			System.out.println(f);
			FileInputStream fis = new FileInputStream(f);
		    Player playMP3 = new Player(fis);
		    playMP3.play();
		    
		    
		}
		catch(FileNotFoundException | JavaLayerException ex)	{  
			ex.printStackTrace();
		}
	}

}
