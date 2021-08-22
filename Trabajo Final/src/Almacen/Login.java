/*Abstracción*/
package Almacen; 
 
import java.sql.*; 
import java.awt.BorderLayout; 
import java.awt.EventQueue; 
 
import javax.swing.JFrame; 
import javax.swing.JPanel; 
import javax.swing.border.EmptyBorder; 
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor; 
import javax.swing.UIManager; 
import javax.swing.JLabel; 
import javax.swing.JOptionPane; 
 
import java.awt.Font; 
import javax.swing.JTextField; 
import javax.swing.JPasswordField; 
import javax.swing.JButton; 
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent; 
/* Herencia*/
public class Login extends JFrame implements ActionListener { 
 

private JPanel contentPane; 
 private JTextField textUsuario; 
 private JPasswordField passContraseña; 
 private JButton btnIniciarSesión; 
 private JButton btnRegistrase;
 
 /** 
  * Launch the application. 
  */ 
 public static void main(String[] args) { 
  EventQueue.invokeLater(new Runnable() { 
   public void run() { 
    try { 
    	Login frame = new Login(); 
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
 public Login() { 
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  setBounds(100, 100, 329, 315); 
  contentPane = new JPanel(); 
  contentPane.setBackground(new Color(178, 34, 34)); 
  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); 
  setContentPane(contentPane); 
  contentPane.setLayout(null); 
   
  JLabel lblLogin = new JLabel("Inicio de Sesi\u00F3n"); 
  lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 25)); 
  lblLogin.setForeground(new Color(175, 238, 238)); 
  lblLogin.setBounds(10, 11, 177, 53); 
  contentPane.add(lblLogin); 
   
  JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario"); 
  lblNombreDeUsuario.setForeground(new Color(175, 238, 238)); 
  lblNombreDeUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 15)); 
  lblNombreDeUsuario.setBounds(10, 75, 123, 28); 
  contentPane.add(lblNombreDeUsuario); 
   
  JLabel lblContraseña = new JLabel("Contrase\u00F1a"); 
  lblContraseña.setForeground(new Color(175, 238, 238)); 
  lblContraseña.setFont(new Font("Times New Roman", Font.PLAIN, 15)); 
  lblContraseña.setBounds(10, 142, 177, 28); 
  contentPane.add(lblContraseña); 
   
  textUsuario = new JTextField(""); 
  textUsuario.setBackground(new Color(240, 248, 255)); 
  textUsuario.setColumns(10); 
  textUsuario.setBounds(10, 103, 197, 28); 
  contentPane.add(textUsuario); 
   
  passContraseña = new JPasswordField(""); 
  passContraseña.setBackground(new Color(240, 248, 255)); 
  passContraseña.setBounds(10, 165, 197, 28); 
  contentPane.add(passContraseña); 
   
  btnRegistrase = new JButton("Registrarse"); 
  btnRegistrase.addActionListener(this);
  btnRegistrase.setFont(new Font("Times New Roman", Font.BOLD, 12)); 
  btnRegistrase.setBounds(10, 216, 107, 35); 
  contentPane.add(btnRegistrase); 
   
  btnIniciarSesión = new JButton("Iniciar Sesi\u00F3n"); 
  btnIniciarSesión.addActionListener(this); 
  btnIniciarSesión.setFont(new Font("Times New Roman", Font.BOLD, 12)); 
  btnIniciarSesión.setBounds(127, 216, 116, 35); 
  contentPane.add(btnIniciarSesión); 
 } 
 /*Encapsulamiento*/
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrase) {
			
			this.dispose();
			Registros R = new Registros();
			R.setVisible(true);
		}
		if (e.getSource() == btnIniciarSesión) {
		String usuario = textUsuario.getText();
		 String contra = passContraseña.getText();
		 
		 
		 
		 try {			
				
			// Conexión 
				
			Class.forName("com.mysql.jdbc.Driver");
				
			//Conexión con la bd
				
			Connection conexion =DriverManager.getConnection("Jdbc:mysql://127.0.0.1/almacen", "root", "");
				
			Statement st = (Statement) conexion.createStatement();
				
			//Consulta de la bd
				
			String sql= "SELECT * FROM gusuarios where nom_usuario = '"+textUsuario.getText()+"' and contraseña = '"+passContraseña.getText().toString()+"'";
			ResultSet rs = st.executeQuery(sql);
				


			//condicionales
				
			if(textUsuario.getText().isEmpty() && passContraseña.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null,"Debe ingresar su usuario y contraseña,\r\n"
						+ "si no está registrado debe registrarse","Error de Inicio", JOptionPane.ERROR_MESSAGE);
			}else if(passContraseña.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null,"Debe ingresar su Contraseña");
				
			}else if(rs.next()) {
				JOptionPane.showMessageDialog(null,"Ha iniciado sesion con éxito");
				
				this.dispose();
				/*Polimorfismo*/
				Menu_Entrada M = new Menu_Entrada();
				M.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null,"Datos Erroneos","Error de Inicio", JOptionPane.ERROR_MESSAGE);
				
			}
			conexion.close();
				
				
			} catch(Exception e1) {
				
				System.out.println("NO SE CONECTA");
				e1.printStackTrace();
				
			}
		 
	 }
	}
	}