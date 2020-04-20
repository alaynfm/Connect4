package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;

public class Iu_Inicio extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel center;
	private JPanel panel_4;
	private JLabel lblConecta;
	private JButton btnUnJugador;
	private JButton btnTop;
	private JLabel lblXabico;
	private JButton btnRegistrarse;
	
	private static Iu_Inicio miinicio = new Iu_Inicio();
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Iu_Inicio frame = new Iu_Inicio();
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
	private Iu_Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 470);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.NORTH);
		contentPane.add(getPanel_1(), BorderLayout.SOUTH);
		contentPane.add(getPanel_2(), BorderLayout.WEST);
		contentPane.add(getPanel_3(), BorderLayout.EAST);
		contentPane.add(getCenter(), BorderLayout.CENTER);
		setLocationRelativeTo(null);
		setUndecorated(true);

	}

	public static Iu_Inicio miInicio() {
		return miinicio;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.DARK_GRAY);
			panel.setLayout(new GridLayout(0, 2, 0, 0));
			panel.add(getPanel_5());
			panel.add(getPanel_6());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(Color.DARK_GRAY);
			panel_1.add(getLblXabico());
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
			GridBagLayout gbl_panel_4 = new GridBagLayout();
			gbl_panel_4.columnWidths = new int[] {280, 0};
			gbl_panel_4.rowHeights = new int[]{57, 37, 37, 10, 0};
			gbl_panel_4.columnWeights = new double[]{0.0};
			gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
			panel_4.setLayout(gbl_panel_4);
			GridBagConstraints gbc_lblConecta = new GridBagConstraints();
			gbc_lblConecta.fill = GridBagConstraints.BOTH;
			gbc_lblConecta.insets = new Insets(0, 0, 5, 5);
			gbc_lblConecta.gridx = 0;
			gbc_lblConecta.gridy = 0;
			panel_4.add(getLblConecta(), gbc_lblConecta);
			GridBagConstraints gbc_btnUnJugador = new GridBagConstraints();
			gbc_btnUnJugador.fill = GridBagConstraints.BOTH;
			gbc_btnUnJugador.insets = new Insets(0, 0, 5, 5);
			gbc_btnUnJugador.gridx = 0;
			gbc_btnUnJugador.gridy = 2;
			panel_4.add(getBtnUnJugador(), gbc_btnUnJugador);
			GridBagConstraints gbc_btnTop = new GridBagConstraints();
			gbc_btnTop.insets = new Insets(0, 0, 5, 5);
			gbc_btnTop.fill = GridBagConstraints.BOTH;
			gbc_btnTop.gridx = 0;
			gbc_btnTop.gridy = 3;
			panel_4.add(getBtnTop(), gbc_btnTop);
			GridBagConstraints gbc_btnRegistrarse = new GridBagConstraints();
			gbc_btnRegistrarse.insets = new Insets(0, 0, 0, 5);
			gbc_btnRegistrarse.gridx = 0;
			gbc_btnRegistrarse.gridy = 4;
			panel_4.add(getBtnRegistrarse(), gbc_btnRegistrarse);
			
		}
		return panel_4;
	}
	private JLabel getLblConecta() {
		if (lblConecta == null) {
			lblConecta = new JLabel("Conecta4");
			lblConecta.setFont(new Font("Georgia", Font.BOLD, 64));
			lblConecta.setForeground(Color.WHITE);
			lblConecta.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblConecta;
	}
	private JButton getBtnUnJugador() {
		if (btnUnJugador == null) {
			btnUnJugador = new JButton("Jugar Partida");
			btnUnJugador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					Iu_Menu1J.miPartida().setVisible(true);
				}
			});
			btnUnJugador.setFont(new Font("Tahoma", Font.PLAIN, 19));
			btnUnJugador.setBackground(new Color(0, 153, 255));
		}
		return btnUnJugador;
	}
	private JButton getBtnTop() {
		if (btnTop == null) {
			btnTop = new JButton("Mejores Puntuaciones");
			btnTop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new Iu_highScores();
					setVisible(false);
				}
			});
			btnTop.setBackground(new Color(255, 255, 255));
			btnTop.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return btnTop;
	}
	private JLabel getLblXabico() {
		if (lblXabico == null) {
			lblXabico = new JLabel("Xabi&Co");
			lblXabico.setForeground(new Color(204, 204, 204));
		}
		return lblXabico;
	}
	private JButton getBtnRegistrarse() {
		if (btnRegistrarse == null) {
			btnRegistrarse = new JButton("Normas");
			btnRegistrarse.setForeground(Color.WHITE);
			btnRegistrarse.setBackground(Color.DARK_GRAY);
		}
		return btnRegistrarse;
	}
	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.setBackground(Color.DARK_GRAY);
			panel_5.setLayout(null);
		}
		return panel_5;
	}
	private JPanel getPanel_6() {
		if (panel_6 == null) {
			panel_6 = new JPanel();
			panel_6.setBackground(Color.DARK_GRAY);
			panel_6.setLayout(new GridLayout(1, 1, 0, 0));
			panel_6.add(getPanel_7());
			panel_6.add(getPanel_8());
		}
		return panel_6;
	}
	private JPanel getPanel_7() {
		if (panel_7 == null) {
			panel_7 = new JPanel();
			panel_7.setBackground(Color.DARK_GRAY);
		}
		return panel_7;
	}
	private JPanel getPanel_8() {
		if (panel_8 == null) {
			panel_8 = new JPanel();
			panel_8.setBackground(Color.DARK_GRAY);
			panel_8.setLayout(new GridLayout(1, 0, 0, 0));
			panel_8.add(getPanel_9());
			panel_8.add(getPanel_10());
		}
		return panel_8;
	}
	private JPanel getPanel_9() {
		if (panel_9 == null) {
			panel_9 = new JPanel();
			panel_9.setBackground(Color.DARK_GRAY);
		}
		return panel_9;
	}
	private JPanel getPanel_10() {
		if (panel_10 == null) {
			panel_10 = new JPanel();
			panel_10.setBackground(Color.DARK_GRAY);
			panel_10.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
			panel_10.add(getBtnNewButton());
		}
		return panel_10;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			ImageIcon img = new ImageIcon("img/x.png");;
			java.awt.Image conversion = img.getImage();
			java.awt.Image tamano = conversion.getScaledInstance(20,20,0);
			ImageIcon fin = new ImageIcon(tamano);
			btnNewButton.setIcon(fin);
			btnNewButton.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					dispose();
					System.exit(0);	//Para cerrar toda ejecucion que pueda existir
				}
			});
			btnNewButton.setBackground(Color.DARK_GRAY);
		}
		return btnNewButton;
	}
}
