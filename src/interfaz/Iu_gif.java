package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class Iu_gif extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Iu_gif frame = new Iu_gif("ganar");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Iu_gif(String imagen) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		setUndecorated(true);//Decoraciones Deshabilitadas
		setBackground(new Color(0,0,0,10));//Transparencia
		
		ImageIcon imageIcon = new ImageIcon("img/" + imagen + ".gif");
		java.awt.Image conversion = imageIcon.getImage();
		java.awt.Image tamano = conversion.getScaledInstance(300, 300, 0);
		ImageIcon fin = new ImageIcon(tamano);
		lblNewLabel.setIcon(fin);
		imageIcon.setImageObserver(lblNewLabel);
		setLocationRelativeTo(null);
	}



	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setBounds(5, 5, 440, 290);
		}
		return lblNewLabel;
	}
}
