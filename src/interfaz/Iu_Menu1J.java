package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import partida.Tablero;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Shape;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Font;
import java.awt.Graphics;

public class Iu_Menu1J extends JFrame {

	private JPanel contentPane;

	private static Iu_Menu1J miPartida = new Iu_Menu1J();
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
	private JRadioButton rdbtnFacil;
	private JRadioButton rdbtnDificil;
	private JPanel panel_7;
	private JButton btnEmpezar;
	private JButton btnNormas;
	private JButton btnAtras;
	private JLabel lblVs;
	private JTextField lblJoseMurillo;
	private JPanel panel_5;
	private JLabel lblFilas;
	private JLabel lblColumnas;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblX;
	private ButtonGroup group = new ButtonGroup();
	private JTextField txtNick;
	private JRadioButton rdbtnvs;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Iu_Menu1J frame = new Iu_Menu1J();
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
	private Iu_Menu1J() {
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
		group.add(rdbtnDificil);
		group.add(rdbtnFacil);
		group.add(getRdbtnvs());
		getRdbtnvs().setSelected(true);
		setLocationRelativeTo(null);
		setUndecorated(true);
		ImageIcon imagen = new ImageIcon("img/logo.jpg");
		this.setIconImage(imagen.getImage());

	}

	public static Iu_Menu1J miPartida() {
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
			centro1.add(getPanel_4_1());
			centro1.add(getPanel_6_1());
			centro1.add(getPanel_5());
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
			panel_2.add(getLblJoseMurillo());
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
			panel_4.add(getRdbtnFacil());
			panel_4.add(getRdbtnDificil());
			panel_4.add(getRdbtnvs());
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

	private JRadioButton getRdbtnFacil() {
		if (rdbtnFacil == null) {
			rdbtnFacil = new JRadioButton("Facil");
			rdbtnFacil.setForeground(Color.WHITE);
			rdbtnFacil.setBounds(242, 0, 100, 49);
			rdbtnFacil.setBackground(Color.DARK_GRAY);
			rdbtnFacil.setFont(new Font("Tahoma", Font.PLAIN, 25));
			rdbtnFacil.setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnFacil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblJoseMurillo.setText("Murillo");
				}
			});
		}
		return rdbtnFacil;
	}

	private JRadioButton getRdbtnDificil() {
		if (rdbtnDificil == null) {
			rdbtnDificil = new JRadioButton("Dificil");
			rdbtnDificil.setForeground(Color.WHITE);
			rdbtnDificil.setBounds(363, 0, 92, 49);
			rdbtnDificil.setBackground(Color.DARK_GRAY);
			rdbtnDificil.setFont(new Font("Tahoma", Font.PLAIN, 25));
			rdbtnDificil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblJoseMurillo.setText("Murillo");
				}
			});
		}
		return rdbtnDificil;
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

					// El normbre nos da igual, aceptamos cuqlquiera
					Tablero.getMiTablero().setj1(txtNick.getText());
					Tablero.getMiTablero().setj2("Murillo");


					if (txtNick.getText().length() > 8 || txtNick.getText().length() == 0 || lblJoseMurillo.getText().length() > 8 || lblJoseMurillo.getText().length() == 0) {

						JOptionPane.showMessageDialog(null, "Los nicknames con menos de 8 caracteres", "Warming",
								JOptionPane.WARNING_MESSAGE);

					} else {

						Tablero.getMiTablero().generarTablero(6, 9);

						if (rdbtnDificil.isSelected() || rdbtnFacil.isSelected() || rdbtnvs.isSelected()) {

							setVisible(false);

							if (rdbtnFacil.isSelected()) {
								Tablero.getMiTablero().setForma(true);
								Tablero.getMiTablero().setIa(true);
							} else if (rdbtnDificil.isSelected()) {
								Tablero.getMiTablero().setForma(true);
								Tablero.getMiTablero().setIa(false);
							} else {
								Tablero.getMiTablero().setForma(false);
							}

						} else {
							JOptionPane.showMessageDialog(null, "Por favor seleccione una dificultad", "Warming",
									JOptionPane.WARNING_MESSAGE);
						}
					}
				}
			});
			btnEmpezar.setForeground(Color.DARK_GRAY);
			btnEmpezar.setBackground(Color.LIGHT_GRAY);
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
					(new Normas()).setVisible(true);
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
			lblVs.setBounds(379, -5, 46, 57);
		}
		return lblVs;
	}

	private JTextField getLblJoseMurillo() {
		if (lblJoseMurillo == null) {
			lblJoseMurillo = new JTextField("Jugador2");
			lblJoseMurillo.setHorizontalAlignment(SwingConstants.CENTER);
			lblJoseMurillo.setBounds(453, 0, 197, 49);
			lblJoseMurillo.setForeground(Color.WHITE);
			lblJoseMurillo.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
			lblJoseMurillo.setFont(new Font("Tahoma", Font.PLAIN, 33));

			lblJoseMurillo.setBackground(new Color(153, 0, 0));
			lblJoseMurillo.setBorder(BorderFactory.createLineBorder(Color.WHITE));
			lblJoseMurillo.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					lblJoseMurillo.setText("");
				}
			});

		}
		return lblJoseMurillo;
	}

	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.setBackground(Color.DARK_GRAY);
			panel_5.setLayout(null);
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
			textField_2.setText("9");
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
			txtNick.setForeground(Color.WHITE);
			txtNick.setBackground(new Color(0, 153, 255));
			txtNick.setBounds(142, 0, 197, 48);
			txtNick.setColumns(10);
			txtNick.setText("Jugador1");
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

	private JRadioButton getRdbtnvs() {
		if (rdbtnvs == null) {
			rdbtnvs = new JRadioButton("1vs1");
		
			rdbtnvs.setForeground(Color.WHITE);
			rdbtnvs.setFont(new Font("Tahoma", Font.PLAIN, 25));
			rdbtnvs.setBackground(Color.DARK_GRAY);
			rdbtnvs.setBounds(483, 0, 92, 49);
			rdbtnvs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblJoseMurillo.setText("Jugador2");
				}
			});
		}
		return rdbtnvs;
	}
}
