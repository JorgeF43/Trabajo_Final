package Almacen;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Registros extends JFrame implements ActionListener {
	
	private static final Component C = null;
	private JPanel contentPane;
	private JTextField textNom_Usuario;
	private JTextField textCorreo_Electronico;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textNum_Telefono;
	private JButton btnRegistrarse;
	private JPasswordField passContrase�a;
	private JPasswordField passConfContrase�a;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registros frame = new Registros();
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
	public Registros() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(178, 34, 34));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistro = new JLabel("Registro");
		lblRegistro.setToolTipText("");
		lblRegistro.setForeground(new Color(175, 238, 238));
		lblRegistro.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblRegistro.setBounds(8, 11, 424, 39);
		contentPane.add(lblRegistro);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario");
		lblNombreDeUsuario.setForeground(new Color(175, 238, 238));
		lblNombreDeUsuario.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNombreDeUsuario.setBounds(10, 71, 128, 27);
		contentPane.add(lblNombreDeUsuario);
		
		textNom_Usuario = new JTextField();
		textNom_Usuario.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textNom_Usuario.setColumns(10);
		textNom_Usuario.setBackground(new Color(240, 248, 255));
		textNom_Usuario.setBounds(10, 99, 197, 28);
		contentPane.add(textNom_Usuario);
		
		JLabel lblCorreoElectronico = new JLabel("Correo Electronico");
		lblCorreoElectronico.setForeground(new Color(175, 238, 238));
		lblCorreoElectronico.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCorreoElectronico.setBounds(294, 70, 138, 28);
		contentPane.add(lblCorreoElectronico);
		
		textCorreo_Electronico = new JTextField();
		textCorreo_Electronico.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textCorreo_Electronico.setColumns(10);
		textCorreo_Electronico.setBackground(new Color(240, 248, 255));
		textCorreo_Electronico.setBounds(294, 99, 197, 28);
		contentPane.add(textCorreo_Electronico);
		
		JLabel lblContrase�a = new JLabel("Contrase\u00F1a");
		lblContrase�a.setForeground(new Color(175, 238, 238));
		lblContrase�a.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblContrase�a.setBounds(294, 138, 177, 28);
		contentPane.add(lblContrase�a);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textNombre.setColumns(10);
		textNombre.setBackground(new Color(240, 248, 255));
		textNombre.setBounds(10, 162, 197, 28);
		contentPane.add(textNombre);
		
		textApellido = new JTextField();
		textApellido.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textApellido.setColumns(10);
		textApellido.setBackground(new Color(240, 248, 255));
		textApellido.setBounds(10, 229, 197, 28);
		contentPane.add(textApellido);
		
		textNum_Telefono = new JTextField();
		textNum_Telefono.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textNum_Telefono.setColumns(10);
		textNum_Telefono.setBackground(new Color(240, 248, 255));
		textNum_Telefono.setBounds(10, 292, 197, 28);
		contentPane.add(textNum_Telefono);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(175, 238, 238));
		lblNombre.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNombre.setBounds(10, 138, 55, 28);
		contentPane.add(lblNombre);
		
		JLabel lblConfContrase�a = new JLabel("Confirmar Contrase\u00F1a");
		lblConfContrase�a.setForeground(new Color(175, 238, 238));
		lblConfContrase�a.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblConfContrase�a.setBounds(294, 201, 177, 28);
		contentPane.add(lblConfContrase�a);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(new Color(175, 238, 238));
		lblApellido.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblApellido.setBounds(10, 201, 85, 28);
		contentPane.add(lblApellido);
		
		JLabel lblNumTelefono = new JLabel("Numero de Telefono");
		lblNumTelefono.setForeground(new Color(175, 238, 238));
		lblNumTelefono.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNumTelefono.setBounds(10, 265, 177, 28);
		contentPane.add(lblNumTelefono);
		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(this);
		btnRegistrarse.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnRegistrarse.setBounds(333, 286, 113, 39);
		contentPane.add(btnRegistrarse);
		
		passContrase�a = new JPasswordField();
		passContrase�a.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		passContrase�a.setBackground(new Color(240, 248, 255));
		passContrase�a.setBounds(294, 162, 197, 28);
		contentPane.add(passContrase�a);
		
		passConfContrase�a = new JPasswordField();
		passConfContrase�a.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		passConfContrase�a.setBackground(new Color(240, 248, 255));
		passConfContrase�a.setBounds(294, 229, 197, 28);
		contentPane.add(passConfContrase�a);
	}
	public void actionPerformed(ActionEvent e) {
		String usuario = textNom_Usuario.getText();
		 String contra = passContrase�a.getText();
		 String nombre = textNombre.getText();
		 String apellido = textApellido.getText();
		 String numero = textNum_Telefono.getText();
		 String correo = textCorreo_Electronico.getText();
		 String confcontra = passConfContrase�a.getText();
		 
		 try {
				
				
				
				// Conexi�n 
				
				Class.forName("com.mysql.jdbc.Driver");
				
				//Conexi�n con la bd
				
				Connection conexion =DriverManager.getConnection("Jdbc:mysql://127.0.0.1/almacen", "root", "");
				
				Statement st = (Statement) conexion.createStatement();
				
				//Consulta de la bd
				
				String query=("INSERT INTO GUsuarios(nom_usuario,contrase�a,nombre,apellido,num_telefono,correo_electronio) VALUES "
						+ "('"+usuario+"','"+contra+"','"+nombre+"','"+apellido+"','"+numero+"','"+correo+"')");
				
				
				

				//condicionales
			if(contra.equals(confcontra)) {
					
				if(textNom_Usuario.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Todos los Campos son obligatorios. \r\n" + "Campo Faltante: Nombre de Usuario","Error de Registro", JOptionPane.ERROR_MESSAGE);}
				else if(textNombre.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Todos los Campos son obligatorios. \r\n" + "Campo Faltante: Nombre ","Error de Registro", JOptionPane.ERROR_MESSAGE);}
				else if(textApellido.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Todos los Campos son obligatorios. \r\n" + "Campo Faltante: Apellido","Error de Registro", JOptionPane.ERROR_MESSAGE);}
				else if(textNum_Telefono.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Todos los Campos son obligatorios. \r\n" + "Campo Faltante: Numero de Telefono","Error de Registro", JOptionPane.ERROR_MESSAGE);}
				else if(textCorreo_Electronico.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Todos los Campos son obligatorios. \r\n" + "Campo Faltante: Correo Electronico","Error de Registro", JOptionPane.ERROR_MESSAGE);}
				else if(passContrase�a.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Todos los Campos son obligatorios. \r\n" + "Campo Faltante: Contrase�a","Error de Registro", JOptionPane.ERROR_MESSAGE);}
				else if(passConfContrase�a.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Todos los Campos son obligatorios. \r\n" + "Campo Faltante: Confirmar Contrase�a","Error de Registro", JOptionPane.ERROR_MESSAGE);}
				else {
					st.executeUpdate(query);
					JOptionPane.showMessageDialog(C,"Los datos han sido guardados con �xito");
					
					this.dispose();
					Login L = new Login();
					L.setVisible(true);
					
					conexion.close();
					}
				}else {JOptionPane.showMessageDialog(C,"Las Contrase�as no Coinciden");}
				
				
			} catch(Exception e1) {
				
				JOptionPane.showMessageDialog(C,"Error con la base de datos: " + e1);
				e1.printStackTrace();
				
			}
		 
	 }
	}

