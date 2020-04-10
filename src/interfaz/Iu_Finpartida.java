package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Iu_Finpartida extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JButton btnNewButton;
	private JTextField txtNickJugador;
	private JTextField txtPuntuacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Iu_Finpartida frame = new Iu_Finpartida();
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
	public Iu_Finpartida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.NORTH);
		contentPane.add(getPanel_1(), BorderLayout.SOUTH);
		contentPane.add(getPanel_2(), BorderLayout.WEST);
		contentPane.add(getPanel_3(), BorderLayout.EAST);
		contentPane.add(getPanel_4(), BorderLayout.CENTER);
		this.setUndecorated(true);
	}
	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("ok");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//Guardar el high score en la base de datos (top 10)
					//Actualizar el high Scores (top 10)
					dispose();
				}
			});
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setBackground(new Color(51, 153, 255));
		}
		return btnNewButton;
	}
	
	public void setJugador(String nombre) {
		txtNickJugador.setText(nombre);
	}
	
	public void setPuntuacion(String puntuacion) {
		txtPuntuacion.setText(puntuacion);
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
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setBackground(Color.DARK_GRAY);
			panel_4.setLayout(new GridLayout(0, 1, 0, 0));
			panel_4.add(getPanel_5());
			panel_4.add(getPanel_6());
			panel_4.add(getPanel_7());
			panel_4.add(getPanel_8());
		}
		return panel_4;
	}
	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.setBackground(Color.DARK_GRAY);
		}
		return panel_5;
	}
	private JPanel getPanel_6() {
		if (panel_6 == null) {
			panel_6 = new JPanel();
			panel_6.setBackground(Color.DARK_GRAY);
			panel_6.add(getTxtNickJugador());
		}
		return panel_6;
	}
	private JPanel getPanel_7() {
		if (panel_7 == null) {
			panel_7 = new JPanel();
			panel_7.setBackground(Color.DARK_GRAY);
			panel_7.add(getTxtPuntuacion());
		}
		return panel_7;
	}
	private JPanel getPanel_8() {
		if (panel_8 == null) {
			panel_8 = new JPanel();
			panel_8.setBackground(Color.DARK_GRAY);
			panel_8.add(getBtnNewButton());
		}
		return panel_8;
	}

	private JTextField getTxtNickJugador() {
		if (txtNickJugador == null) {
			txtNickJugador = new JTextField();
			txtNickJugador.setForeground(Color.WHITE);
			txtNickJugador.setBackground(Color.DARK_GRAY);
			txtNickJugador.setHorizontalAlignment(SwingConstants.CENTER);
			txtNickJugador.setFont(new Font("Tahoma", Font.PLAIN, 29));
			txtNickJugador.setText("Nick Jugador");
			txtNickJugador.setColumns(10);
		}
		return txtNickJugador;
	}
	private JTextField getTxtPuntuacion() {
		if (txtPuntuacion == null) {
			txtPuntuacion = new JTextField();
			txtPuntuacion.setBackground(Color.DARK_GRAY);
			txtPuntuacion.setForeground(Color.WHITE);
			txtPuntuacion.setFont(new Font("Tahoma", Font.PLAIN, 22));
			txtPuntuacion.setHorizontalAlignment(SwingConstants.CENTER);
			txtPuntuacion.setText("Puntuacion");
			txtPuntuacion.setColumns(10);
		}
		return txtPuntuacion;
	}
}
