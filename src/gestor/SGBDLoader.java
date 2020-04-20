package gestor;

import interfaz.Iu_highScores;
import interfaz.SplashScreen;

public class SGBDLoader extends Thread {
	public void run() {
		Iu_highScores.miPanel().actualizarPanel();
		SplashScreen.setToSyncronized(); // marcado como sincronizado
	}
}
