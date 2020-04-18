package partida;

import java.io.FileInputStream;
import java.io.IOException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class AudioFilePlayer {


	
	private static AudioFilePlayer audio = new AudioFilePlayer(); 
	private AudioFilePlayer() {
	}

	public static AudioFilePlayer myaudio() {
		return audio;
	}

	public void reproducirAudio(String audio) {

		try (FileInputStream fis = new FileInputStream("music/" + audio + ".mp3")) {
			// Creamos el objeto Player
			Player player = new Player(fis);
			// Reproducimos el fichero, una vez lo haga no podremos hacer nada hasta que
			// termine<br /><br />
			player.play();
		} catch (JavaLayerException e1) {

		} catch (IOException ex) {

		}

	}
}