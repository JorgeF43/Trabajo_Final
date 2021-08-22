/*Abstracci�n*/
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
 private JPasswordField passContrase�a; 
 private JButton btnIniciarSesi�n; 
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
   
  JLabel lblContrase�a = new JLabel("Contrase\u00F1a"); 
  lblContrase�a.setForeground(new Color(175, 238, 238)); 
  lblContrase�a.setFont(new Font("Times New Roman", Font.PLAIN, 15)); 
  lblContrase�a.setBounds(10, 142, 177, 28); 
  contentPane.add(lblContrase�a); 
   
  textUsuario = new JTextField(""); 
  textUsuario.setBackground(new Color(240, 248, 255)); 
  textUsuario.setColumns(10); 
  textUsuario.setBounds(10, 103, 197, 28); 
  contentPane.add(textUsuario); 
   
  passContrase�a = new JPasswordField(""); 
  passContrase�a.setBackground(new Color(240, 248, 255)); 
  passContrase�a.setBounds(10, 165, 197, 28); 
  contentPane.add(passContrase�a); 
   
  btnRegistrase = new JButton("Registrarse"); 
  btnRegistrase.addActionListener(this);
  btnRegistrase.setFont(new Font("Times New Roman", Font.BOLD, 12)); 
  btnRegistrase.setBounds(10, 216, 107, 35); 
  contentPane.add(btnRegistrase); 
   
  btnIniciarSesi�n = new JButton("Iniciar Sesi\u00F3n"); 
  btnIniciarSesi�n.addActionListener(this); 
  btnIniciarSesi�n.setFont(new Font("Times New Roman", Font.BOLD, 12)); 
  btnIniciarSesi�n.setBounds(127, 216, 116, 35); 
  contentPane.add(btnIniciarSesi�n); 
 } 
 /*Encapsulamiento*/
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrase) {
			
			this.dispose();
			Registros R = new Registros();
			R.setVisible(true);
		}
		if (e.getSource() == btnIniciarSesi�n) {
		String usuario = textUsuario.getText();
		 String contra = passContrase�a.getText();
		 
		 
		 
		 try {			
				
			// Conexi�n 
				
			Class.forName("com.mysql.jdbc.Driver");
				
			//Conexi�n con la bd
				
			Connection conexion =DriverManager.getConnection("Jdbc:mysql://127.0.0.1/almacen", "root", "");
				
			Statement st = (Statement) conexion.createStatement();
				
			//Consulta de la bd
				
			String sql= "SELECT * FROM gusuarios where nom_usuario = '"+textUsuario.getText()+"' and contrase�a = '"+passContrase�a.getText().toString()+"'";
			ResultSet rs = st.executeQuery(sql);
				


			//condicionales
				
			if(textUsuario.getText().isEmpty() && passContrase�a.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null,"Debe ingresar su usuario y contrase�a,\r\n"
						+ "si no est� registrado debe registrarse","Error de Inicio", JOptionPane.ERROR_MESSAGE);
			}else if(passContrase�a.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null,"Debe ingresar su Contrase�a");
				
			}else if(rs.next()) {
				JOptionPane.showMessageDialog(null,"Ha iniciado sesion con �xito");
				
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