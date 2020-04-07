package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

public class Normas extends JFrame {

	private JPanel contentPane;
	private JPanel seccion11;
	private JPanel seccion12;
	private JPanel seccion21;
	private JPanel seccion22;
	private JLabel lblFicha;
	private JLabel lblLogo;
	private JLabel lblNewLabel;
	private JLabel lblGrafico;
	private JLabel lblFicha_1;
	private JLabel lblTxt;
	private JLabel lblBaseDeDatos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Normas frame = new Normas();
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
	public Normas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 743, 591);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		contentPane.add(getSeccion11());
		contentPane.add(getSeccion12());
		contentPane.add(getSeccion21());
		contentPane.add(getSeccion22());
	}

	private JPanel getSeccion11() {
		if (seccion11 == null) {
			seccion11 = new JPanel();
			seccion11.setBackground(Color.DARK_GRAY);
			seccion11.setLayout(new GridLayout(0, 2, 0, 0));
			seccion11.add(getLabel_1());
			seccion11.add(getLabel_3());
		}
		return seccion11;
	}
	private JPanel getSeccion12() {
		if (seccion12 == null) {
			seccion12 = new JPanel();
			seccion12.setBackground(Color.DARK_GRAY);
			seccion12.setLayout(new GridLayout(0, 2, 0, 0));
			seccion12.add(getLabel_2());
			seccion12.add(getLblGrafico());
		}
		return seccion12;
	}
	private JPanel getSeccion21() {
		if (seccion21 == null) {
			seccion21 = new JPanel();
			seccion21.setBackground(Color.DARK_GRAY);
			seccion21.setLayout(new GridLayout(0, 2, 0, 0));
			seccion21.add(getLblFicha_1());
			seccion21.add(getLblTxt());
		}
		return seccion21;
	}
	private JPanel getSeccion22() {
		if (seccion22 == null) {
			seccion22 = new JPanel();
			seccion22.setLayout(new GridLayout(1, 0, 0, 0));
			seccion22.add(getLblBaseDeDatos());
		}
		return seccion22;
	}
	private JLabel getLabel_2() {
		if (lblFicha == null) {
			lblFicha = new JLabel("Ficha1");
			lblFicha.setBackground(Color.DARK_GRAY);
			lblFicha.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblFicha;
	}
	private JLabel getLabel_1() {
		if (lblLogo == null) {
			lblLogo = new JLabel("Logo");
			lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblLogo;
	}
	private JLabel getLabel_3() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("New label");
			lblNewLabel.setForeground(Color.PINK);
			lblNewLabel.setBackground(Color.PINK);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel;
	}
	private JLabel getLblGrafico() {
		if (lblGrafico == null) {
			lblGrafico = new JLabel("Grafico");
			lblGrafico.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblGrafico;
	}
	private JLabel getLblFicha_1() {
		if (lblFicha_1 == null) {
			lblFicha_1 = new JLabel("Ficha2");
			lblFicha_1.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblFicha_1;
	}
	private JLabel getLblTxt() {
		if (lblTxt == null) {
			lblTxt = new JLabel("txt");
			lblTxt.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblTxt;
	}
	private JLabel getLblBaseDeDatos() {
		if (lblBaseDeDatos == null) {
			lblBaseDeDatos = new JLabel("Base de datos");
			lblBaseDeDatos.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblBaseDeDatos;
	}
}
