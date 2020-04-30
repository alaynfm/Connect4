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

public class Iu_gig_ganar extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Iu_gig_ganar frame = new Iu_gig_ganar();
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
	public Iu_gig_ganar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 678);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		setUndecorated(true);//Decoraciones Deshabilitadas
		setBackground(new Color(0,0,0,10));//Transparencia
		
		ImageIcon imageIcon = new ImageIcon("img/ganar2.gif");
		java.awt.Image conversion = imageIcon.getImage();
		java.awt.Image tamano = conversion.getScaledInstance(1000, 800, 0);
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
			lblNewLabel.setBounds(77, 97, 546, 570);
		}
		return lblNewLabel;
	}
}
