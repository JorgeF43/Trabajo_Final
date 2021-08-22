package Almacen;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class Registrar_Producto  extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Component C = null;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textMarca;
	private JTextField textCategoria;
	private JTextField textPrecio;
	private JTextField textCantProducto;
	private JButton btnGuardar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrar_Producto frame = new Registrar_Producto();
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
	public Registrar_Producto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 310);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(178, 34, 34));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistroDeUsuarios = new JLabel("Registro de Producto");
		lblRegistroDeUsuarios.setToolTipText("");
		lblRegistroDeUsuarios.setForeground(new Color(175, 238, 238));
		lblRegistroDeUsuarios.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblRegistroDeUsuarios.setBounds(10, 11, 424, 39);
		contentPane.add(lblRegistroDeUsuarios);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textNombre.setColumns(10);
		textNombre.setBackground(new Color(240, 248, 255));
		textNombre.setBounds(10, 94, 197, 28);
		contentPane.add(textNombre);
		
		textMarca = new JTextField();
		textMarca.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textMarca.setColumns(10);
		textMarca.setBackground(new Color(240, 248, 255));
		textMarca.setBounds(10, 161, 197, 28);
		contentPane.add(textMarca);
		
		textCategoria = new JTextField();
		textCategoria.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textCategoria.setColumns(10);
		textCategoria.setBackground(new Color(240, 248, 255));
		textCategoria.setBounds(10, 222, 197, 28);
		contentPane.add(textCategoria);
		
		textPrecio = new JTextField();
		textPrecio.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textPrecio.setColumns(10);
		textPrecio.setBackground(new Color(240, 248, 255));
		textPrecio.setBounds(277, 94, 197, 28);
		contentPane.add(textPrecio);
		
		textCantProducto = new JTextField();
		textCantProducto.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textCantProducto.setColumns(10);
		textCantProducto.setBackground(new Color(240, 248, 255));
		textCantProducto.setBounds(277, 161, 197, 28);
		contentPane.add(textCantProducto);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(175, 238, 238));
		lblNombre.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNombre.setBounds(10, 68, 74, 28);
		contentPane.add(lblNombre);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setForeground(new Color(175, 238, 238));
		lblMarca.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblMarca.setBounds(10, 139, 74, 28);
		contentPane.add(lblMarca);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setForeground(new Color(175, 238, 238));
		lblCategoria.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCategoria.setBounds(10, 200, 74, 28);
		contentPane.add(lblCategoria);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setForeground(new Color(175, 238, 238));
		lblPrecio.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPrecio.setBounds(277, 68, 74, 28);
		contentPane.add(lblPrecio);
		
		JLabel lblCantidadDeProducto = new JLabel("Cantidad de Producto");
		lblCantidadDeProducto.setForeground(new Color(175, 238, 238));
		lblCantidadDeProducto.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCantidadDeProducto.setBounds(277, 139, 141, 28);
		contentPane.add(lblCantidadDeProducto);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnGuardar.setBounds(328, 222, 106, 28);
		contentPane.add(btnGuardar);
		
	}
	
	public void actionPerformed(ActionEvent e) {
			 String nombre = textNombre.getText();
			 String marca = textMarca.getText();
			 String categoria = textCategoria.getText();
			 String precio = textPrecio.getText();
			 String cantproducto = textCantProducto.getText();
			 
	 		 
			 try {
					// Conexión 
					
					Class.forName("com.mysql.jdbc.Driver");
					
					//Conexión con la bd
					
					Connection conexion =DriverManager.getConnection("Jdbc:mysql://127.0.0.1/almacen", "root", "");
					
					String query = ("INSERT INTO GProductos(nombre,marca,categoria,precio,cantidad) VALUES "
							+ "('"+nombre+"','"+marca+"','"+categoria+"','"+precio+"','"+cantproducto+"')");
					
					Statement st = (Statement) conexion.createStatement();
					
					
					
					//condicionales
					
					if(textNombre.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null,"Todos los Campos son obligatorios. \r\n" + "Campo Faltante: Nombre","Error de Registro", JOptionPane.ERROR_MESSAGE);}
					else if(textMarca.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null,"Todos los Campos son obligatorios. \r\n" + "Campo Faltante: Marca","Error de Registro", JOptionPane.ERROR_MESSAGE);}
					else if(textCategoria.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null,"Todos los Campos son obligatorios. \r\n" + "Campo Faltante: Categoria","Error de Registro", JOptionPane.ERROR_MESSAGE);}
					else if(textPrecio.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null,"Todos los Campos son obligatorios. \r\n" + "Campo Faltante: Precio","Error de Registro", JOptionPane.ERROR_MESSAGE);}
					else if(textCantProducto.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null,"Todos los Campos son obligatorios. \r\n" + "Campo Faltante: Cantidad de Producto","Error de Registro", JOptionPane.ERROR_MESSAGE);}
		
					else {
						st.executeUpdate(query);
						JOptionPane.showMessageDialog(C,"Los datos han sido guardados con éxito");
						
						this.dispose();
						Gestion_Productos GP = new Gestion_Productos();
						GP.setVisible(true);
					}
						conexion.close();
					
				} catch(Exception e1) {
					
					System.out.println("NO SE CONECTA");
					e1.printStackTrace();
					
				}
			 
		 }
		

}
