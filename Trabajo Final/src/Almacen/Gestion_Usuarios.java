package Almacen;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Gestion_Usuarios extends JFrame implements ActionListener {

	private JPanel contentPane;
	DefaultTableModel model;
	private JTable tableUS;
	private JScrollPane scrollRegistros;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JTextField textUsu;
	private JTextField textnom;
	private JTextField textape;
	private JTextField textnum;
	private JTextField textcorr;
	private JLabel lblNombreDeUsuario;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblNumTelefono;
	private JLabel lblCorreoElectronico;
	private JButton btnRegresar2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestion_Usuarios frame = new Gestion_Usuarios();
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
	public Gestion_Usuarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 883, 436);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(178, 34, 34));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblUsuariosRegistrados = new JLabel("Usuarios Registrados");
		lblUsuariosRegistrados.setBounds(10, 11, 424, 39);
		lblUsuariosRegistrados.setToolTipText("");
		lblUsuariosRegistrados.setForeground(new Color(175, 238, 238));
		lblUsuariosRegistrados.setFont(new Font("Times New Roman", Font.BOLD, 35));
		contentPane.add(lblUsuariosRegistrados);
		
		
				

		scrollRegistros = new JScrollPane();
		scrollRegistros.setBounds(20, 61, 606, 224);
		contentPane.add(scrollRegistros);
		
		scrollRegistros.setViewportView(tableUS);
		tableUS = new JTable();
		model = new DefaultTableModel();
		Object[] column = {"Nombre de Usuario","Nombre", "Apellido", "Número de Teléfono", "Correo Electrónico"};
		Object[] row = new Object[6];
		model.setColumnIdentifiers(column);
		tableUS.setModel(model);
		
		 try {
				
				Class.forName("com.mysql.jdbc.Driver");
					
				Connection conexion =DriverManager.getConnection("Jdbc:mysql://127.0.0.1/almacen", "root", "");
					
				Statement st = (Statement) conexion.createStatement();
					
				String sql= "SELECT * FROM gusuarios";
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					
				row[0] =rs.getString(1);
				row[1] =rs.getString(3);
				row[2] =rs.getString(4);
				row[3] =rs.getString(5);
				row[4] =rs.getString(6);
				model.addRow(row);
				
				}
				
		 } catch(Exception e1) {
					
				System.out.println("NO SE CONECTA");
				e1.printStackTrace();
		 }
		 
		
		scrollRegistros.setViewportView(tableUS);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(239, 310, 144, 47);
		btnActualizar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(482, 310, 144, 47);
		btnEliminar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(btnEliminar);
		
		textUsu = new JTextField();
		textUsu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textUsu.setColumns(10);
		textUsu.setBackground(new Color(240, 248, 255));
		textUsu.setBounds(660, 71, 197, 28);
		contentPane.add(textUsu);
		
		textnom = new JTextField();
		textnom.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textnom.setColumns(10);
		textnom.setBackground(new Color(240, 248, 255));
		textnom.setBounds(660, 130, 197, 28);
		contentPane.add(textnom);
		
		textape = new JTextField();
		textape.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textape.setColumns(10);
		textape.setBackground(new Color(240, 248, 255));
		textape.setBounds(660, 190, 197, 28);
		contentPane.add(textape);
		
		textnum = new JTextField();
		textnum.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textnum.setColumns(10);
		textnum.setBackground(new Color(240, 248, 255));
		textnum.setBounds(660, 244, 197, 28);
		contentPane.add(textnum);
		
		textcorr = new JTextField();
		textcorr.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textcorr.setColumns(10);
		textcorr.setBackground(new Color(240, 248, 255));
		textcorr.setBounds(660, 295, 197, 28);
		contentPane.add(textcorr);
		
		lblNombreDeUsuario = new JLabel("Nombre de Usuario");
		lblNombreDeUsuario.setForeground(new Color(175, 238, 238));
		lblNombreDeUsuario.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNombreDeUsuario.setBounds(660, 49, 128, 27);
		contentPane.add(lblNombreDeUsuario);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(175, 238, 238));
		lblNombre.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNombre.setBounds(660, 110, 55, 28);
		contentPane.add(lblNombre);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(new Color(175, 238, 238));
		lblApellido.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblApellido.setBounds(660, 166, 85, 28);
		contentPane.add(lblApellido);
		
		lblNumTelefono = new JLabel("Numero de Telefono");
		lblNumTelefono.setForeground(new Color(175, 238, 238));
		lblNumTelefono.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNumTelefono.setBounds(660, 218, 177, 28);
		contentPane.add(lblNumTelefono);
		
		lblCorreoElectronico = new JLabel("Correo Electronico");
		lblCorreoElectronico.setForeground(new Color(175, 238, 238));
		lblCorreoElectronico.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCorreoElectronico.setBounds(660, 272, 138, 28);
		contentPane.add(lblCorreoElectronico);
		
		btnRegresar2 = new JButton("Regresar");
		btnRegresar2.addActionListener(this);
		btnRegresar2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnRegresar2.setBounds(20, 310, 144, 47);
		contentPane.add(btnRegresar2);}
	
	public void Mostrar () {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Nombre de Usuario");
		model.addColumn("Nombre"); 
		model.addColumn("Apellido"); 
		model.addColumn("Número de Teléfono"); 
		model.addColumn("Correo Electrónico");
		tableUS.setModel(model);
		String[] row = new String[6];
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conexion =DriverManager.getConnection("Jdbc:mysql://127.0.0.1/almacen", "root", "");
		
			Statement st = (Statement) conexion.createStatement();
			
			String sql= "SELECT * FROM gusuarios";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				
			row[0] =rs.getString(1);
			row[1] =rs.getString(3);
			row[2] =rs.getString(4);
			row[3] =rs.getString(5);
			row[4] =rs.getString(6);
			model.addRow(row);
			}
			tableUS.setModel(model);
			
				{JOptionPane.showMessageDialog(null,"El listado se a actualizado");}
		}catch(Exception e){
			{JOptionPane.showMessageDialog(null,"No se conecto");}
		}
		
	}
	public void Eliminar () {
		
		int fila = tableUS.getSelectedRow();
		String Registro = tableUS.getValueAt(fila, 0).toString();
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conexion =DriverManager.getConnection("Jdbc:mysql://127.0.0.1/almacen", "root", "");
				
			PreparedStatement st = (PreparedStatement) conexion.prepareStatement("DELETE from gusuarios where nom_usuario= '"+Registro+"'");
			
			st.executeUpdate();
			
			JOptionPane.showMessageDialog(null,"El Registro se ha eliminado con exito");
			Mostrar ();
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"No se Conecto");
		}
		
	}	public int ActualizarRegistros(String usuario, String nombre, String apellido, String numero, String correo) {
		
		int filaselct = tableUS.getSelectedRow();
		
		String sql = ("update gusuarios set nombre='"+nombre+"', apellido='"+apellido+"', num_telefono='"+numero+"', correo_electronio='"+correo+"'where nom_usuario = '"+usuario+"'");
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
		
		return res;}

	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegresar2) {
			this.dispose();
			Menu_Entrada ME = new Menu_Entrada();
			ME.setVisible(true);
	
		}
		if (e.getSource() == btnEliminar) {
			Eliminar ();

				}
		
		if (e.getSource() == btnActualizar) {
			String usu = textUsu.getText();
			String nom = textnom.getText();
			String apel = textape.getText();
			String num = textnum.getText();
			String corr = textcorr.getText();
			ActualizarRegistros(usu, nom, apel, num, corr);
			
		}
		}

	}
