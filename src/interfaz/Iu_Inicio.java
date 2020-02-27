package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Inicio extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel center;
	private JPanel panel_4;
	private JLabel lblConecta;
	private JButton btnUnJugador;
	private JButton btnMultijugador;
	private JButton btnTop;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.NORTH);
		contentPane.add(getPanel_1(), BorderLayout.SOUTH);
		contentPane.add(getPanel_2(), BorderLayout.WEST);
		contentPane.add(getPanel_3(), BorderLayout.EAST);
		contentPane.add(getCenter(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.DARK_GRAY);
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
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setBackground(Color.DARK_GRAY);
		}
		return panel_3;
	}
	private JPanel getCenter() {
		if (center == null) {
			center = new JPanel();
			center.setBackground(Color.DARK_GRAY);
			center.setLayout(new BorderLayout(0, 0));
			center.add(getPanel_4(), BorderLayout.CENTER);
		}
		return center;
	}
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setBackground(Color.DARK_GRAY);
			panel_4.setLayout(new GridLayout(0, 1, 0, 0));
			panel_4.add(getLblConecta());
			panel_4.add(getBtnUnJugador());
			panel_4.add(getBtnMultijugador());
			panel_4.add(getBtnTop());
			
		}
		return panel_4;
	}
	private JLabel getLblConecta() {
		if (lblConecta == null) {
			lblConecta = new JLabel("Conecta4");
			lblConecta.setForeground(Color.WHITE);
			lblConecta.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblConecta;
	}
	private JButton getBtnUnJugador() {
		if (btnUnJugador == null) {
			btnUnJugador = new JButton("Un Jugador");
		}
		return btnUnJugador;
	}
	private JButton getBtnMultijugador() {
		if (btnMultijugador == null) {
			btnMultijugador = new JButton("Multijugador");
		}
		return btnMultijugador;
	}
	private JButton getBtnTop() {
		if (btnTop == null) {
			btnTop = new JButton("Top 10");
		}
		return btnTop;
	}
}
