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

public class Menu1J extends JFrame {

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
	private JLabel lblDificultad;
	private JRadioButton rdbtnFacil;
	private JRadioButton rdbtnDificil;
	private JButton btnOk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu1J frame = new Menu1J();
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
	public Menu1J() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
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
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
		}
		return panel_2;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
		}
		return panel_3;
	}
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setLayout(new BorderLayout(0, 0));
			panel_4.add(getPanel_5(), BorderLayout.WEST);
			panel_4.add(getPanel_6(), BorderLayout.CENTER);
		}
		return panel_4;
	}
	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			GridBagLayout gbl_panel_5 = new GridBagLayout();
			gbl_panel_5.columnWidths = new int[] {10, 0};
			gbl_panel_5.rowHeights = new int[] {0, 30, 30, 30, 30, 30, 30, 0};
			gbl_panel_5.columnWeights = new double[]{0.0, Double.MIN_VALUE};
			gbl_panel_5.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
			panel_5.setLayout(gbl_panel_5);
			GridBagConstraints gbc_lblDificultad = new GridBagConstraints();
			gbc_lblDificultad.insets = new Insets(0, 0, 5, 0);
			gbc_lblDificultad.gridx = 0;
			gbc_lblDificultad.gridy = 0;
			panel_5.add(getLblDificultad(), gbc_lblDificultad);
			GridBagConstraints gbc_rdbtnFacil = new GridBagConstraints();
			gbc_rdbtnFacil.insets = new Insets(0, 0, 5, 0);
			gbc_rdbtnFacil.gridx = 0;
			gbc_rdbtnFacil.gridy = 1;
			panel_5.add(getRdbtnFacil(), gbc_rdbtnFacil);
			GridBagConstraints gbc_rdbtnDificil = new GridBagConstraints();
			gbc_rdbtnDificil.insets = new Insets(0, 0, 5, 0);
			gbc_rdbtnDificil.gridx = 0;
			gbc_rdbtnDificil.gridy = 2;
			panel_5.add(getRdbtnDificil(), gbc_rdbtnDificil);
			
			ButtonGroup grupo1 = new ButtonGroup();
			grupo1.add(getRdbtnDificil());
			grupo1.add(getRdbtnFacil());
			GridBagConstraints gbc_btnOk = new GridBagConstraints();
			gbc_btnOk.gridx = 0;
			gbc_btnOk.gridy = 7;
			panel_5.add(getBtnOk(), gbc_btnOk);
		}
		return panel_5;
	}
	private JPanel getPanel_6() {
		if (panel_6 == null) {
			panel_6 = new JPanel();
			panel_6.setLayout(new BorderLayout(0, 0));
			panel_6.add(getPanel_7(), BorderLayout.NORTH);
		}
		return panel_6;
	}
	private JPanel getPanel_7() {
		if (panel_7 == null) {
			panel_7 = new JPanel();
			panel_7.add(getLblNormas());
		}
		return panel_7;
	}
	private JLabel getLblNormas() {
		if (lblNormas == null) {
			lblNormas = new JLabel("Normas");
		}
		return lblNormas;
	}
	private JLabel getLblDificultad() {
		if (lblDificultad == null) {
			lblDificultad = new JLabel("DIficultad");
		}
		return lblDificultad;
	}
	private JRadioButton getRdbtnFacil() {
		if (rdbtnFacil == null) {
			rdbtnFacil = new JRadioButton("Facil");
		}
		return rdbtnFacil;
	}
	private JRadioButton getRdbtnDificil() {
		if (rdbtnDificil == null) {
			rdbtnDificil = new JRadioButton("Dificil");
		}
		return rdbtnDificil;
	}
	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("Ok");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
		return btnOk;
	}
}
