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
		getContentPane().setBackground(Color.DARK_GRAY);
		setBounds(100, 100, 873, 470);

		Container container = getContentPane();
		container.setLayout(null);
		JLabel label = new JLabel("");
	
		getContentPane().add(label);

		progressBar.setBackground(Color.GRAY);
		progressBar.setForeground(new Color(153, 0, 0));
		progressBar.setMaximum(120);
		progressBar.setBounds(52, 350, 743, 14);
		container.add(progressBar);
		getContentPane().add(getLblNewLabel());
		loadProgressBar();
		
		setLocationRelativeTo(null);
		setVisible(true);
		
		txt[0] = "hola me llamo alain";
		txt[1] = "Mi Nombre Es Alvaro";
		txt[2] = "Yo SOY programador Asier";
		txt[3] = "A vER si TE Integras, SOy NICO";
		txt[4] = "XABier, el Mejor PRogramador,A MI YA me CONOCEs";
		
		int c = 0;
		for(int i = 0; i<130; i++) {
		
			if(c == 4) c = 0;
			txt2[i] = txt[c];
			c++;
			
			
		}
		

	}

	private void loadProgressBar() {
		ActionListener al = new ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent evt) {
				
				lblNewLabel.setText(txt2[count]);
				count++;
				
				progressBar.setValue(count);
				System.out.println(count);

				if (count == 130) {
					dispose();
					timer1.stop();
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
			lblNewLabel.setBounds(134, 375, 526, 14);
		}
		return lblNewLabel;
	}
};