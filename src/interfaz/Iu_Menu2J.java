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
import java.io.File;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

public class Iu_Menu2J extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JLabel lblNormas;
	private JButton btnOk;
	private JLabel lblNickname;
	private JButton btnChangeNickname;
	private JLabel lblXabico;
	private JLabel lblHeight;
	private JTextField textField;
	private JLabel lblColumns;
	private JTextField textField_1;
	private JLabel lblNicknamep;
	private JButton btnChangeNickname_1;
	private JPanel panel_8;
	private JTextPane txtpnHolaa;

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
	public Iu_Menu2J() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 470);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.NORTH);
		contentPane.add(getPanel_1(), BorderLayout.EAST);
		contentPane.add(getPanel_2(), BorderLayout.WEST);
		contentPane.add(getPanel_3(), BorderLayout.SOUTH);
		contentPane.add(getPanel_4(), BorderLayout.CENTER);
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
			panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
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
			panel_3.add(getLblXabico());
		}
		return panel_3;
	}

	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setBackground(Color.DARK_GRAY);
			panel_4.setLayout(new BorderLayout(0, 0));
			panel_4.add(getPanel_5(), BorderLayout.WEST);
			panel_4.add(getPanel_6(), BorderLayout.CENTER);
		}
		return panel_4;
	}

	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.setForeground(new Color(255, 255, 255));
			panel_5.setBackground(Color.DARK_GRAY);
			panel_5.setLayout(
					new MigLayout("", "[117px,grow]", "[35px][20px][5px][35px][20px][5px][][][][][5px][35px]"));
			panel_5.add(getLblNickname(), "cell 0 0,grow");
			panel_5.add(getBtnChangeNickname(), "cell 0 1,grow");
			panel_5.add(getLblNicknamep(), "cell 0 3");
			panel_5.add(getBtnChangeNickname_1(), "cell 0 4");
			panel_5.add(getLblHeight(), "cell 0 6");
			panel_5.add(getTextField(), "cell 0 7,growx");
			panel_5.add(getLblColumns(), "cell 0 8");
			panel_5.add(getTextField_1(), "cell 0 9,growx");
			panel_5.add(getBtnOk(), "cell 0 11,grow");

			ButtonGroup grupo1 = new ButtonGroup();
		}
		return panel_5;
	}

	private JPanel getPanel_6() {
		if (panel_6 == null) {
			panel_6 = new JPanel();
			panel_6.setBackground(Color.DARK_GRAY);
			panel_6.setLayout(new BorderLayout(0, 0));
			panel_6.add(getPanel_7(), BorderLayout.NORTH);
			panel_6.add(getPanel_8(), BorderLayout.CENTER);
		}
		return panel_6;
	}

	private JPanel getPanel_7() {
		if (panel_7 == null) {
			panel_7 = new JPanel();
			panel_7.setBackground(Color.DARK_GRAY);
			panel_7.add(getLblNormas());
		}
		return panel_7;
	}

	private JLabel getLblNormas() {
		if (lblNormas == null) {
			lblNormas = new JLabel("Normas");
			lblNormas.setForeground(new Color(255, 255, 255));
		}
		return lblNormas;
	}

	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("Ok");
			btnOk.setForeground(Color.WHITE);
			btnOk.setBackground(Color.DARK_GRAY);
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					// hay que comprobar que filas y columnas son numeros
				}
			});
		}
		return btnOk;
	}

	private JLabel getLblNickname() {
		if (lblNickname == null) {
			lblNickname = new JLabel("Nickname 1p");
			lblNickname.setForeground(new Color(255, 255, 255));
		}
		return lblNickname;
	}

	private JButton getBtnChangeNickname() {
		if (btnChangeNickname == null) {
			btnChangeNickname = new JButton("Change nickname");
			btnChangeNickname.setForeground(Color.WHITE);
			btnChangeNickname.setBackground(new Color(51, 153, 255));
		}
		return btnChangeNickname;
	}

	private JLabel getLblXabico() {
		if (lblXabico == null) {
			lblXabico = new JLabel("Xabi&Co");
			lblXabico.setForeground(new Color(255, 255, 255));
		}
		return lblXabico;
	}

	private JLabel getLblHeight() {
		if (lblHeight == null) {
			lblHeight = new JLabel("Rows");
			lblHeight.setForeground(new Color(255, 255, 255));
		}
		return lblHeight;
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
		}
		return textField;
	}

	private JLabel getLblColumns() {
		if (lblColumns == null) {
			lblColumns = new JLabel("Columns");
			lblColumns.setForeground(new Color(255, 255, 255));
		}
		return lblColumns;
	}

	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
		}
		return textField_1;
	}

	private JLabel getLblNicknamep() {
		if (lblNicknamep == null) {
			lblNicknamep = new JLabel("Nickname 2p");
			lblNicknamep.setForeground(new Color(255, 255, 255));
		}
		return lblNicknamep;
	}

	private JButton getBtnChangeNickname_1() {
		if (btnChangeNickname_1 == null) {
			btnChangeNickname_1 = new JButton("Change Nickname");
			btnChangeNickname_1.setForeground(Color.WHITE);
			btnChangeNickname_1.setBackground(new Color(153, 0, 0));
		}
		return btnChangeNickname_1;
	}

	private JPanel getPanel_8() {
		if (panel_8 == null) {
			panel_8 = new JPanel();
			panel_8.setBorder(new LineBorder(Color.GRAY, 1, true));
			panel_8.setBackground(Color.DARK_GRAY);
			panel_8.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
			panel_8.add(getTxtpnHolaa());
		}
		return panel_8;
	}

	private JTextPane getTxtpnHolaa() {
		if (txtpnHolaa == null) {
			txtpnHolaa = new JTextPane();
			txtpnHolaa.setBackground(Color.DARK_GRAY);
			txtpnHolaa.setForeground(Color.WHITE);
			txtpnHolaa.setText("");
			this.leerNormas();
		}
		return txtpnHolaa;
	}

	private void leerNormas() {
		
		String norma = "";

		try {
			Scanner input = new Scanner(new File("normas.txt"));
			while (input.hasNextLine()) {
				String line = input.nextLine();
				norma = norma + line +"\n"; 

			}
			input.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println();
		getTxtpnHolaa().setText(norma);

	}
}
