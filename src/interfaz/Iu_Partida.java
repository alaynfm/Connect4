package interfaz;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class Iu_Partida extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JLabel lblXabico;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JLabel lblNick;
	private JLabel label;
	private JLabel lblVs;
	private JLabel lblNick_1;
	private JLabel label_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JPanel panel_10;
	
	private JButton[][] tablero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Iu_Partida frame = new Iu_Partida();
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
	public Iu_Partida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 413);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.NORTH);
		contentPane.add(getPanel_1(), BorderLayout.WEST);
		contentPane.add(getPanel_2(), BorderLayout.EAST);
		contentPane.add(getPanel_3(), BorderLayout.SOUTH);
		contentPane.add(getPanel_4(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.DARK_GRAY);
			panel.setLayout(new GridLayout(0, 5, 0, 0));
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(Color.DARK_GRAY);
			panel_1.setLayout(new GridLayout(0, 1, 0, 0));
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
			panel_4.add(getPanel_5(), BorderLayout.NORTH);
			panel_4.add(getPanel_6(), BorderLayout.CENTER);
			panel_4.add(getPanel_10(), BorderLayout.WEST);
		}
		return panel_4;
	}
	private JLabel getLblXabico() {
		if (lblXabico == null) {
			lblXabico = new JLabel("Xabi&Co");
			lblXabico.setForeground(Color.GRAY);
		}
		return lblXabico;
	}
	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.setBackground(Color.DARK_GRAY);
			panel_5.setLayout(new GridLayout(0, 3, 0, 0));
			panel_5.add(getPanel_7());
			panel_5.add(getPanel_8());
			panel_5.add(getPanel_9());
		}
		return panel_5;
	}
	private JPanel getPanel_6() {
		if (panel_6 == null) {
			panel_6 = new JPanel();
			panel_6.setBackground(Color.DARK_GRAY);
			crearTablero(-1,9);
		}
		return panel_6;
	}
	
	public void crearTablero(int fila, int col) {
		
		
		int i = 6;
		int j= 9;
		if(fila<=0 || col<= 0) {			
			//poner mensaje de tamaño incorrecto creando por defecto;
		}else {
			i = fila;
			j = col;
		}
		
		
		tablero = new JButton[i][j+1];
		
		getPanel_6().setLayout(new GridLayout(0, j+1, 0, 0));
		
		for(int a= 0; a<i;a++) {
			for(int e= 0; e<j;e++) {
				JButton jb = new JButton();
				jb.setBackground(Color.GRAY);
				if(a != 0) {
					jb.setEnabled(false);				
				}
				
				if(e==0) {
					JLabel jl = new JLabel(a + "");
					jl.setForeground(Color.WHITE);
					getPanel_6().add(jl);
				}
				getPanel_6().add(jb);
				tablero[a][e] = jb;
			}
		}
	}
	private JPanel getPanel_7() {
		if (panel_7 == null) {
			panel_7 = new JPanel();
			panel_7.setBackground(Color.DARK_GRAY);
			panel_7.add(getLblNick());
			panel_7.add(getLabel());
		}
		return panel_7;
	}
	private JPanel getPanel_8() {
		if (panel_8 == null) {
			panel_8 = new JPanel();
			panel_8.setBackground(Color.DARK_GRAY);
			panel_8.add(getLblVs());
		}
		return panel_8;
	}
	private JPanel getPanel_9() {
		if (panel_9 == null) {
			panel_9 = new JPanel();
			panel_9.setBackground(Color.DARK_GRAY);
			panel_9.add(getLblNick_1());
			panel_9.add(getLabel_1());
		}
		return panel_9;
	}
	private JLabel getLblNick() {
		if (lblNick == null) {
			lblNick = new JLabel("Nick1");
			lblNick.setFont(new Font("Arial Black", Font.BOLD, 16));
			lblNick.setForeground(new Color(51, 153, 255));
		}
		return lblNick;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("25");
			label.setFont(new Font("Arial", Font.PLAIN, 13));
			label.setForeground(new Color(153, 0, 0));
		}
		return label;
	}
	private JLabel getLblVs() {
		if (lblVs == null) {
			lblVs = new JLabel("Vs");
			lblVs.setForeground(Color.WHITE);
			lblVs.setFont(new Font("Segoe Print", Font.PLAIN, 28));
		}
		return lblVs;
	}
	private JLabel getLblNick_1() {
		if (lblNick_1 == null) {
			lblNick_1 = new JLabel("Nick2");
			lblNick_1.setFont(new Font("Arial Black", Font.BOLD, 16));
			lblNick_1.setForeground(new Color(153, 0, 0));
		}
		return lblNick_1;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("25");
			label_1.setFont(new Font("Arial", Font.PLAIN, 13));
			label_1.setForeground(new Color(51, 153, 255));
		}
		return label_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("New button");
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("New button");
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("New button");
		}
		return btnNewButton_2;
	}
	private JPanel getPanel_10() {
		if (panel_10 == null) {
			panel_10 = new JPanel();
			panel_10.setBackground(Color.DARK_GRAY);
		}
		return panel_10;
	}
}
