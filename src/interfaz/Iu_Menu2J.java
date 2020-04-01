package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Label;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTree;

import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

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
	private JLabel lblNickname;
	private JTextField textField;
	private JPanel panel_7;
	private JButton btnEmpezar;
	private JButton btnNormas;
	private JButton btnAtras;
	private JLabel lblVs;
	private JLabel lblJoseMurillo;
	private JTextField textField_1;

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
		setBounds(100, 100, 873, 470);
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
		}
		return norte1;
	}
	private JPanel getPanel_10() {
		if (sur1 == null) {
			sur1 = new JPanel();
		}
		return sur1;
	}
	private JPanel getPanel_11() {
		if (oeste1 == null) {
			oeste1 = new JPanel();
		}
		return oeste1;
	}
	private JPanel getPanel_12() {
		if (este1 == null) {
			este1 = new JPanel();
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
			panel_2.add(getLblNickname());
			panel_2.add(getTextField_2());
			panel_2.add(getLblVs());
			panel_2.add(getLblJoseMurillo());
			panel_2.add(getTextField_1());
		}
		return panel_2;
	}
	private JPanel getPanel_3_1() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setBackground(Color.DARK_GRAY);
			panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
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
	private JLabel getLblNickname() {
		if (lblNickname == null) {
			lblNickname = new JLabel("Nickname1");
			lblNickname.setForeground(new Color(0, 153, 255));
			lblNickname.setFont(new Font("Tahoma", Font.PLAIN, 33));
			lblNickname.setBounds(82, -5, 160, 57);
		}
		return lblNickname;
	}
	private JTextField getTextField_2() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(252, 18, 86, 20);
			textField.setColumns(10);
		}
		return textField;
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
			btnEmpezar.setBounds(372, 11, 89, 23);
		}
		return btnEmpezar;
	}
	private JButton getBtnNormas() {
		if (btnNormas == null) {
			btnNormas = new JButton("Normas");
			btnNormas.setBounds(706, 11, 89, 23);
		}
		return btnNormas;
	}
	private JButton getBtnAtras() {
		if (btnAtras == null) {
			btnAtras = new JButton("Atras");
			btnAtras.setBounds(47, 11, 89, 23);
			btnAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					Iu_Inicio.miInicio().setVisible(true);
				}
			});
		}
		return btnAtras;
	}
	private JLabel getLblVs() {
		if (lblVs == null) {
			lblVs = new JLabel("Vs");
			lblVs.setForeground(Color.WHITE);
			lblVs.setFont(new Font("Tahoma", Font.PLAIN, 36));
			lblVs.setBounds(390, -5, 46, 57);
		}
		return lblVs;
	}
	private JLabel getLblJoseMurillo() {
		if (lblJoseMurillo == null) {
			lblJoseMurillo = new JLabel("Nickname2");
			lblJoseMurillo.setForeground(new Color(204, 0, 0));
			lblJoseMurillo.setFont(new Font("Tahoma", Font.PLAIN, 33));
			lblJoseMurillo.setBounds(480, -5, 168, 57);
		}
		return lblJoseMurillo;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(656, 18, 86, 20);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
}
