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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Normas extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton btnNewButton;
	private JPanel panel_3;
	private JButton btnNewButton_1;
	private JLabel lblImagen;
	
	private int img = 1;
	private JPanel panel_4;
	private JButton btnNewButton_2;

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
		setBounds(100, 100, 800, 591);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.CENTER);
		contentPane.add(getPanel_1(), BorderLayout.SOUTH);
		img = 1;
		setUndecorated(true);
		setLocationRelativeTo(null);
		
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.DARK_GRAY);
			panel.setLayout(new GridLayout(1, 0, 0, 0));
			panel.add(getLblImagen());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(Color.DARK_GRAY);
			panel_1.setLayout(new GridLayout(0, 3, 0, 0));
			panel_1.add(getPanel_2());
			panel_1.add(getPanel_4());
			panel_1.add(getPanel_3());
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBackground(Color.DARK_GRAY);
			FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
			panel_2.add(getBtnNewButton());
		}
		return panel_2;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					img--;
					if(img<=0) img = 5;
					setImagen(img);
					
				}
			});
			btnNewButton.setBackground(Color.LIGHT_GRAY);
			btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
			ImageIcon imagen = new ImageIcon("img/me.png");
			java.awt.Image conversion = imagen.getImage();
			java.awt.Image tamano = conversion.getScaledInstance(20, 20, 0);
			ImageIcon fin = new ImageIcon(tamano);
			btnNewButton.setIcon(fin);
		}
		return btnNewButton;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setBackground(Color.DARK_GRAY);
			FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
			panel_3.add(getBtnNewButton_1());
		}
		return panel_3;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					img++;
					if(img>5) img = 1;
					setImagen(img);
				}
			});
			btnNewButton_1.setBackground(Color.LIGHT_GRAY);
			btnNewButton_1.setHorizontalAlignment(SwingConstants.RIGHT);
			ImageIcon imagen = new ImageIcon("img/ma.png");
			java.awt.Image conversion = imagen.getImage();
			java.awt.Image tamano = conversion.getScaledInstance(20, 20, 0);
			ImageIcon fin = new ImageIcon(tamano);
			btnNewButton_1.setIcon(fin);
		}
		return btnNewButton_1;
	}
	private JLabel getLblImagen() {
		if (lblImagen == null) {
			lblImagen = new JLabel("");
			setImagen(1);
			
		}
		return lblImagen;
	}
	
	private void setImagen(int i) {
		
		ImageIcon imagen = new ImageIcon("img/n" + i + ".png");
		java.awt.Image conversion = imagen.getImage();
		java.awt.Image tamano = conversion.getScaledInstance(800, 500, 0);
		ImageIcon fin = new ImageIcon(tamano);
		lblImagen.setIcon(fin);
		
	}
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setBackground(Color.DARK_GRAY);
			panel_4.add(getBtnNewButton_2());
		}
		return panel_4;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("salir");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					Iu_Inicio.miInicio().setVisible(true);
				}
			});
			btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		}
		return btnNewButton_2;
	}
}
