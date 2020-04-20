package interfaz;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.*;

import gestor.SGBDLoader;

public class SplashScreen extends JFrame {

	static boolean isRegistered;
	private static JProgressBar progressBar = new JProgressBar();
	private static SplashScreen execute;
	private static int count = 0;
	private static Timer timer1;
	private JLabel lblNewLabel;
	private String[] txt = new String[5];
	private String[] txt2 = new String[50];
	private static int syncronize=0;
	public SplashScreen() {
		setUndecorated(true);
		setBackground(Color.DARK_GRAY);
		getContentPane().setBackground(Color.DARK_GRAY);
		setBounds(100, 100, 873, 470);

		Container container = getContentPane();
		container.setLayout(null);

		progressBar.setBackground(Color.GRAY);
		progressBar.setForeground(new Color(153, 0, 0));
		progressBar.setMaximum(45);
		progressBar.setBounds(52, 350, 743, 14);
		container.add(progressBar);
		getContentPane().add(getLblNewLabel());
		loadProgressBar();

		setLocation(500, 200);
		setVisible(true);
	

		txt[0] = "Programador del juego Alain";
		txt[1] = "Alvaro encargado de pruebas";
		txt[2] = "Programador del juego Asier";
		txt[3] = "Encargado del dise�o Nico";
		txt[4] = "Xabier, jefe de proyecto";

		int c = 0;
		for (int i = 0; i < 50; i++) {

			if (i < 10)
				txt2[i] = "Generando tablero....";

			else if (i >= 10 && i < 20)
				txt2[i] = "Generando fichas...";
			else if (i >= 20 && i < 30)
				txt2[i] = "Preparandp IA Murillo...";

			else if (i >= 30 && i < 40)
				txt2[i] = "Conectando con la base de datos...";
			else {
				if (c == 5)
					c = 0;
				txt2[i] = txt[c];
				c++;
			}
		}
		txt2[47] = "Iniciando Juego";
		SGBDLoader cargaBD= new SGBDLoader();
		new Thread(cargaBD).start();  //cargamos la base de datos
	}

	private void loadProgressBar() {
		ActionListener al = new ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent evt) {

				lblNewLabel.setText(txt2[count]);
				progressBar.setValue(count);
				count++;
				if (count ==41) { //sincronizamos la carga de la base de datos
						int syncronizevalue=getSyncronize();
						while (syncronizevalue==0) {
							try {
								Thread.sleep(ThreadLocalRandom.current().nextInt(1,11));
								syncronizevalue=getSyncronize();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
					}
				if (count == 49) {
					lblNewLabel.setText(txt2[47]);
					try {
						timer1.stop();
						Thread.sleep(500);
						dispose();
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Iu_Inicio.miInicio().setVisible(true);
				}

			}
		};
		timer1 = new Timer(50, al);
		timer1.start();
	}

	public static void main(String[] args) {
		execute = new SplashScreen();
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Texto para poner mientras carga");
			lblNewLabel.setBackground(Color.DARK_GRAY);
			lblNewLabel.setForeground(Color.LIGHT_GRAY);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(153, 327, 526, 14);
		}
		return lblNewLabel;
	}
	public static void setToSyncronized() {
		syncronize=1;
	}
	private int getSyncronize() {
		return syncronize;
	}
};