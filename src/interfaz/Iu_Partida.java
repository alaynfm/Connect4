package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import partida.Cambio;
import partida.Reloj;
import partida.Tablero;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class Iu_Partida extends JFrame implements Observer, ComponentListener {

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
	private int tamanoX = 50;
	private int tamanoY = 50;

	private int numFilas;
	private int numColumnas;
	private int x = -1;
	private Cambio c;

	private static Iu_Partida miPartida = new Iu_Partida();

	/*
	 * Los numeros impares corresponden al jugador 1, los numeros pares al jugador 2
	 */
	private int turno;

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
	private Iu_Partida() {
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
		turno = 0;
		c = Cambio.getcambio();
		c.addObserver(this);
		crearTablero(9, 25);
	}

	public static Iu_Partida miPartida() {
		return miPartida;
	}

	public void crearTablero(int fila, int col) {

		if (fila <= 0 || col <= 0) {
			// poner mensaje de tamaño incorrecto creando por defecto;
			numFilas = 6;
			numColumnas = 12;
			fila = 6;
			col = 12;
		} else {
			numFilas = fila;
			numColumnas = col;
		}

		Tablero.getMiTablero().generarTablero(fila, col); // generamos el tablero de la partida
		tablero = new JButton[fila][col]; // generamos el tablero de botones

		int x = 0;
		int y = 15;

		for (int a = 0; a < fila; a++) {
			for (int e = 0; e < col; e++) {
				JButton jb = new JButton();
				jb.setBackground(Color.DARK_GRAY);
				jb.setBorderPainted(true);
				tablero[a][e] = jb;
				tablero[a][e].setBounds(x, y, tamanoX, tamanoY);
				jb.setBorder(new LineBorder(Color.GRAY));
				if (a == 0) {
					tablero[a][e].addMouseListener(new MouseAdapter() {

						public void mouseEntered(MouseEvent evento) {
							int j = (int) (jb.getX() / (tablero[0][1]).getX());
							setCambio(j);
							caidaFichas();
						}

						public void mouseExited(MouseEvent evento) {
							int j = (int) (jb.getX() / (tablero[0][1]).getX());
							setCambio(j);
							retomarFichas();
						}

						@Override
						public void mouseClicked(MouseEvent arg0) {
							// TODO Auto-generated method stub

							int j = (int) (jb.getX() / (tablero[0][1]).getX());
							setCambio(j);

							if (arg0.getButton() == 1) {
								// al hacer click izq colocamos la ficha

								if (turno % 2 == 0)
									Tablero.getMiTablero().colocarFicha2(j, "a");
								else
									Tablero.getMiTablero().colocarFicha2(j, "r");
								turno++;
								if (Tablero.getMiTablero().hayGanador()) {
									System.out.println(Tablero.getMiTablero().getGanador());
									// Poner codigo para terminar el juego
								}
								retomarFichas();

							} else if (arg0.getButton() == 3) {
								caidaFichas();

							}
							pintarColumna();
						}
					});
				}
				getPanel_6().add(jb);
				x = x + tamanoX;
			}
			x = 0;
			y = y + tamanoY;
		}

		pintarTablero();

		setSize(((numColumnas) * (tamanoX) + 42), ((numFilas + 1) * tamanoY) + panel_5.getHeight() + 100);
		setResizable(false);
		actualizarTablero(getPanel_6());
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	private void caidaFichas() {
		if (x >= 0) {
			for (int i = 0; i < tablero.length; i++) {

				if (!Tablero.getMiTablero().getPosicion(i, x).equals("-")) {

				} else if (i + 1 < tablero.length) {

					if (!Tablero.getMiTablero().getPosicion(i + 1, x).equals("-")) {

						//tablero[i][x].setBackground(Color.GRAY);
						if (turno % 2 == 0)
							tablero[i][x].setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLUE));
						else
							tablero[i][x].setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));

						break;
					}
				} else if (i == tablero.length - 1) {
					//tablero[i][x].setBackground(Color.GRAY);
					if (turno % 2 == 0)
						tablero[i][x].setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLUE));
					else
						tablero[i][x].setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
				}
			}
		}

	}

	private void retomarFichas() {

		for (int i = tablero.length - 1; i >= 0; i--) {
			tablero[i][x].setBackground(Color.DARK_GRAY);
			tablero[i][x].setBorder(new LineBorder(Color.GRAY));
			repaint();

		}

	}

	// metodo a utilizar en el update del Patron observer
	public void pintarColumna() {

		if (x >= 0) {
			ImageIcon imagen;

			for (int i = 0; i < tablero.length; i++) {

				String color = Tablero.getMiTablero().getPosicion(i, x);
				imagen = new ImageIcon("img/" + color + ".jpg");
				java.awt.Image conversion = imagen.getImage();
				java.awt.Image tamano = conversion.getScaledInstance(tablero[0][0].getWidth(), tablero[0][0].getWidth(),
						0);
				ImageIcon fin = new ImageIcon(tamano);

				if (color.equals("-"))
					tablero[i][x].setIcon(null);
				else
					tablero[i][x].setIcon(fin);

				repaint();
				actualizarTablero(getPanel_6());

			}

		} // else no hay nada que pintar no se ha hecho ningun cambio
	}

	public void pintarTablero() {
		ImageIcon imagen;

		for (int i = 0; i < tablero.length; i++) {
			for (int c = 0; c < tablero[0].length; c++) {
				String color = Tablero.getMiTablero().getPosicion(i, c);
				imagen = new ImageIcon("img/" + color + ".jpg");
				java.awt.Image conversion = imagen.getImage();
				java.awt.Image tamano = conversion.getScaledInstance(tablero[0][0].getWidth(), tablero[0][0].getWidth(),
						0);
				ImageIcon fin = new ImageIcon(tamano);
				tablero[i][c].setIcon(fin);

			}
		}
	}

	private void setCambio(int j) {
		x = j;
	}

	public int getCambio() {
		return x;
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
			panel_6.setLayout(null);
		}
		return panel_6;
	}

	private void actualizarTablero(JPanel panel) {
		SwingUtilities.updateComponentTreeUI(panel);
	}

	private JPanel getPanel_7() {
		if (panel_7 == null) {
			panel_7 = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel_7.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
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
			FlowLayout flowLayout = (FlowLayout) panel_9.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			panel_9.setBackground(Color.DARK_GRAY);
			panel_9.add(getLblNick_1());
			panel_9.add(getLabel_1());
		}
		return panel_9;
	}

	private JLabel getLblNick() {
		if (lblNick == null) {
			lblNick = new JLabel("Nick1");
			lblNick.setHorizontalAlignment(SwingConstants.CENTER);
			lblNick.setFont(new Font("Arial Black", Font.BOLD, 37));
			lblNick.setForeground(new Color(51, 153, 255));
		}
		return lblNick;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("25");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("Arial", Font.PLAIN, 21));
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
			lblNick_1.setFont(new Font("Arial Black", Font.BOLD, 37));
			lblNick_1.setForeground(new Color(153, 0, 0));
		}
		return lblNick_1;
	}

	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("25");
			label_1.setFont(new Font("Arial", Font.PLAIN, 25));
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

	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		pintarTablero();

	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		pintarTablero();

	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		pintarTablero();

	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		pintarTablero();

	}
}
