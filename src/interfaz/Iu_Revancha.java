package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import partida.AudioFilePlayer;
import partida.Tablero;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Iu_Revancha extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JLabel lblquieresJugarOtra;
	private JButton btnS;
	private JButton btnNo;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	Iu_gig_ganar gif;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Iu_Revancha frame = new Iu_Revancha();
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
	public Iu_Revancha() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 199);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel());
		contentPane.add(getPanel_4());
		contentPane.add(getPanel_5(), BorderLayout.NORTH);
		contentPane.add(getPanel_6(), BorderLayout.SOUTH);
		contentPane.add(getPanel_7(), BorderLayout.WEST);
		contentPane.add(getPanel_8(), BorderLayout.EAST);
		this.setUndecorated(true);
		setLocation(750,50);
		ImageIcon imagen = new ImageIcon("img/logo.jpg");
		this.setIconImage(imagen.getImage());
		
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
			panel_2.add(getLblquieresJugarOtra());
		}
		return panel_2;
	}

	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setBackground(Color.DARK_GRAY);
			FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
			flowLayout.setHgap(39);
			panel_3.add(getBtnS());
			panel_3.add(getBtnNo());
		}
		return panel_3;
	}

	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setBackground(Color.DARK_GRAY);
			panel_4.setLayout(new GridLayout(0, 1, 0, 0));
			panel_4.add(getPanel_1());
			panel_4.add(getPanel_2());
			panel_4.add(getPanel_3());
		}
		return panel_4;
	}

	private JLabel getLblquieresJugarOtra() {
		if (lblquieresJugarOtra == null) {
			lblquieresJugarOtra = new JLabel("\u00BFQuieres jugar otra Partida?");
			lblquieresJugarOtra.setBackground(Color.DARK_GRAY);
			lblquieresJugarOtra.setForeground(Color.WHITE);
			lblquieresJugarOtra.setFont(new Font("Tahoma", Font.PLAIN, 31));
		}
		return lblquieresJugarOtra;
	}

	private JButton getBtnS() {
		if (btnS == null) {
			btnS = new JButton("S\u00ED");
			btnS.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					//Tablero.getMiTablero().eliminarInterfaz();
					Tablero.getMiTablero().generarTablero(6, 9);
				

					setVisible(false);
					gif.setVisible(false);
					Iu_Menu1J.miPartida().setVisible(true);
					Tablero.getMiTablero().cerrarInterfaz();
					dispose();


				}
			});
			btnS.setForeground(new Color(255, 255, 255));
			btnS.setBackground(new Color(0, 153, 255));
		}
		return btnS;
	}

	private JButton getBtnNo() {
		if (btnNo == null) {
			btnNo = new JButton("No");
			btnNo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					Iu_Inicio.miInicio().setVisible(true);
					Tablero.getMiTablero().cerrarInterfaz();
					dispose();
				}
			});
			btnNo.setBackground(new Color(153, 0, 0));
			btnNo.setForeground(new Color(255, 255, 255));
			
		}
		return btnNo;
	}

	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
		}
		return panel_5;
	}

	private JPanel getPanel_6() {
		if (panel_6 == null) {
			panel_6 = new JPanel();
		}
		return panel_6;
	}

	private JPanel getPanel_7() {
		if (panel_7 == null) {
			panel_7 = new JPanel();
		}
		return panel_7;
	}

	private JPanel getPanel_8() {
		if (panel_8 == null) {
			panel_8 = new JPanel();
		}
		return panel_8;
	}
}
