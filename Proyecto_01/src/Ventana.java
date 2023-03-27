import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ventana extends JFrame{
	
	private String anterior = "login";
	private String actual = "login";
	public JPanel panel = null;
	
	public Ventana() {
			
		this.setVisible(true);
		this.setSize(500, 600);
		this.setLocationRelativeTo(null);
		this.setTitle("Hola mundo");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.decode("#76D09A"));
		
		limpiarVentana();
		
		this.repaint();
		this.revalidate();
		
	}
	
	public void limpiarVentana() {
		
		if(panel!= null) {
			this.remove(panel);
		}
		
		if(actual.equals("login")){
			panel = login(); 
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		
		if(actual.equals("registro")){
			panel = registro();
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		if(actual.equals("menu")){
			panel = menu();
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		if(actual.equals("ayuda")){
			panel = ayuda();
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		
	}
	
	public JPanel login()
	{
		
		anterior = actual;
		actual = "login";
		
		JPanel jp1 = new JPanel();
		jp1.setSize(500, 600);
		jp1.setLocation(0, 0);
		jp1.setLayout(null);
		jp1.setBackground(Color.decode("#76D09A"));
		
		//titulo
		JLabel title = new JLabel("Accede a tu cuenta",JLabel.CENTER);
		title.setFont(new Font("Comic Sans", Font.BOLD,24));
		title.setSize(280, 40);
		title.setLocation(100, 20);
		title.setOpaque(false);
		title.setForeground(Color.white);
		//title.setBackground(Color.green);
		jp1.add(title);
		
		JLabel tag1 = new JLabel("Nombre de usuario",JLabel.LEFT);
		tag1.setFont(new Font("Comic Sans", Font.BOLD,14));
		tag1.setSize(250, 20);
		tag1.setLocation(120, 80);
		tag1.setOpaque(false);
		//tag1.setBackground(Color.black);
		tag1.setForeground(Color.white);
		jp1.add(tag1);
		
		JTextField username = new JTextField("");
		username.setSize(250, 40);
		username.setLocation(120, 100);
		jp1.add(username);
		
		JLabel tag2 = new JLabel("Contraseña de acceso",JLabel.LEFT);
		tag2.setFont(new Font("Comic Sans", Font.BOLD,14));
		tag2.setSize(250, 20);
		tag2.setLocation(120, 140);
		tag2.setOpaque(false);
		//tag2.setBackground(Color.black);
		tag2.setForeground(Color.white);
		jp1.add(tag2);
		
		JPasswordField password = new JPasswordField();
		password.setSize(250, 40);
		password.setLocation(120, 160);
		jp1.add(password);
		
		JButton btnAccess = new JButton("Iniciar Sesión");
		btnAccess.setSize(120,40);
		btnAccess.setLocation(250,205);
		btnAccess.setBackground(Color.decode("#3DADFF"));
		jp1.add(btnAccess);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setSize(120,40);
		btnCancelar.setLocation(120,205);
		btnCancelar.setBackground(Color.decode("#E48080"));
		jp1.add(btnCancelar);
		
		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				anterior = actual;
				actual = "registro";
				
				limpiarVentana();
				
			}
			
		});
		btnAccess.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				anterior = actual;
				actual = "menu";
				
				limpiarVentana();
				
			}
			
		});
		
		this.add(jp1);
		return jp1;
		
	}
	
	public JPanel menu() {
		anterior = actual;
		actual = "menu";
		
		JPanel menu = new JPanel();
		menu.setSize(500, 700);
		menu.setLocation(0, 0);
		menu.setLayout(null);
		menu.setBackground(Color.decode("#76D09A"));
		
		JMenuBar barra=new JMenuBar();
		JMenu cuenta = new JMenu("Cuenta");
		JMenu usuarios = new JMenu("Usuarios");
		JMenu ayuda = new JMenu("Ayuda");
		JMenuItem miCuenta = new JMenuItem("Mi cuenta");
		JMenuItem cerrarSesion = new JMenuItem("Cerrar sesión");

		JMenuItem listaDeUsuarios = new JMenuItem("Lista de usuarios");
		JMenuItem crearUsuario = new JMenuItem("Crear Usuario");

		JMenuItem comoCrearUsuario = new JMenuItem("¿Como crear usuarios?");
		//BARRA
		menu.add(barra);
		//MENUS
		barra.add(cuenta);
		barra.add(usuarios);
		barra.add(ayuda);
		//ITEMS
		cuenta.add(miCuenta);
		cuenta.add(cerrarSesion);
		usuarios.add(listaDeUsuarios);
		usuarios.add(crearUsuario);
		ayuda.add(comoCrearUsuario);
		
		crearUsuario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				anterior = actual;
				actual = "registro";
				
				limpiarVentana();
			}
			
		});
		comoCrearUsuario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				anterior = actual;
				actual = "ayuda";
				
				limpiarVentana();
			}
			
		});
		
		//titulo
		JLabel titleR = new JLabel("Hola Usuario",JLabel.CENTER);
		titleR.setFont(new Font("Comic Sans", Font.BOLD,20));
		titleR.setSize(280, 40);
		titleR.setLocation(100, 120);
		titleR.setOpaque(false);
		//titleR.setBackground(Color.green);
		menu.add(titleR);
		
		setJMenuBar(barra);

		return menu;
	}
