package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
import java.awt.Font;
import javax.swing.JTextField;

public class Iu_Registro extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel center;
	private JPanel panel_4;
	private JLabel lblXabico;
	private JPanel panel_5;
	private JLabel lblCrearUsuario;
	private JTextField textField;
	private JPasswordField textField_1;
	private JLabel lblNickname;
	private JLabel lblPassword;
	private JButton btnRegister;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Iu_Registro frame = new Iu_Registro();
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
	public Iu_Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 470);
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
			panel_4.setLayout(new BorderLayout(0, 0));
			panel_4.add(getPanel_5(), BorderLayout.CENTER);
			
		}
		return panel_4;
	}
	private JLabel getLblXabico() {
		if (lblXabico == null) {
			lblXabico = new JLabel("Xabi&Co");
			lblXabico.setForeground(new Color(204, 204, 204));
		}
		return lblXabico;
	}
	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.setBackground(Color.DARK_GRAY);
			GridBagLayout gbl_panel_5 = new GridBagLayout();
			gbl_panel_5.columnWidths = new int[] {100, 100, 100, 100, 200, 100, 100, 100, 100};
			gbl_panel_5.rowHeights = new int[] {30, 30, 30, 30, 30, 40, 30, 0, 0, 0, 0, 0};
			gbl_panel_5.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
			gbl_panel_5.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel_5.setLayout(gbl_panel_5);
			GridBagConstraints gbc_lblCrearUsuario = new GridBagConstraints();
			gbc_lblCrearUsuario.insets = new Insets(0, 0, 5, 5);
			gbc_lblCrearUsuario.gridx = 4;
			gbc_lblCrearUsuario.gridy = 3;
			panel_5.add(getLblCrearUsuario(), gbc_lblCrearUsuario);
			GridBagConstraints gbc_lblNickname = new GridBagConstraints();
			gbc_lblNickname.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNickname.insets = new Insets(0, 0, 5, 5);
			gbc_lblNickname.anchor = GridBagConstraints.EAST;
			gbc_lblNickname.gridx = 3;
			gbc_lblNickname.gridy = 5;
			panel_5.add(getLblNickname(), gbc_lblNickname);
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 5);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 4;
			gbc_textField.gridy = 5;
			panel_5.add(getTextField(), gbc_textField);
			GridBagConstraints gbc_lblPassword = new GridBagConstraints();
			gbc_lblPassword.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
			gbc_lblPassword.anchor = GridBagConstraints.EAST;
			gbc_lblPassword.gridx = 3;
			gbc_lblPassword.gridy = 6;
			panel_5.add(getLblPassword(), gbc_lblPassword);
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.insets = new Insets(0, 0, 5, 5);
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.gridx = 4;
			gbc_textField_1.gridy = 6;
			panel_5.add(getTextField_1(), gbc_textField_1);
			GridBagConstraints gbc_btnLogin = new GridBagConstraints();
			gbc_btnLogin.insets = new Insets(0, 0, 5, 5);
			gbc_btnLogin.gridx = 4;
			gbc_btnLogin.gridy = 8;
			panel_5.add(getBtnLogin(), gbc_btnLogin);
			GridBagConstraints gbc_btnRegister = new GridBagConstraints();
			gbc_btnRegister.insets = new Insets(0, 0, 5, 5);
			gbc_btnRegister.gridx = 4;
			gbc_btnRegister.gridy = 9;
			panel_5.add(getBtnRegister(), gbc_btnRegister);
		}
		return panel_5;
	}
	private JLabel getLblCrearUsuario() {
		if (lblCrearUsuario == null) {
			lblCrearUsuario = new JLabel("Account LogIn");
			lblCrearUsuario.setFont(new Font("Noto Sans", Font.PLAIN, 28));
			lblCrearUsuario.setForeground(new Color(255, 255, 255));
		}
		return lblCrearUsuario;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setColumns(5);
		}
		return textField;
	}
	private JPasswordField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JPasswordField();
			textField_1.setHorizontalAlignment(SwingConstants.CENTER);
			textField_1.setColumns(5);
		}
		return textField_1;
	}
	private JLabel getLblNickname() {
		if (lblNickname == null) {
			lblNickname = new JLabel("NickName");
			lblNickname.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblNickname.setForeground(Color.WHITE);
			lblNickname.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNickname;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password");
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
			lblPassword.setForeground(Color.WHITE);
		}
		return lblPassword;
	}
	private JButton getBtnRegister() {
		if (btnRegister == null) {
			btnRegister = new JButton("Register");
			btnRegister.setBackground(new Color(204, 51, 51));
			btnRegister.setForeground(new Color(204, 204, 204));
		}
		return btnRegister;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("      Login     ");
			btnLogin.setBackground(new Color(51, 153, 255));
			btnLogin.setForeground(Color.WHITE);
		}
		return btnLogin;
	}
}
