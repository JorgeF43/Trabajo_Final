package Almacen;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Choice;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Menu_Entrada extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnGUsuarios;
	private JButton btnGProductos;
	private JButton btnCerrar_Sesión;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_Entrada frame = new Menu_Entrada();
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
	public Menu_Entrada() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 413, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(178, 34, 34));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnGUsuarios = new JButton("Gesti\u00F3n de Usuarios");
		btnGUsuarios.addActionListener(this);
		btnGUsuarios.setIcon(new ImageIcon("C:\\Users\\Francisca Severino\\Desktop\\Iconos Java\\icons8-usuario-masculino-64.png"));
		btnGUsuarios.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnGUsuarios.setBounds(83, 11, 218, 91);
		contentPane.add(btnGUsuarios);
		
		btnGProductos = new JButton("Gesti\u00F3n de Productos");
		btnGProductos.addActionListener(this);
		btnGProductos.setIcon(new ImageIcon("C:\\Users\\Francisca Severino\\Desktop\\Iconos Java\\icons8-inspecci\u00F3n-50.png"));
		btnGProductos.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnGProductos.setBounds(83, 113, 218, 91);
		contentPane.add(btnGProductos);
		
		btnCerrar_Sesión = new JButton("Cerrar Sesi\u00F3n");
		btnCerrar_Sesión.addActionListener(this);
		btnCerrar_Sesión.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnCerrar_Sesión.setBounds(132, 215, 135, 35);
		contentPane.add(btnCerrar_Sesión);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar_Sesión) {

			this.dispose();
			Login L = new Login();
			L.setVisible(true);

		}
		if (e.getSource() == btnGProductos) {

			this.dispose();
			Gestion_Productos GP = new Gestion_Productos();
			GP.setVisible(true);
		}
		if (e.getSource() == btnGUsuarios) {
			this.dispose();
			Gestion_Usuarios GU = new Gestion_Usuarios();
			GU.setVisible(true);
		}

	}
}
