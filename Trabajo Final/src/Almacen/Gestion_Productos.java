package Almacen;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class Gestion_Productos extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable tablePR;
	DefaultTableModel model;
	private JButton btnRegresar;
	private JButton btnNuevo;
	private JTextField textnomprod;
	private JScrollPane scrllProdRegistrados;
	private JButton btnGuardar;
	private JButton btnEliminar;
	private JTextField textmarcprod;
	private JTextField textcatprod;
	private JTextField textpreprod;
	private JTextField textcantprod;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestion_Productos frame = new Gestion_Productos();
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
	public Gestion_Productos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 354);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(178, 34, 34));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JLabel lblUsuariosRegistrados = new JLabel("Productos Registrados");
		lblUsuariosRegistrados.setToolTipText("");
		lblUsuariosRegistrados.setForeground(new Color(175, 238, 238));
		lblUsuariosRegistrados.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblUsuariosRegistrados.setBounds(28, 10, 287, 35);
		contentPane.add(lblUsuariosRegistrados);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(this);
		btnRegresar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnRegresar.setBounds(222, 261, 169, 27);
		contentPane.add(btnRegresar);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNuevo.setBounds(38, 261, 174, 27);
		contentPane.add(btnNuevo);
		

		scrllProdRegistrados = new JScrollPane();
		scrllProdRegistrados.setBounds(38, 56, 557, 181);
		contentPane.add(scrllProdRegistrados);
		
		scrllProdRegistrados.setViewportView(tablePR);
		tablePR = new JTable();
		model = new DefaultTableModel();
		Object[] column = {"Nombre del Producto","Marca","Categoria","Precio","Cantidad de Producto"};
		Object[] row = new Object[5];
		model.setColumnIdentifiers(column);
		tablePR.setModel(model);
		
		 try {
				
				Class.forName("com.mysql.jdbc.Driver");
					
				Connection conexion =DriverManager.getConnection("Jdbc:mysql://127.0.0.1/almacen", "root", "");
					
				Statement st = (Statement) conexion.createStatement();
					
				String sql= "SELECT * FROM gproductos";
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					
				row[0] =rs.getString(1);
				row[1] =rs.getString(2);
				row[2] =rs.getString(3);
				row[3] =rs.getString(4);
				row[4] =rs.getString(5);
				model.addRow(row);
				
				}
				
		 } catch(Exception e1) {
					
				System.out.println("NO SE CONECTA");
				e1.printStackTrace();
		 }
		scrllProdRegistrados.setViewportView(tablePR);
		
		
		textnomprod = new JTextField();
		textnomprod.setBackground(new Color(240, 248, 255));
		textnomprod.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textnomprod.setBounds(670, 56, 169, 27);
		contentPane.add(textnomprod);
		textnomprod.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnGuardar.setBounds(491, 261, 169, 27);
		contentPane.add(btnGuardar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnEliminar.setBounds(670, 261, 169, 27);
		contentPane.add(btnEliminar);
		
		textmarcprod = new JTextField();
		textmarcprod.setBackground(new Color(240, 248, 255));
		textmarcprod.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textmarcprod.setColumns(10);
		textmarcprod.setBounds(670, 94, 169, 27);
		contentPane.add(textmarcprod);
		
		textcatprod = new JTextField();
		textcatprod.setBackground(new Color(240, 248, 255));
		textcatprod.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textcatprod.setColumns(10);
		textcatprod.setBounds(670, 132, 169, 27);
		contentPane.add(textcatprod);
		
		textpreprod = new JTextField();
		textpreprod.setBackground(new Color(240, 248, 255));
		textpreprod.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textpreprod.setColumns(10);
		textpreprod.setBounds(670, 170, 169, 27);
		contentPane.add(textpreprod);
		
		textcantprod = new JTextField();
		textcantprod.setBackground(new Color(240, 248, 255));
		textcantprod.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textcantprod.setColumns(10);
		textcantprod.setBounds(670, 208, 169, 27);
		contentPane.add(textcantprod);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(175, 238, 238));
		lblNombre.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNombre.setBounds(605, 56, 55, 28);
		contentPane.add(lblNombre);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setForeground(new Color(175, 238, 238));
		lblMarca.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblMarca.setBounds(605, 93, 55, 28);
		contentPane.add(lblMarca);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setForeground(new Color(175, 238, 238));
		lblCategoria.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCategoria.setBounds(596, 131, 64, 28);
		contentPane.add(lblCategoria);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setForeground(new Color(175, 238, 238));
		lblPrecio.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPrecio.setBounds(605, 169, 55, 28);
		contentPane.add(lblPrecio);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setForeground(new Color(175, 238, 238));
		lblCantidad.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCantidad.setBounds(596, 209, 64, 28);
		contentPane.add(lblCantidad);}
	
	public void Mostrar () {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Nombre");
		model.addColumn("Marca"); 
		model.addColumn("Categoria"); 
		model.addColumn("Precio"); 
		model.addColumn("Cantidad");
		tablePR.setModel(model);
		String[] row = new String[6];
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conexion =DriverManager.getConnection("Jdbc:mysql://127.0.0.1/almacen", "root", "");
		
			Statement st = (Statement) conexion.createStatement();
			
			String sql= "SELECT * FROM gproductos";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				
			row[0] =rs.getString(1);
			row[1] =rs.getString(2);
			row[2] =rs.getString(3);
			row[3] =rs.getString(4);
			row[4] =rs.getString(5);
			model.addRow(row);
			}
			tablePR.setModel(model);
			
				{JOptionPane.showMessageDialog(null,"El listado se a actualizado");}
		}catch(Exception e){
		JOptionPane.showMessageDialog(null,"No se conecto");}
		}
	public int ActualizarRegistros(String nombre, String marca,	String categoria, String precio, String cantidad) {
		int filaselct = tablePR.getSelectedRow();
		
		String sql = ("update gproductos set Marca='"+marca+"', Categoria='"+categoria+"', Precio = '"+precio+"', Cantidad = '"+cantidad+"'where Nombre = '"+nombre+"'");
		int res = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conexion =DriverManager.getConnection("Jdbc:mysql://127.0.0.1/almacen", "root", "");
				
			PreparedStatement Act = (PreparedStatement) conexion.prepareStatement(sql);
			
			res = Act.executeUpdate();
			
			if (res > 0) {
			JOptionPane.showMessageDialog(null,"El Registro se ha actualizado con exito");
			Mostrar ();}
			
		}catch(Exception e){
		System.out.println("NO SE CONECTA");
		e.printStackTrace();}
		
		return res;
	}
	public void Eliminar () {
		
		int fila = tablePR.getSelectedRow();
		String Producto= tablePR.getValueAt(fila, 0).toString();
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conexion =DriverManager.getConnection("Jdbc:mysql://127.0.0.1/almacen", "root", "");
				
			PreparedStatement st = (PreparedStatement) conexion.prepareStatement("DELETE from gproductos where nombre = '"+Producto+"'");
			
			st.executeUpdate();
			
			JOptionPane.showMessageDialog(null,"El Registro se ha eliminado con exito");
			Mostrar();
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"No se Conecto");
		}
		
	}
		
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuardar) {
			String nom = textnomprod.getText();
			String mar = textmarcprod.getText();
			String cat = textcatprod.getText();
			String pre = textpreprod.getText();
			String cant = textcantprod.getText();
			ActualizarRegistros(nom, mar, cat, pre, cant);
		}
		if (e.getSource() == btnEliminar) {
			Eliminar ();
		}
		if (e.getSource() == btnNuevo) {
			
			this.dispose();
			Registrar_Producto RP = new Registrar_Producto();
			RP.setVisible(true);
		}
		if (e.getSource() == btnRegresar) {
			
			this.dispose();
			Menu_Entrada ME = new Menu_Entrada();
			ME.setVisible(true);
		}
	}
}
