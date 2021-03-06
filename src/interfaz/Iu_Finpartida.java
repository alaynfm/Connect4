package interfaz;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import partida.Tablero;

import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.border.SoftBevelBorder;

import gestor.GestorUsuarios;

import javax.swing.border.BevelBorder;

public class Iu_Finpartida extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JButton btnNewButton;
	private JTextField txtNickJugador;
	private JTextField txtPuntuacion;
	private JButton btnNo;
	private JLabel lblquieresGuardarTu;
	private JPanel panel_9;
	private JPanel panel_10;
	AudioClip clip;
	private JLabel lblPosicionBaseDe;
	private int posRelativa;
	private String nombre;
	Iu_gig_ganar gif = new Iu_gig_ganar();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Iu_Finpartida frame = new Iu_Finpartida();
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
	public Iu_Finpartida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY,
				Color.DARK_GRAY));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.NORTH);
		contentPane.add(getPanel_1(), BorderLayout.SOUTH);
		contentPane.add(getPanel_2(), BorderLayout.WEST);
		contentPane.add(getPanel_3(), BorderLayout.EAST);
		contentPane.add(getPanel_4(), BorderLayout.CENTER);
		this.setUndecorated(true);
		this.reproducirMusica();
		ImageIcon imagen = new ImageIcon("img/logo.jpg");
		this.setIconImage(imagen.getImage());
		nombre = Tablero.getMiTablero().getJugador1();
		posRelativa = GestorUsuarios.getGestorUsuarios().obtenerTuPosicionRelativa(
				Tablero.getMiTablero().getTiempoUsuario(), Tablero.getMiTablero().getDificultad());
		lblPosicionBaseDe.setText("Has quedado en la posicion " + posRelativa + " ");
		
		gif.setVisible(true);
	}

	private void reproducirMusica() {

		try {
			clip = Applet.newAudioClip(new File("music/finalfantasy.wav").toURI().toURL());
			clip.play();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Si");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					clip.stop(); // para la musica
					// ir a la base de datos
					String nombre = txtNickJugador.getText();
					int tiempo = Tablero.getMiTablero().getTiempoUsuario();
					String dificultad = Tablero.getMiTablero().getDificultad();
					GestorUsuarios.getGestorUsuarios().partidaGanada(nombre, tiempo, dificultad); // guardamos los datos
					Iu_highScores.miPanel().actualizarPanel(); // actualizamos el ranking
					new Iu_ScorePartida();
					setVisible(false);
					Tablero.getMiTablero().cerrarInterfaz();
					gif.dispose();
					// guardar los datos
					// activar la interfaz HighScores
				}
			});
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setBackground(new Color(51, 153, 255));
		}
		return btnNewButton;
	}

	public void setJugador(String nombre) {
		txtNickJugador.setText(nombre);
	}

	public void setPuntuacion(String puntuacion) {
		txtPuntuacion.setText(puntuacion);
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

	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setBackground(Color.DARK_GRAY);
			panel_4.setLayout(new GridLayout(0, 1, 0, 0));
			panel_4.add(getPanel_9());
			panel_4.add(getPanel_6());
			panel_4.add(getPanel_7());
			panel_4.add(getPanel_10());
			panel_4.add(getPanel_5());
			panel_4.add(getPanel_8());
		}
		return panel_4;
	}

	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.setBackground(Color.DARK_GRAY);
			panel_5.setLayout(new GridLayout(0, 1, 0, 0));
			panel_5.add(getLblquieresGuardarTu());
		}
		return panel_5;
	}

	private JPanel getPanel_6() {
		if (panel_6 == null) {
			panel_6 = new JPanel();
			panel_6.setBackground(Color.DARK_GRAY);
			panel_6.setLayout(null);
			panel_6.add(getTxtNickJugador());
		}
		return panel_6;
	}

	private JPanel getPanel_7() {
		if (panel_7 == null) {
			panel_7 = new JPanel();
			panel_7.setBackground(Color.DARK_GRAY);
			panel_7.setLayout(null);
			panel_7.add(getTxtPuntuacion());
		}
		return panel_7;
	}

	private JPanel getPanel_8() {
		if (panel_8 == null) {
			panel_8 = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel_8.getLayout();
			flowLayout.setHgap(20);
			panel_8.setBackground(Color.DARK_GRAY);
			panel_8.add(getBtnNewButton());
			panel_8.add(getBtnNo());
		}
		return panel_8;
	}

	private JTextField getTxtNickJugador() {
		if (txtNickJugador == null) {
			txtNickJugador = new JTextField();
			txtNickJugador.setBounds(154, 0, 242, 37);
			txtNickJugador.setForeground(Color.WHITE);
			txtNickJugador.setBackground(new Color(0, 153, 255));
			txtNickJugador.setHorizontalAlignment(SwingConstants.CENTER);
			txtNickJugador.setFont(new Font("Tahoma", Font.PLAIN, 29));
			txtNickJugador.setText("Nick Jugador");
			txtNickJugador.setColumns(10);
			txtNickJugador.setBorder(BorderFactory.createLineBorder(Color.WHITE));
			txtNickJugador.setText(Tablero.getMiTablero().getJugador1());
			txtNickJugador.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					txtNickJugador.setText("");
				}
			});
		}
		return txtNickJugador;
	}

	private JTextField getTxtPuntuacion() {
		if (txtPuntuacion == null) {
			txtPuntuacion = new JTextField();
			txtPuntuacion.setBounds(180, 11, 182, 29);
			txtPuntuacion.setBackground(Color.DARK_GRAY);
			txtPuntuacion.setForeground(Color.WHITE);
			txtPuntuacion.setFont(new Font("Tahoma", Font.PLAIN, 22));
			txtPuntuacion.setHorizontalAlignment(SwingConstants.CENTER);
			txtPuntuacion.setText("Puntuacion");
			txtPuntuacion.setColumns(10);
			txtPuntuacion.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
			txtPuntuacion.setText("Puntuacion: " + Tablero.getMiTablero().getTiempoUsuario() + "");
		}
		return txtPuntuacion;
	}

	private JButton getBtnNo() {
		if (btnNo == null) {
			btnNo = new JButton("No");
			btnNo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Volvemos a la pantalla de inicio
					clip.stop(); // paramos la musica
					Iu_Inicio.miInicio().setVisible(true);
					setVisible(false);
					Tablero.getMiTablero().cerrarInterfaz();
					gif.dispose();
				}
			});
			btnNo.setBackground(new Color(153, 0, 0));
			btnNo.setForeground(Color.WHITE);
		}
		return btnNo;
	}

	private JLabel getLblquieresGuardarTu() {
		if (lblquieresGuardarTu == null) {
			lblquieresGuardarTu = new JLabel("\u00BFQuieres guardar tu puntuaci\u00F3n?");
			lblquieresGuardarTu.setForeground(Color.WHITE);
			lblquieresGuardarTu.setHorizontalAlignment(SwingConstants.CENTER);
			lblquieresGuardarTu.setFont(new Font("Tahoma", Font.PLAIN, 27));
		}
		return lblquieresGuardarTu;
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
			panel_10.add(getLblPosicionBaseDe());
		}
		return panel_10;
	}

	private JLabel getLblPosicionBaseDe() {
		if (lblPosicionBaseDe == null) {
			lblPosicionBaseDe = new JLabel("posicion base de datos");
			lblPosicionBaseDe.setFont(new Font("Tahoma", Font.PLAIN, 22));
			lblPosicionBaseDe.setForeground(Color.WHITE);
		}
		return lblPosicionBaseDe;
	}
}
