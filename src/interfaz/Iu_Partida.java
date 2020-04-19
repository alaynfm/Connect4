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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.GridLayout;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

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
	private JLabel lblNick_1;
	private JPanel panel_10;
	private static int cont = 0;
	private Timer timer;
	private JButton[][] tablero;
	private int tamanoX = 70;
	private int tamanoY = 70;
	private int x = -1;
	private int turno; // Para saber si le toca al azul o al rojo
	private JLabel lblTimepoc;
	private JLabel lblTiempod;
	private JLabel lblTiempou;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_11;
	private JButton btnNewButton;

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
	public Iu_Partida() {

		// Constructora
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 413);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel_7(), BorderLayout.SOUTH);
		contentPane.add(getPanel(), BorderLayout.NORTH);
		contentPane.add(getPanel_1(), BorderLayout.WEST);
		contentPane.add(getPanel_2(), BorderLayout.EAST);
		contentPane.add(getPanel_4(), BorderLayout.CENTER);
		turno = 0;
		setLocationRelativeTo(null);
		contadorTimer();
		setUndecorated(true);
		iniciarTimer();
		cont = 0;
		timer.restart();
		

		/*
		 * Si lo ponemos a true Jugador vs Jose Murillo Si ponemos a false Jugador1 vs
		 * Jugador2
		 */
	}

	// ----------------------------------------------------------------------------------------------------------------------------------------------------------------

	/* Programas para el manejo de la interfaz */

	// ----------------------------------------------------------------------------------------------------------------------------------------------------------------

	public void crearTablero(int fila, int col) {

		// programa para la creacion del tablero con los correspondientes botones

		panel_6.setSize(((col) * (tamanoX)), ((fila + 3) * tamanoY));
		setSize(panel_7.getWidth() + panel_6.getWidth() + 40, panel_7.getHeight() + panel_6.getHeight() );
		tablero = new JButton[fila + 1][col]; // generamos el tablero de botones

		int x = 0;
		int y = 6;

		for (int a = 0; a < fila + 1; a++) {
			for (int e = 0; e < col; e++) {
				JButton jb = new JButton();
				jb.setBackground(null);
				jb.setBorderPainted(true);

				tablero[a][e] = jb;
				tablero[a][e].setBounds(x, y, tamanoX, tamanoY);
				jb.setIcon(null);

				if (a != 0) {
					jb.setBorder(new LineBorder(Color.GRAY));
					
				} else {
					jb.setBorder(new LineBorder(Color.WHITE));

					tablero[a][e].addMouseListener(new MouseAdapter() {

						public void mouseEntered(MouseEvent evento) {

							// Si pasamos por encima con el raton, mostramos la donde se colocaria la ficha
							int j = (int) (jb.getX() / (tablero[0][1]).getX());
							setCambio(j);
							caidaFichas();
						}

						public void mouseExited(MouseEvent evento) {

							if 	(!Tablero.getMiTablero().hayGanador()) {
								// Cuando quitamos el cursor del raton volvemos a ponerlo normal
								int j = (int) (jb.getX() / (tablero[0][1]).getX());
								setCambio(j);
								retomarFichas();
							}
						}

						@Override
						public void mouseClicked(MouseEvent arg0) {

							// Cuando hacemos click
							int j = (int) (jb.getX() / (tablero[0][1]).getX());
			
							if (arg0.getButton() == 1) {
								// Cuando hacemos click izq

								Tablero.getMiTablero().jugarPartida(j);

							}
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
		setResizable(false);
		actualizarTablero(getPanel_6());
	}

	private void caidaFichas() {

		// metodo para pintar donde caeria la ficha al pasar por encima de la columna
		if (x >= 0) {
			
			ImageIcon img = new ImageIcon("img/f.png");
			java.awt.Image conversion = img.getImage();
			java.awt.Image tamano = conversion.getScaledInstance(60,60,	0);
			ImageIcon fin = new ImageIcon(tamano);
			tablero[0][x].setIcon(fin);
			for (int i = 1; i < tablero.length; i++) {

				if (!Tablero.getMiTablero().getPosicion(i-1, x).equals("-")) {

				} else if (i +1< tablero.length) {

					if (!Tablero.getMiTablero().getPosicion(i, x).equals("-")) {

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
					
					break;
				}
			}
		}

	}

	public void seturno(int t) {
		turno = t;
	}

	private void retomarFichas() {

		// metodo para volver a colocar todo normal
		for (int i = tablero.length - 1; i >= 1; i--) {
			tablero[i][x].setBackground(Color.DARK_GRAY);
			tablero[i][x].setBorder(new LineBorder(Color.GRAY));
			repaint();

		}
		tablero[0][x].setIcon(null);

	}

	public void pintarPosicion(int f, int c, String color) {

		ImageIcon imagen;

		// Hay q poner la imagen buena
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

		for (int i = 1; i < tablero.length; i++) {
			for (int c = 0; c < tablero[0].length; c++) {
				String color = Tablero.getMiTablero().getPosicion(i - 1, c);
				imagen = new ImageIcon("img/" + color + ".png");
				java.awt.Image conversion = imagen.getImage();
				java.awt.Image tamano = conversion.getScaledInstance(tablero[0][0].getWidth() - 6,
						tablero[0][0].getWidth() - 6, 0);
				ImageIcon fin = new ImageIcon(tamano);
				tablero[i - 1][c].setIcon(fin);

			}
		}
	}

	public void restableceTablero() {

		for (int i = 0; i < tablero.length; i++) {
			for (int c = 0; c < tablero[0].length; c++) {
				tablero[i][c].setBorder(new LineBorder(Color.GRAY));
				tablero[i][c].setBackground(Color.DARK_GRAY);
				tablero[i][c].setIcon(null);
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
				tablero[fila + 1][columna].setBackground(Color.BLUE);
			else
				tablero[fila + 1][columna].setBackground(Color.RED);

			tablero[fila+1][columna].setBorder(BorderFactory.createMatteBorder(1, 2, 1, 2, Color.GRAY));

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private void setCambio(int j) {

		// Metodo que utilizamos para decir que vamos a añadir una ficha en esa columna
		x = j;
	}

	private Timer iniciarTimer() {
		// Inicia el contador del timer

			cont = 0;
			timer = new Timer(1000, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					cont +=1;
					contadorTimer();
				}
			});
			
		timer.start();
		return timer;
	}

	private void contadorTimer() {

		int centenas = cont / 100;
		int decenas = (cont - (centenas * 100)) / 10;
		int unidades = cont - (centenas * 100 + decenas * 10);

		ImageIcon imgD = new ImageIcon("img/r" + decenas + ".png");
		ImageIcon imgU = new ImageIcon("img/r" + unidades + ".png");
		ImageIcon imgC = new ImageIcon("img/r" + centenas + ".png");

		java.awt.Image timerC = imgC.getImage();
		java.awt.Image sizeC = timerC.getScaledInstance(25, 30, 0);
		ImageIcon centena = new ImageIcon(sizeC);

		java.awt.Image timerD = imgD.getImage();
		java.awt.Image sizeD = timerD.getScaledInstance(25, 30, 0);
		ImageIcon decena = new ImageIcon(sizeD);

		java.awt.Image timerU = imgU.getImage();
		java.awt.Image sizeU = timerU.getScaledInstance(25, 30, 0);
		ImageIcon unidad = new ImageIcon(sizeU);

		getLblTimepoC().setIcon(centena);
		getLblTiempoD().setIcon(decena);
		getLblTiempoU().setIcon(unidad);

	}

	public void pararTimer() {
		timer.stop();
	}

	// ----------------------------------------------------------------------------------------------------------------------------------------------------------------

	/* Programas para cambiar la informacion y funcionamiento de la interfaz */

	// ----------------------------------------------------------------------------------------------------------------------------------------------------------------

	public void setNombreJugador1(String nombre) {
		// Para cambiar el nombre del jugador 1
		lblNick.setText(nombre);

	}

	public void setNombreJugador2(String nombre) {
		// Para cambiar el nombre del jugador dos o de la IA
		lblNick_1.setText(nombre);
	}

	public String getNombreJugador1() {
		// Para obtener el nombre del jugador 1 que hemos escrito
		return lblNick.getText();
	}

	public String getNombreJugador2() {
		// Para obtener el nombre del jugador dos o de la IA que hemos escrito
		return lblNick_1.getText();
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
			panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel_3.add(getLblTimepoC());
			panel_3.add(getLblTiempoD());
			panel_3.add(getLblTiempoU());
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
			panel_5.add(getPanel_3());
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
			panel_7.setBackground(Color.DARK_GRAY);
			panel_7.setLayout(new GridLayout(0, 3, 0, 0));
			panel_7.add(getPanel_8());
			panel_7.add(getPanel_9());
			panel_7.add(getPanel_11());
		}
		return panel_7;
	}

	private JLabel getLblNick() {
		if (lblNick == null) {
			lblNick = new JLabel("Nick1");
			lblNick.setBackground(Color.DARK_GRAY);
			lblNick.setHorizontalAlignment(SwingConstants.CENTER);
			lblNick.setFont(new Font("Arial Black", Font.PLAIN, 25));
			lblNick.setForeground(new Color(51, 153, 255));
		}
		return lblNick;
	}

	private JLabel getLblNick_1() {
		if (lblNick_1 == null) {
			lblNick_1 = new JLabel("Nick2");
			lblNick_1.setBackground(Color.DARK_GRAY);
			lblNick_1.setFont(new Font("Arial Black", Font.PLAIN, 25));
			lblNick_1.setForeground(new Color(153, 0, 0));
		}
		return lblNick_1;
	}

	private JPanel getPanel_10() {
		if (panel_10 == null) {
			panel_10 = new JPanel();
			panel_10.setBackground(Color.DARK_GRAY);
		}
		return panel_10;
	}

	private JLabel getLblTimepoC() {
		if (lblTimepoc == null) {
			lblTimepoc = new JLabel("");
		}
		return lblTimepoc;
	}

	private JLabel getLblTiempoD() {
		if (lblTiempod == null) {
			lblTiempod = new JLabel("");
		}
		return lblTiempod;
	}

	private JLabel getLblTiempoU() {
		if (lblTiempou == null) {
			lblTiempou = new JLabel("");
		}
		return lblTiempou;
	}

	private JPanel getPanel_8() {
		if (panel_8 == null) {
			panel_8 = new JPanel();
			panel_8.setBackground(Color.DARK_GRAY);
			panel_8.add(getLblNick());
		}
		return panel_8;
	}

	private JPanel getPanel_9() {
		if (panel_9 == null) {
			panel_9 = new JPanel();
			panel_9.setBackground(Color.DARK_GRAY);
			panel_9.add(getBtnNewButton());
		}
		return panel_9;
	}

	private JPanel getPanel_11() {
		if (panel_11 == null) {
			panel_11 = new JPanel();
			panel_11.setBackground(Color.DARK_GRAY);
			panel_11.add(getLblNick_1());
		}
		return panel_11;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Rendirse");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					timer.stop();
					cont = 0;
					dispose();
					Iu_Inicio.miInicio().setVisible(true);
					
				}
			});
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setBackground(Color.DARK_GRAY);
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 23));
		}
		return btnNewButton;
	}
}