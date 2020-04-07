package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import partida.Tablero;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.GridLayout;
import javax.swing.SwingUtilities;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class Iu_Partida extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JLabel lblNick;
	private JLabel label;
	private JLabel lblVs;
	private JLabel lblNick_1;
	private JLabel label_1;
	private JPanel panel_10;
	private JButton[][] tablero;
	private int tamanoX = 50;
	private int tamanoY = 50;
	private int numFilas;
	private int numColumnas;
	private int x = -1;
	private boolean forma; // true si es 1 vs IA
	private int turno; // Para saber si le toca al azul o al rojo

	private static Iu_Partida miPartida = new Iu_Partida();

	/*
	 * Los numeros impares corresponden al jugador 1, los numeros pares al jugador 2
	 */

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

		// Constructora
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

		/*
		 * Si lo ponemos a true Jugador vs Jose Murillo Si ponemos a false Jugador1 vs
		 * Jugador2
		 */
	}

	public static Iu_Partida miPartida() {
		return miPartida;
	}

	// ----------------------------------------------------------------------------------------------------------------------------------------------------------------

	/* Programas para el manejo de la interfaz */

	// ----------------------------------------------------------------------------------------------------------------------------------------------------------------

	public void crearTablero(int fila, int col) {

		// programa para la creacion del tablero con los correspondientes botones

		if (fila <= 0 || col <= 0) {

			// poner mensaje de tamano incorrecto creando por defecto;
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
		int y = 6;

		for (int a = 0; a < fila; a++) {
			for (int e = 0; e < col; e++) {
				JButton jb = new JButton();
				jb.setBackground(null);
				jb.setBorderPainted(true);
				tablero[a][e] = jb;
				tablero[a][e].setBounds(x, y, tamanoX, tamanoY);
				jb.setBorder(new LineBorder(Color.GRAY));

				tablero[a][e].addMouseListener(new MouseAdapter() {

					public void mouseEntered(MouseEvent evento) {

						// Si pasamos por encima con el raton, mostramos la donde se colocaria la ficha
						int j = (int) (jb.getX() / (tablero[0][1]).getX());
						setCambio(j);
						caidaFichas();
					}

					public void mouseExited(MouseEvent evento) {

						// Cuando quitamos el cursor del raton volvemos a ponerlo normal
						int j = (int) (jb.getX() / (tablero[0][1]).getX());
						setCambio(j);
						retomarFichas();
					}

					@Override
					public void mouseClicked(MouseEvent arg0) {

						// Cuando hacemos click
						int j = (int) (jb.getX() / (tablero[0][1]).getX());
						setCambio(j);

						if (arg0.getButton() == 1) {
							// Cuando hacemos click izq

							if (forma) {

								// Si estamos jugando contra la IA entra aqui
								Tablero.getMiTablero().colocarFicha2(j);
								Tablero.getMiTablero().jugarPartida1vsia(j);
								retomarFichas();

							} else {

								Tablero.getMiTablero().colocarFicha2(j);
								turno++; // hay que alternar el turno para el color de la caida

							}

						}
					}
				});

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

	private void caidaFichas() {

		// metodo para pintar donde caeria la ficha al pasar por encima de la columna
		if (x >= 0) {
			for (int i = 0; i < tablero.length; i++) {

				if (!Tablero.getMiTablero().getPosicion(i, x).equals("-")) {

				} else if (i + 1 < tablero.length) {

					if (!Tablero.getMiTablero().getPosicion(i + 1, x).equals("-")) {

						// tablero[i][x].setBackground(Color.GRAY);
						if (turno % 2 == 0)
							tablero[i][x].setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLUE));
						else
							tablero[i][x].setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));

						break;
					}
				} else if (i == tablero.length - 1) {
					// tablero[i][x].setBackground(Color.GRAY);
					if (turno % 2 == 0)
						tablero[i][x].setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLUE));
					else
						tablero[i][x].setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
				}
			}
		}

	}

	private void retomarFichas() {

		// metodo para volver a colocar todo normal
		for (int i = tablero.length - 1; i >= 0; i--) {
			tablero[i][x].setBackground(Color.DARK_GRAY);
			tablero[i][x].setBorder(new LineBorder(Color.GRAY));
			repaint();

		}

	}

	public void pintarPosicion(int f, int c) {

		ImageIcon imagen;

		String color = Tablero.getMiTablero().getPosicion(f, c);
		imagen = new ImageIcon("img/" + color + ".png");
		java.awt.Image conversion = imagen.getImage();
		java.awt.Image tamano = conversion.getScaledInstance(tablero[0][0].getWidth() - 6, tablero[0][0].getWidth() - 6,
				0);
		ImageIcon fin = new ImageIcon(tamano);
		tablero[f][c].setIcon(fin);

		repaint();

	}

	public void pintarColumna(int columna) {

		// Una vez colocamos una ficha volvemos a pintar la columna para que se vea el
		// cambio
		// Podría mejorarse con el patron observer, cada vez que hacemos un cambio que
		// se pinte

		// Sabemos la columna que se ha cambiado gracias al atributo x (columna cambiada
		if (x >= 0) {
			ImageIcon imagen;

			for (int i = 0; i < tablero.length; i++) {

				String color = Tablero.getMiTablero().getPosicion(i, x);
				imagen = new ImageIcon("img/" + color + ".png");
				java.awt.Image conversion = imagen.getImage();
				java.awt.Image tamano = conversion.getScaledInstance(tablero[0][0].getWidth() - 6,
						tablero[0][0].getWidth() - 6, 0);
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

		// Para pintar todo el tablero (no es recomendable utilizar mas coste que
		// pintarColumna

		ImageIcon imagen;

		for (int i = 0; i < tablero.length; i++) {
			for (int c = 0; c < tablero[0].length; c++) {
				String color = Tablero.getMiTablero().getPosicion(i, c);
				imagen = new ImageIcon("img/" + color + ".png");
				java.awt.Image conversion = imagen.getImage();
				java.awt.Image tamano = conversion.getScaledInstance(tablero[0][0].getWidth() - 6,
						tablero[0][0].getWidth() - 6, 0);
				ImageIcon fin = new ImageIcon(tamano);
				tablero[i][c].setIcon(fin);

			}
		}
	}

	public void pintarGanadores(String f, String c, String color) {

		// utilizamos el metodo para marcar las casillas con las que se ha ganado la
		// partida

		try {

			int fila = Integer.parseInt(f);
			int columna = Integer.parseInt(c);

			if (color.equals("a")) 
				tablero[fila][columna].setBackground(Color.BLUE);
			else
				tablero[fila][columna].setBackground(Color.RED);

			tablero[fila][columna].setBorder(BorderFactory.createMatteBorder(1, 2, 1, 2, Color.GRAY));
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private void setCambio(int j) {

		// Metodo que utilizamos para decir que vamos a añadir una ficha en esa columna
		x = j;
	}

	public int getCambio() {

		// Metodo para obtener la columna en la que vamos a hacer el cambio
		return x;
	}

	// ----------------------------------------------------------------------------------------------------------------------------------------------------------------

	/* Programas para cambiar la informacion y funcionamiento de la interfaz */

	// ----------------------------------------------------------------------------------------------------------------------------------------------------------------

	public void setForma(boolean f) {
		/*
		 * Se le pasa un booleano si es true Jugador vs Jose Murillo (IA) si es false
		 * jugador vs jugador
		 */
		forma = f;
	}

	public void setNombreJugador1(String nombre) {
		// Para cambiar el nombre del jugador 1
		lblNick.setText(nombre);

	}

	public void setNombreJugador2(String nombre) {
		// Para cambiar el nombre del jugador dos o de la IA
		lblNick_1.setText(nombre);
	}

	public void setPuntuacionJugador1() {
		// Para cambiar la puntuacion del jugador1
	}

	public void setPunatuacionJugador2() {
		// Para cambiar la puntuacion del jugador2 o de la IA
	}

	public void getNombreJugador1() {
		// Para obtener el nombre del jugador 1 que hemos escrito
	}

	public void getNombreJugador2() {
		// Para obtener el nombre del jugador dos o de la IA que hemos escrito
	}

	public void getPuntuacionJugador1() {
		// Para obtener la puntuacion del jugador1 que hemos obtenido
	}

	public void getPunatuacionJugador2() {
		// Para obtener la puntuacion del jugador2 o de la IA que hemos obtenido
	}

	// ----------------------------------------------------------------------------------------------------------------------------------------------------------------

	// Codigo generado por Windowbuilder (en modo Lazy)

	// ----------------------------------------------------------------------------------------------------------------------------------------------------------------

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

	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.setBackground(Color.DARK_GRAY);
			panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel_5.add(getPanel_7());
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
			panel_7.setBackground(Color.DARK_GRAY);
			panel_7.add(getLblNick());
			panel_7.add(getLabel());
			panel_7.add(getLblVs());
			panel_7.add(getLabel_1());
			panel_7.add(getLblNick_1());
		}
		return panel_7;
	}

	private JLabel getLblNick() {
		if (lblNick == null) {
			lblNick = new JLabel("Nick1");
			lblNick.setHorizontalAlignment(SwingConstants.CENTER);
			lblNick.setFont(new Font("Arial Black", Font.BOLD, 21));
			lblNick.setForeground(new Color(51, 153, 255));
		}
		return lblNick;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel(" 1 ");
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
			lblNick_1.setFont(new Font("Arial Black", Font.BOLD, 21));
			lblNick_1.setForeground(new Color(153, 0, 0));
		}
		return lblNick_1;
	}

	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel(" 1 ");
			label_1.setFont(new Font("Arial", Font.PLAIN, 25));
			label_1.setForeground(new Color(51, 153, 255));
		}
		return label_1;
	}

	private JPanel getPanel_10() {
		if (panel_10 == null) {
			panel_10 = new JPanel();
			panel_10.setBackground(Color.DARK_GRAY);
		}
		return panel_10;
	}
}