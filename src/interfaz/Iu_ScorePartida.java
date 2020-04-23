package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import gestor.GestorUsuarios;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Iu_ScorePartida extends JFrame {

	private JPanel contentPane;
	private JLabel lblPosicion;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton;
	private int posicion;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Iu_ScorePartida frame = new Iu_ScorePartida("null",0);
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
	public Iu_ScorePartida(String nombre,int posRel) {
		int posicionRelativa=posRel;
		int posicionRanking=GestorUsuarios.getGestorUsuarios().obtenerTuPosicionRelativa(posRel);
		if (posicionRanking<posicionRelativa) { //no ha superado su record
			this.posicion=posicionRelativa;
		}
		else {
			this.posicion=posicionRanking;
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 140);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblPosicion());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getBtnNewButton());
		//this.setUndecorated(true);
		ImageIcon imagen = new ImageIcon("img/logo.jpg");
		this.setIconImage(imagen.getImage());
		this.setVisible(true);
	}
	private JLabel getLblPosicion() {
		if (lblPosicion == null) {
			lblPosicion = new JLabel("Has quedado "+this.posicion+"º!!!");
			lblPosicion.setForeground(Color.WHITE);
			lblPosicion.setBounds(109, 36, 112, 14);
		}
		return lblPosicion;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("DATOS GUARDADOS CORRECTAMENTE....");
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_2.setBounds(20, 11, 303, 14);
		}
		return lblNewLabel_2;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("OK");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					Iu_Inicio.miInicio().setVisible(true);
				}
			});
			btnNewButton.setBounds(102, 62, 89, 23);
		}
		return btnNewButton;
	}
}
