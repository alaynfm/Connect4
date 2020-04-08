package interfaz;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.*;

public class SplashScreen extends JFrame {

	static boolean isRegistered;
	private static JProgressBar progressBar = new JProgressBar();
	private static SplashScreen execute;
	private static int count = 0;
	private static Timer timer1;
	private JLabel lblNewLabel;
	private String[] txt = new String[5];
	private String[] txt2 = new String[130];

	public SplashScreen() {
		setBackground(Color.DARK_GRAY);
		getContentPane().setBackground(Color.DARK_GRAY);
		setBounds(100, 100, 873, 470);

		Container container = getContentPane();
		container.setLayout(null);

		progressBar.setBackground(Color.GRAY);
		progressBar.setForeground(new Color(153, 0, 0));
		progressBar.setMaximum(120);
		progressBar.setBounds(52, 350, 743, 14);
		container.add(progressBar);
		getContentPane().add(getLblNewLabel());
		loadProgressBar();

		setLocation(500, 200);
		setVisible(true);

		txt[0] = "Programador del juego Alain";
		txt[1] = "Alvaro encargado de pruebas";
		txt[2] = "Programador del juego Asier";
		txt[3] = "Encargado del diseño Nico";
		txt[4] = "Xabier, jefe de proyecto";

		int c = 0;
		int a = 0;
		for (int i = 0; i < 130; i++) {

			if (i < 20)
				txt2[i] = "Generando tablero....";

			else if (i >= 20 && i < 50)
				txt2[i] = "Generando fichas...";
			else if (i >= 50 && i < 80)
				txt2[i] = "Preparandp IA Murillo...";

			else if (i >= 80 && i < 105)
				txt2[i] = "Conectando con la base de datos...";
			else {
				if (c == 5)
					c = 0;
				txt2[i] = txt[c];
				c++;
			}
		}
		txt2[txt2.length-2] = "Iniciando Juego";

	}

	private void loadProgressBar() {
		ActionListener al = new ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent evt) {

				lblNewLabel.setText(txt2[count]);
				count++;

				progressBar.setValue(count);

				if (count == 130) {
					try {
						timer1.stop();
						Thread.sleep(1000);
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
};