public JPanel ayuda() {
		
		anterior = actual;
		actual = "ayuda";
		
		JPanel ayuda = new JPanel();
		ayuda.setSize(500, 700);
		ayuda.setLocation(0, 0);
		ayuda.setLayout(null);
		ayuda.setBackground(Color.decode("#76D09A"));
		
		//titulo
		JLabel titleR = new JLabel("¿Como crear un usuario?",JLabel.CENTER);
		titleR.setFont(new Font("Comic Sans", Font.BOLD,20));
		titleR.setSize(280, 40);
		titleR.setLocation(100, 20);
		titleR.setOpaque(false);
		titleR.setForeground(Color.white);
		//titleR.setBackground(Color.green);
		ayuda.add(titleR);
		
		JTextArea tag1R = new JTextArea("1. Hacer click en la opción ''Usuarios'' \nen el menú superior"
								+ "\n2. Haver click en la opción ''Crear Usuario'' \nen el menú desplegado"
								+ "\n3. Llenar los campos solicitados"
								+ "\n4. Hacer click en el botón ''Crear Usuario''"
								+ "\n5. Listo, el usuario se ha creado");
		tag1R.setFont(new Font("Comic Sans", Font.BOLD,14));
		tag1R.setSize(295, 150);
		tag1R.setLocation(75, 80);
		tag1R.setOpaque(false);
		//tag1R.setBackground(Color.black);
		tag1R.setForeground(Color.white);
		ayuda.add(tag1R);
		
		
		
		JButton crearAhora = new JButton("Crear un usuario ahora");
		crearAhora.setFont(new Font("Comic Sans", Font.BOLD,14));
		crearAhora.setSize(215,40);
		crearAhora.setLocation(140, 390);
		crearAhora.setBackground(Color.decode("#3DADFF"));
		ayuda.add(crearAhora);
		crearAhora.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				anterior = actual;
				actual = "registro";
				
				limpiarVentana();
				
			}
			
		});
		
		return ayuda;
	}
	public JPanel registro() {
		
		anterior = actual;
		actual = "registro";
		
		JPanel registro = new JPanel();
		registro.setSize(500, 700);
		registro.setLocation(0, 0);
		registro.setLayout(null);
		registro.setBackground(Color.decode("#76D09A"));
		
		//titulo
		JLabel titleR = new JLabel("Crear Usuario",JLabel.CENTER);
		titleR.setFont(new Font("Comic Sans", Font.BOLD,24));
		titleR.setSize(280, 40);
		titleR.setLocation(100, 20);
		titleR.setOpaque(false);
		titleR.setForeground(Color.white);
		//titleR.setBackground(Color.green);
		registro.add(titleR);
		
		JLabel tag1R = new JLabel("Nombre:",JLabel.LEFT);
		tag1R.setFont(new Font("Comic Sans", Font.BOLD,14));
		tag1R.setSize(250, 20);
		tag1R.setLocation(120, 80);
		tag1R.setOpaque(false);
		//tag1R.setBackground(Color.black);
		tag1R.setForeground(Color.white);
		registro.add(tag1R);
		
		JTextField usernameR = new JTextField("");
		usernameR.setSize(250, 40);
		usernameR.setLocation(120, 100);
		registro.add(usernameR);
		
		JLabel tag2R = new JLabel("Email:",JLabel.LEFT);
		tag2R.setFont(new Font("Comic Sans", Font.BOLD,14));
		tag2R.setSize(250, 20);
		tag2R.setLocation(120, 140);
		tag2R.setOpaque(false);
		//tag2R.setBackground(Color.black);
		tag2R.setForeground(Color.white);
		registro.add(tag2R);
		
		JPasswordField passwordR = new JPasswordField();
		passwordR.setSize(250, 40);
		passwordR.setLocation(120, 160);
		registro.add(passwordR);
		
		JLabel tag3 = new JLabel("Contraseña:",JLabel.LEFT);
		tag3.setFont(new Font("Comic Sans", Font.BOLD,14));
		tag3.setSize(250, 20);
		tag3.setLocation(120, 200);
		tag3.setOpaque(false);
		//tag3.setBackground(Color.black);
		tag3.setForeground(Color.white);
		registro.add(tag3);
		
		JTextField name = new JTextField("");
		name.setSize(250, 40);
		name.setLocation(120, 220);
		registro.add(name);
		
		JLabel tag4 = new JLabel("Confirmar contraseña:",JLabel.LEFT);
		tag4.setFont(new Font("Comic Sans", Font.BOLD,14));
		tag4.setSize(250, 20);
		tag4.setLocation(120, 260);
		tag4.setOpaque(false);
		//tag4.setBackground(Color.black);
		tag4.setForeground(Color.white);
		registro.add(tag4);
		
		JTextField lastname = new JTextField("");
		lastname.setSize(250, 40);
		lastname.setLocation(120, 280);
		registro.add(lastname);
		
		JButton crear = new JButton("Crear Usuario");
		crear.setSize(115,40);
		crear.setLocation(255, 390);
		crear.setBackground(Color.decode("#3DADFF"));
		registro.add(crear);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.setSize(115,40);
		cancelar.setLocation(120, 390);
		cancelar.setBackground(Color.decode("#E48080"));
		registro.add(cancelar);
		
		cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				anterior = actual;
				actual = "menu";
				
				limpiarVentana();
				
			}
			
		});
		
		crear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				anterior = actual;
				actual = "menu";
				
				limpiarVentana();
				
			}
			
		});
		
		return registro;
	}
}