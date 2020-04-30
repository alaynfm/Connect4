package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import gestor.CustomTableModel;
import gestor.GestorUsuarios;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Component;

public class Iu_highScores extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JLabel lblHigh;
	private static Iu_highScores miinterfaz = new Iu_highScores();
	private JScrollPane panel_5;
	private JButton btnSalir;
	private JTable table_puntuacionesF;
	private JTable table_puntuacionesD;
	private JButton btnNewButton;
	private String dificultadRanking="Facil";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Iu_highScores frame = new Iu_highScores();
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
	private Iu_highScores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 807);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.NORTH);
		contentPane.add(getPanel_1(), BorderLayout.SOUTH);
		contentPane.add(getPanel_2(), BorderLayout.WEST);
		contentPane.add(getPanel_3(), BorderLayout.EAST);
		contentPane.add(getPanel_4(), BorderLayout.CENTER);
		setLocationRelativeTo(null);
		ImageIcon imagen = new ImageIcon("img/logo.jpg");
		this.setIconImage(imagen.getImage());
	}
	public static Iu_highScores miPanel() {
		return miinterfaz;
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
			panel_4.setLayout(null);
			panel_4.add(getLblHigh());
			panel_4.add(getPanel_5());
			panel_4.add(getBtnSalir());
			panel_4.add(getBtnNewButton());
		}
		return panel_4;
	}
	private JLabel getLblHigh() {
		if (lblHigh == null) {
			lblHigh = new JLabel("Mejores Jugadores "+dificultadRanking);
			lblHigh.setForeground(new Color(0, 153, 255));
			lblHigh.setFont(new Font("Tahoma", Font.BOLD, 36));
			lblHigh.setHorizontalAlignment(SwingConstants.CENTER);
			lblHigh.setBounds(10, 0, 555, 71);
		}
		return lblHigh;
	}
	private JScrollPane getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JScrollPane();
			panel_5.setBorder(null);
			panel_5.setViewportBorder(null);
			panel_5.getViewport().setBackground(Color.DARK_GRAY);
			panel_5.setBounds(10, 108, 555, 569);
			panel_5.setViewportView(getTable_puntuacionesF());
		}
		return panel_5;
	}
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					Iu_Inicio.miInicio().setVisible(true);
				}
			});
			btnSalir.setBorder(new LineBorder(Color.DARK_GRAY, 3));
			btnSalir.setFont(new Font("Tahoma", Font.BOLD, 25));
			btnSalir.setForeground(Color.WHITE);
			btnSalir.setBackground(Color.DARK_GRAY);
			btnSalir.setBounds(10, 688, 555, 37);
		}
		return btnSalir;
	}

	private CustomTableModel obtenerTabla(String[][] tabla) {
		CustomTableModel nm= new CustomTableModel();
		nm.addColumn("Nombre");
		nm.addColumn("Puntuacion");
		for (int i=0;i<tabla[0].length;i++) {
			String nombre= tabla[0][i];
			String tiempo= tabla[1][i];
			if (nombre!=null) { //caso menos de 10 entradas
				String[] row= {nombre,tiempo};
				nm.addRow(row);
			}
		}
		return nm;
	}
	private JTable getTable_puntuacionesF() {
		if (table_puntuacionesF == null) {
			table_puntuacionesF = new JTable(this.obtenerTabla(GestorUsuarios.getGestorUsuarios().obtener10Mejores("Facil")));
			table_puntuacionesF.setGridColor(Color.DARK_GRAY);
			table_puntuacionesF.setShowGrid(false);
			table_puntuacionesF.setShowVerticalLines(false);
			table_puntuacionesF.setShowHorizontalLines(false);
			table_puntuacionesF.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			table_puntuacionesF.setForeground(Color.WHITE);
			table_puntuacionesF.setBackground(Color.DARK_GRAY);
			table_puntuacionesF.setForeground(Color.WHITE);
			table_puntuacionesF.setFont(new Font("Tahoma", Font.BOLD, 35));
			table_puntuacionesF.setAlignmentY(CENTER_ALIGNMENT);
			table_puntuacionesF.setRowHeight(53);
			table_puntuacionesF.setBorder(null);
			table_puntuacionesF.setAlignmentY(CENTER_ALIGNMENT);
			table_puntuacionesF.setAlignmentX(CENTER_ALIGNMENT);
		}
		return table_puntuacionesF;
	}
	private JTable getTable_puntuacionesD() {
		if (table_puntuacionesD == null) {
			table_puntuacionesD = new JTable(this.obtenerTabla(GestorUsuarios.getGestorUsuarios().obtener10Mejores("Dificil")));
			table_puntuacionesD.setGridColor(Color.DARK_GRAY);
			table_puntuacionesD.setShowGrid(false);
			table_puntuacionesD.setShowVerticalLines(false);
			table_puntuacionesD.setShowHorizontalLines(false);
			table_puntuacionesD.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			table_puntuacionesD.setForeground(Color.WHITE);
			table_puntuacionesD.setBackground(Color.DARK_GRAY);
			table_puntuacionesD.setForeground(Color.WHITE);
			table_puntuacionesD.setFont(new Font("Tahoma", Font.BOLD, 35));
			table_puntuacionesD.setAlignmentY(CENTER_ALIGNMENT);
			table_puntuacionesD.setRowHeight(53);
			table_puntuacionesD.setBorder(null);
			table_puntuacionesD.setAlignmentY(CENTER_ALIGNMENT);
			table_puntuacionesD.setAlignmentX(CENTER_ALIGNMENT);
		}
		return table_puntuacionesD;
	}
	public void actualizarPanel() {
		miinterfaz=new Iu_highScores();
		miinterfaz.setVisible(false);
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Cambiar Dificultad");
			btnNewButton.setForeground(Color.BLACK);
			btnNewButton.setBackground(Color.LIGHT_GRAY);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cambiarDificultadRanking();
				}
			});
			btnNewButton.setBounds(218, 74, 144, 23);
		}
		return btnNewButton;
	}
	public void cambiarDificultadRanking() {
		if (dificultadRanking.equals("Facil")) {
			panel_5.setViewportView(getTable_puntuacionesD());
			dificultadRanking="Dificil";
			lblHigh.setText("Mejores Jugadores "+dificultadRanking);
		}
		else if (dificultadRanking.equals("Dificil")) {
			panel_5.setViewportView(getTable_puntuacionesF());
			dificultadRanking="Facil";
			lblHigh.setText("Mejores Jugadores "+dificultadRanking);
		}
	}
}