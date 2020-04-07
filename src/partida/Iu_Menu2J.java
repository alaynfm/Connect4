package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Font;
import java.awt.Graphics;

public class Iu_Menu2J extends JFrame {

	private JPanel contentPane;

	private static Iu_Menu2J miPartida = new Iu_Menu2J();
	private JPanel norte1;
	private JPanel sur1;
	private JPanel oeste1;
	private JPanel este1;
	private JPanel centro1;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_6;
	private JPanel panel_7;
	private JButton btnEmpezar;
	private JButton btnNormas;
	private JButton btnAtras;
	private JLabel lblVs;
	private JPanel panel_5;
	private JLabel lblFilas;
	private JLabel lblColumnas;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblX;
	private ButtonGroup group = new ButtonGroup();
	private JTextField txtNick;
	private JLabel lblXabico;
	private JTextField txtNickname;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Iu_Menu2J frame = new Iu_Menu2J();
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
	private Iu_Menu2J() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 470);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel_9(), BorderLayout.NORTH);
		contentPane.add(getPanel_10(), BorderLayout.SOUTH);
		contentPane.add(getPanel_11(), BorderLayout.WEST);
		contentPane.add(getPanel_12(), BorderLayout.EAST);
		contentPane.add(getPanel_13(), BorderLayout.CENTER);
		setResizable(false);

	}

	public static Iu_Menu2J miPartida() {
		return miPartida;
	}

	private JPanel getPanel_9() {
		if (norte1 == null) {
			norte1 = new JPanel();
			norte1.setBackground(Color.DARK_GRAY);
		}
		return norte1;
	}

	private JPanel getPanel_10() {
		if (sur1 == null) {
			sur1 = new JPanel();
			sur1.setBackground(Color.DARK_GRAY);
			sur1.add(getLblXabico());
		}
		return sur1;
	}

	private JPanel getPanel_11() {
		if (oeste1 == null) {
			oeste1 = new JPanel();
			oeste1.setBackground(Color.DARK_GRAY);
		}
		return oeste1;
	}

	private JPanel getPanel_12() {
		if (este1 == null) {
			este1 = new JPanel();
			este1.setBackground(Color.DARK_GRAY);
		}
		return este1;
	}

	private JPanel getPanel_13() {
		if (centro1 == null) {
			centro1 = new JPanel();
			centro1.setBackground(Color.DARK_GRAY);
			centro1.setLayout(new GridLayout(0, 1, 0, 0));
			centro1.add(getPanel_14());
			centro1.add(getPanel_1_1());
			centro1.add(getPanel_3_1());
			centro1.add(getPanel_2_1());
			centro1.add(getPanel_5());
			centro1.add(getPanel_4_1());
			centro1.add(getPanel_6_1());
			centro1.add(getPanel_7());
		}
		return centro1;
	}

	private JPanel getPanel_14() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.DARK_GRAY);
			panel.setLayout(null);
			panel.add(getBtnNormas());
			panel.add(getBtnAtras());
		}
		return panel;
	}

	private JPanel getPanel_1_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(Color.DARK_GRAY);
		}
		return panel_1;
	}

	private JPanel getPanel_2_1() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBackground(Color.DARK_GRAY);
			panel_2.setLayout(null);
			panel_2.add(getLblVs());
			panel_2.add(getTxtNick());
			panel_2.add(getTxtNickname());
		}
		return panel_2;
	}

	private JPanel getPanel_3_1() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setBackground(Color.DARK_GRAY);
			panel_3.setLayout(null);
		}
		return panel_3;
	}

	private JPanel getPanel_4_1() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setBackground(Color.DARK_GRAY);
			panel_4.setLayout(null);
		}
		return panel_4;
	}

	private JPanel getPanel_6_1() {
		if (panel_6 == null) {
			panel_6 = new JPanel();
			panel_6.setBackground(Color.DARK_GRAY);
			panel_6.setLayout(null);
			panel_6.add(getBtnEmpezar());
		}
		return panel_6;
	}

	private JPanel getPanel_7() {
		if (panel_7 == null) {
			panel_7 = new JPanel();
			panel_7.setBackground(Color.DARK_GRAY);
			panel_7.setLayout(null);
		}
		return panel_7;
	}

	private JButton getBtnEmpezar() {
		if (btnEmpezar == null) {
			btnEmpezar = new JButton("Empezar");
			btnEmpezar.setFont(new Font("Tahoma", Font.PLAIN, 33));
			btnEmpezar.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
			btnEmpezar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if (txtNick.getText().length() > 8 || txtNickname.getText().length() > 8 || txtNickname.getText().length() == 0 || txtNick.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "Los nicknames con menos de 8 caracteres", "Warming",
								JOptionPane.WARNING_MESSAGE);

					} else {
						// El normbre nos da igual, aceptamos cuqlquiera
						Iu_Partida.miPartida().setNombreJugador1(txtNick.getText());
						Iu_Partida.miPartida().setNombreJugador2(txtNickname.getText());
						
						try {

							int f = Integer.parseInt(textField_1.getText());
							int c = Integer.parseInt(textField_2.getText());

							if (f >= 6 && c >= 7 && f<=18 && c<=38) {

								Iu_Partida.miPartida().crearTablero(f, c);
								setVisible(false);
								Iu_Partida.miPartida().setVisible(true);

							} else {
								JOptionPane.showMessageDialog(null,
										"Valores erroneos, por favor comprueba que las filas son al menos 6 y las columnas 7", "Error",
										JOptionPane.ERROR_MESSAGE);

							}

						} catch (NumberFormatException excepcion) {
							// System.out.println("Por favor introduce numeros");
							JOptionPane.showMessageDialog(null, "Por favor introduce n�meros", "Error",
									JOptionPane.ERROR_MESSAGE);
						}

					}

					
					// Hay que mirar que las filas y las columnas son numeros

					// hay que difinir el tipo de Ia que se va a jugar
				}
			});
			btnEmpezar.setForeground(Color.GRAY);
			btnEmpezar.setBackground(Color.DARK_GRAY);
			btnEmpezar.setBounds(331, 0, 144, 49);
		}
		return btnEmpezar;
	}

	private JButton getBtnNormas() {
		if (btnNormas == null) {
			btnNormas = new JButton("Normas");
			btnNormas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// hacer que se habra las normas
				}
			});
			btnNormas.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnNormas.setForeground(Color.GRAY);
			btnNormas.setBackground(Color.DARK_GRAY);

			btnNormas.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
			btnNormas.setBounds(660, 11, 89, 23);
		}
		return btnNormas;
	}

	private JButton getBtnAtras() {
		if (btnAtras == null) {
			btnAtras = new JButton("Atras");
			btnAtras.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnAtras.setBackground(Color.DARK_GRAY);
			btnAtras.setForeground(Color.GRAY);
			btnAtras.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
			btnAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					Iu_Inicio.miInicio().setVisible(true);
				}
			});
			btnAtras.setBounds(47, 11, 89, 23);
		}
		return btnAtras;
	}

	private JLabel getLblVs() {
		if (lblVs == null) {
			lblVs = new JLabel("Vs");
			lblVs.setForeground(Color.WHITE);
			lblVs.setFont(new Font("Tahoma", Font.PLAIN, 36));
			lblVs.setBounds(388, -9, 46, 57);
		}
		return lblVs;
	}

	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.setBackground(Color.DARK_GRAY);
			panel_5.setLayout(null);
			panel_5.add(getLblFilas());
			panel_5.add(getLblColumnas());
			panel_5.add(getTextField_2_1());
			panel_5.add(getLblX());
			panel_5.add(getTextField_1());
		}
		return panel_5;
	}

	private JLabel getLblFilas() {
		if (lblFilas == null) {
			lblFilas = new JLabel("Filas");
			lblFilas.setForeground(Color.WHITE);
			lblFilas.setFont(new Font("Tahoma", Font.PLAIN, 26));
			lblFilas.setBounds(234, 0, 69, 51);
		}
		return lblFilas;
	}

	private JLabel getLblColumnas() {
		if (lblColumnas == null) {
			lblColumnas = new JLabel("Columnas");
			lblColumnas.setForeground(Color.WHITE);
			lblColumnas.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblColumnas.setBounds(527, 0, 155, 51);
		}
		return lblColumnas;
	}

	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(313, 9, 46, 35);
			textField_1.setText("6");
			textField_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
			textField_1.setForeground(Color.WHITE);
			textField_1.setHorizontalAlignment(SwingConstants.CENTER);
			textField_1.setBackground(Color.DARK_GRAY);
			textField_1.setColumns(10);
			textField_1.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					textField_1.setText("");
				}
			});
		}
		return textField_1;
	}

	private JTextField getTextField_2_1() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
			textField_2.setHorizontalAlignment(SwingConstants.CENTER);
			textField_2.setText("7");
			textField_2.setForeground(Color.WHITE);
			textField_2.setBackground(Color.DARK_GRAY);
			textField_2.setBounds(454, 9, 46, 35);
			textField_2.setColumns(10);
			textField_2.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					textField_2.setText("");
				}
			});
		}
		return textField_2;
	}

	private JLabel getLblX() {
		if (lblX == null) {
			lblX = new JLabel("X");
			lblX.setForeground(Color.WHITE);
			lblX.setFont(new Font("Tahoma", Font.PLAIN, 43));
			lblX.setBounds(389, 0, 46, 51);
		}
		return lblX;
	}

	private JTextField getTxtNick() {
		if (txtNick == null) {
			txtNick = new JTextField();
			txtNick.setHorizontalAlignment(SwingConstants.CENTER);
			txtNick.setFont(new Font("Tahoma", Font.PLAIN, 33));
			txtNick.setForeground(new Color(0, 153, 255));
			txtNick.setBackground(Color.DARK_GRAY);
			txtNick.setBounds(165, 0, 197, 48);
			txtNick.setColumns(10);
			txtNick.setText("Nick1");
			txtNick.setBorder(null);
			txtNick.setBorder(BorderFactory.createLineBorder(Color.WHITE));
			txtNick.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					txtNick.setText("");
				}
			});
		}
		return txtNick;
	}

	private JLabel getLblXabico() {
		if (lblXabico == null) {
			lblXabico = new JLabel("Xabi&Co");
			lblXabico.setForeground(Color.WHITE);
		}
		return lblXabico;
	}

	private JTextField getTxtNickname() {
		if (txtNickname == null) {
			txtNickname = new JTextField();
			txtNickname.setBounds(454, 0, 197, 48);
			txtNickname.setText("Nick2");
			txtNickname.setHorizontalAlignment(SwingConstants.CENTER);
			txtNickname.setForeground(new Color(204, 0, 0));
			txtNickname.setFont(new Font("Tahoma", Font.PLAIN, 33));
			txtNickname.setColumns(10);
			txtNickname.setBorder(null);
			txtNickname.setBackground(Color.DARK_GRAY);
			txtNickname.setBorder(BorderFactory.createLineBorder(Color.WHITE));
			txtNickname.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					txtNickname.setText("");
				}
			});
		}
		return txtNickname;
	}
}