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
import javax.swing.SwingConstants;
import java.awt.GridLayout;

public class Iu_ScorePartida extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton;
	private int posicion;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
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
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 140);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		contentPane.add(getPanel_1());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getPanel());
		contentPane.add(getPanel_2());
		//this.setUndecorated(true);
		ImageIcon imagen = new ImageIcon("img/logo.jpg");
		this.setIconImage(imagen.getImage());
		this.setVisible(true);
		setLocationRelativeTo(null);;
		
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("DATOS GUARDADOS CORRECTAMENTE....");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return lblNewLabel_2;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("OK");
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setBackground(Color.GRAY);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					Iu_Inicio.miInicio().setVisible(true);
				}
			});
		}
		return btnNewButton;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.DARK_GRAY);
			panel.add(getBtnNewButton());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(Color.DARK_GRAY);
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBackground(Color.DARK_GRAY);
		}
		return panel_2;
	}
}
