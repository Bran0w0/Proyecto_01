import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Ventana extends JFrame{
	
	private String anterior = "login";
	private String actual = "login";
	public JPanel panel = null;
	public JScrollPane sp = new JScrollPane();
	public boolean sesion = true;
	public String usuario = "";
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
 	public void timer() {
 		
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
		if(actual.equals("listaUsuarios")){
			panel = listaUsuarios();
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		if(actual.equals("miCuenta")){
			panel = miCuenta();
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		
	}
	
	public void confirmarLogin(String email,String pwd) {
		//------------------------------------------------------------------------------------------------------------------------------------
						
						BufferedReader reader;
						
						Boolean flag = false; 
						
						try{
							
							FileReader file = new FileReader("users.txt");
							reader = new BufferedReader(file);
							
							String line = reader.readLine();
							
							while(line != null) {
								
								String data [] = line.split(",");
								 
								if( email.equals(data[2]) ) {
									if( pwd.equals(data[3]) ) {
										flag = true;
									}
								} 
								
								line = reader.readLine();
								
							}
							
							if(flag) {
								JOptionPane.showMessageDialog(null,"Bienvenido "+email,"Correcto", JOptionPane.INFORMATION_MESSAGE );

								anterior = actual;
								actual = "menu";
								
								limpiarVentana();
								
								repaint();
								revalidate();
								
								
							}else {
								JOptionPane.showMessageDialog(null,"El usuario y contraseña no coinciden","Error", JOptionPane.ERROR_MESSAGE );
							}
							
							
						} catch(IOException e1) {
							e1.printStackTrace();
						}
					
				//------------------------------------------------------------------------------------------------------------------------------------

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
		JTextField username = new JTextField();
		JPasswordField password = new JPasswordField();

		
		
		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				sesion = false;
				if(sesion == false) {
					username.setText("");
					username.setSize(250, 40);
					username.setLocation(120, 100);
					jp1.add(username);
					
					password.setText("");
					password.setSize(250, 40);
					password.setLocation(120, 160);
					jp1.add(password);

					jp1.repaint();
					jp1.revalidate();
					}
			}
		});

		if(sesion == true) {
			username.setText("1@");
			username.setSize(250, 40);
			username.setLocation(120, 100);
			jp1.add(username);
			
			password.setText("1");
			password.setSize(250, 40);
			password.setLocation(120, 160);
			jp1.add(password);
			
			jp1.repaint();
			jp1.revalidate();

			btnAccess.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String email = username.getText();
					String pwd = new String (password.getPassword());
					
					confirmarLogin(email,pwd);
					jp1.repaint();
					jp1.revalidate();
				}
			});
		}
		
		if(sesion == false) {
			username.setText("");
			username.setSize(250, 40);
			username.setLocation(120, 100);
			jp1.add(username);
			
			password.setText("");
			password.setSize(250, 40);
			password.setLocation(120, 160);
			jp1.add(password);
			btnAccess.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String email = username.getText();
					String pwd = new String (password.getPassword());
					
					confirmarLogin(email,pwd);
					jp1.repaint();
					jp1.revalidate();
				}
			});
			}
		usuario = username.getText();
		JLabel tag2 = new JLabel("Contraseña de acceso",JLabel.LEFT);
		tag2.setFont(new Font("Comic Sans", Font.BOLD,14));
		tag2.setSize(250, 20);
		tag2.setLocation(120, 140);
		tag2.setOpaque(false);
		//tag2.setBackground(Color.black);
		tag2.setForeground(Color.white);
		jp1.add(tag2);
		
		jp1.repaint();
		jp1.revalidate();
				
		this.add(jp1);
		return jp1;
		
	}
	
	public void  barra() {
		
		
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
		
		cerrarSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				anterior = actual;
				actual = "login";
				
				limpiarVentana();
			}
			
		});
		
		miCuenta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				anterior = actual;
				actual = "miCuenta";
				
				limpiarVentana();
			}
			
		});
		
		listaDeUsuarios.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				anterior = actual;
				actual = "listaUsuarios";
				
				limpiarVentana();
			}
			
		});
		
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
		
		setJMenuBar(barra);

	}
	
	public JPanel menu() {
		anterior = actual;
		actual = "menu";
		
		JPanel menu = new JPanel();
		menu.setSize(500, 700);
		menu.setLocation(0, 0);
		menu.setLayout(null);
		menu.setBackground(Color.decode("#76D09A"));
		
		barra();
		
		//titulo
		JLabel titleR = new JLabel("Hola Usuario",JLabel.CENTER);
		titleR.setFont(new Font("Comic Sans", Font.BOLD,20));
		titleR.setSize(280, 40);
		titleR.setLocation(100, 120);
		titleR.setOpaque(false);
		//titleR.setBackground(Color.green);
		menu.add(titleR);
		

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
		
		//barra();
		
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
	
	public JPanel miCuenta() {
		
		anterior = actual;
		actual = "miCuenta";
		
		JPanel miCuenta = new JPanel();
		miCuenta.setSize(500, 700);
		miCuenta.setLocation(0, 0);
		miCuenta.setLayout(null);
		miCuenta.setBackground(Color.decode("#76D09A"));
		
		//titulo
		JLabel titleR = new JLabel("Mi cuenta personal",JLabel.CENTER);
		titleR.setFont(new Font("Comic Sans", Font.BOLD,24));
		titleR.setSize(280, 40);
		titleR.setLocation(100, 20);
		titleR.setOpaque(false);
		titleR.setForeground(Color.white);
		//titleR.setBackground(Color.green);
		miCuenta.add(titleR);
		
		//REQUISITOS
		JLabel nombre = new JLabel("Nombre:",JLabel.LEFT);
		nombre.setFont(new Font("Comic Sans", Font.BOLD,18));
		nombre.setSize(280, 40);
		nombre.setLocation(60, 160);
		nombre.setOpaque(false);
		nombre.setForeground(Color.white);
		//titleR.setBackground(Color.green);
		miCuenta.add(nombre);
		
		JTextField nombreT = new JTextField("");
		nombreT.setSize(360, 25);
		nombreT.setLocation(60, 200);
		miCuenta.add(nombreT);
		
		JLabel apellidos = new JLabel("Apellidos:",JLabel.LEFT);
		apellidos.setFont(new Font("Comic Sans", Font.BOLD,18));
		apellidos.setSize(360, 40);
		apellidos.setLocation(60, 230);
		apellidos.setOpaque(false);
		apellidos.setForeground(Color.white);
		//titleR.setBackground(Color.green);
		miCuenta.add(apellidos);
		
		JTextField apellidosT = new JTextField("");
		apellidosT.setSize(360, 25);
		apellidosT.setLocation(60, 270);
		miCuenta.add(apellidosT);
		
		JLabel email = new JLabel("Email:",JLabel.LEFT);
		email.setFont(new Font("Comic Sans", Font.BOLD,18));
		email.setSize(360, 40);
		email.setLocation(60, 300);
		email.setOpaque(false);
		email.setForeground(Color.white);
		//titleR.setBackground(Color.green);
		miCuenta.add(email);
		
		JTextField emailT = new JTextField("");
		emailT.setSize(360, 25);
		emailT.setLocation(60, 340);
		miCuenta.add(emailT);

		JLabel contraseña = new JLabel("Contraseña:",JLabel.LEFT);
		contraseña.setFont(new Font("Comic Sans", Font.BOLD,18));
		contraseña.setSize(360, 40);
		contraseña.setLocation(60, 370);
		contraseña.setOpaque(false);
		contraseña.setForeground(Color.white);
		//titleR.setBackground(Color.green);
		miCuenta.add(contraseña);
		
		JTextField contraseñaT = new JTextField("");
		contraseñaT.setSize(360, 25);
		contraseñaT.setLocation(60, 410);
		miCuenta.add(contraseñaT);
		
		JButton actualizar = new JButton("Actualizar datos");
		actualizar.setFont(new Font("Comic Sans", Font.BOLD,14));
		actualizar.setSize(200,35);
		actualizar.setLocation(255, 450);
		actualizar.setBackground(Color.decode("#3DADFF"));
		actualizar.setForeground(Color.decode("#FFFFFF"));
		miCuenta.add(actualizar);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.setFont(new Font("Comic Sans", Font.BOLD,14));
		cancelar.setSize(200,35);
		cancelar.setLocation(35, 450);
		cancelar.setBackground(Color.decode("#E48080"));
		cancelar.setForeground(Color.decode("#FFFFFF"));
		miCuenta.add(cancelar);
		
		actualizar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			JOptionPane.showMessageDialog(null, "La información no se ha podido actualizar","Error",JOptionPane.INFORMATION_MESSAGE );

				
			}
			
		});
		
		
		cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				anterior = actual;
				actual = "menu";
				
				limpiarVentana();
				
			}
			
		});
		
		
		return miCuenta;
	}
	
	public JPanel listaUsuarios() {
		
		anterior = actual;
		actual = "listaUsuarios";
		
		JPanel listaUsuarios = new JPanel();
		listaUsuarios.setSize(500, 700);
		listaUsuarios.setLocation(0, 0);
		listaUsuarios.setLayout(null);
		listaUsuarios.setBackground(Color.decode("#76D09A"));
		
		//titulo
		JLabel titleR = new JLabel("Lista de usuarios",JLabel.CENTER);
		titleR.setFont(new Font("Comic Sans", Font.BOLD,24));
		titleR.setSize(280, 40);
		titleR.setLocation(100, 20);
		titleR.setOpaque(false);
		titleR.setForeground(Color.white);
		//titleR.setBackground(Color.green);
		listaUsuarios.add(titleR);
		
		//SUBTITULO
		JLabel titleS = new JLabel("Editar",JLabel.LEFT);
		titleS.setFont(new Font("Comic Sans", Font.BOLD,18));
		titleS.setSize(280, 40);
		titleS.setLocation(80, 60);
		titleS.setOpaque(false);
		titleS.setForeground(Color.white);
		//titleR.setBackground(Color.green);
		listaUsuarios.add(titleS);
		
		JButton crear = new JButton("Editar a ''Usuario''"+);
		crear.setFont(new Font("Comic Sans", Font.BOLD,14));
		crear.setSize(320, 25);
		crear.setLocation(80, 150);
		crear.setBackground(Color.decode("#31C148"));
		crear.setForeground(Color.decode("#FFFFFF"));
		listaUsuarios.add(crear);
		
		JButton cancelar = new JButton("Borrar");
		cancelar.setSize(115,40);
		cancelar.setLocation(180, 430);
		cancelar.setBackground(Color.decode("#E48080"));
		listaUsuarios.add(cancelar);
		
		cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				anterior = actual;
				actual = "menu";
				
				limpiarVentana();
				
			}
			
		});
		
		String [] datos = {};
		String emailG[] = new String [10];
		String a;

		//----------------------------------------------------------------------------

		String[] columnNames = { "Nombre", "Apellido", "Correo", "Password" };
		
		String[][] data = new String[10][4]; 
		int i = 0;
		BufferedReader reader;  
		
		try{
			
			FileReader file = new FileReader("users.txt");
			reader = new BufferedReader(file);
			
			String line = reader.readLine();
			
			while(line != null) {
				
				String arreglo [] = line.split(",");
				datos = arreglo;

				
				
				data[i] = arreglo;
				
				line = reader.readLine();
				i++;
				
			}
			int h=0;
			for (int f =0; f<10;f++) {
				if(data[f][2]!=null) {
				 a = data[f][2];
				/* if(a.contains("@")) {
					 emailG[h]=data[f][2];
						h++; 
				 }*/
				//emailG[0]=a;
				emailG[h]=a;
				System.out.println(emailG);
				System.out.println(a);}
				h++;
			}

			 
			 JTable j = new JTable(data, columnNames);
	         j.setBounds(30, 40, 200, 300);
	 
	         JScrollPane sp = new JScrollPane(j);
	         sp.setSize(320, 200);
	         sp.setLocation(80, 195);
	         listaUsuarios.add(sp);
	         
	         listaUsuarios.repaint();
	         listaUsuarios.revalidate();
		} catch(IOException e1) {
			e1.printStackTrace();
		} 		

	/*	for(int l=0;l <datos.length;l++) {
			System.out.println(emailG[l]);
		}*/
		
		JComboBox lista = new JComboBox(emailG);
		lista.setBounds(80, 100,320, 40);
		listaUsuarios.add(lista);

         
         listaUsuarios.repaint();
         listaUsuarios.revalidate();
 		//----------------------------------------------------------------------------

		
		
		
		return listaUsuarios;
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
		
		JLabel nombre = new JLabel("Nombre:",JLabel.LEFT);
		nombre.setFont(new Font("Comic Sans", Font.BOLD,14));
		nombre.setSize(250, 20);
		nombre.setLocation(120, 90);
		nombre.setOpaque(false);
		//tag1R.setBackground(Color.black);
		nombre.setForeground(Color.white);
		registro.add(nombre);
		
		JTextField nombreT = new JTextField("");
		nombreT.setSize(250, 25);
		nombreT.setLocation(120, 110);
		registro.add(nombreT);
		
		JLabel apellido = new JLabel("Apellido:",JLabel.LEFT);
		apellido.setFont(new Font("Comic Sans", Font.BOLD,14));
		apellido.setSize(250, 20);
		apellido.setLocation(120, 140);
		apellido.setOpaque(false);
		//tag1R.setBackground(Color.black);
		apellido.setForeground(Color.white);
		registro.add(apellido);
		
		JTextField apellidoT = new JTextField("");
		apellidoT.setSize(250, 25);
		apellidoT.setLocation(120, 160);
		registro.add(apellidoT);
		
		JLabel email = new JLabel("Email:",JLabel.LEFT);
		email.setFont(new Font("Comic Sans", Font.BOLD,14));
		email.setSize(250, 20);
		email.setLocation(120, 190);
		email.setOpaque(false);
		//tag2R.setBackground(Color.black);
		email.setForeground(Color.white);
		registro.add(email);
		
		JTextField emailT = new JTextField();
		emailT.setSize(250, 25);
		emailT.setLocation(120, 210);
		registro.add(emailT);
		
		JLabel contraseña = new JLabel("Contraseña:",JLabel.LEFT);
		contraseña.setFont(new Font("Comic Sans", Font.BOLD,14));
		contraseña.setSize(250, 20);
		contraseña.setLocation(120, 240);
		contraseña.setOpaque(false);
		//tag3.setBackground(Color.black);
		contraseña.setForeground(Color.white);
		registro.add(contraseña);
		
		JPasswordField contraseñaP = new JPasswordField("");
		contraseñaP.setSize(250, 25);
		contraseñaP.setLocation(120, 260);
		registro.add(contraseñaP);
		
		JLabel confirmarContraseña = new JLabel("Confirmar contraseña:",JLabel.LEFT);
		confirmarContraseña.setFont(new Font("Comic Sans", Font.BOLD,14));
		confirmarContraseña.setSize(250, 20);
		confirmarContraseña.setLocation(120, 290);
		confirmarContraseña.setOpaque(false);
		//tag4.setBackground(Color.black);
		confirmarContraseña.setForeground(Color.white);
		registro.add(confirmarContraseña);
		
		JPasswordField confirmarContraseñaP = new JPasswordField("");
		confirmarContraseñaP.setSize(250, 25);
		confirmarContraseñaP.setLocation(120, 310);
		registro.add(confirmarContraseñaP);
		
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
		
		crear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String nombre = nombreT.getText();
				String apellido = apellidoT.getText();
				String email = emailT.getText();
				String pwd = new String(contraseñaP.getPassword());
				String pwd2 = new String(confirmarContraseñaP.getPassword());

				if((email.contains("@")&& pwd.equals(pwd2)) && !(nombre.equals("") || email.equals("") || pwd.equals("") || apellido.equals(""))) 

				{
					JOptionPane.showMessageDialog(null, "Usuario creado","Correcto",JOptionPane.INFORMATION_MESSAGE );

				FileWriter writer ;
				
				try {
					 writer = new FileWriter("users.txt",true);
					 
					 PrintWriter linea = new PrintWriter(writer);
					 
					 linea.println(nombre+","+apellido+","+email+","+pwd);  
					 
					 linea.close();
					 writer.close();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				}else {
					JOptionPane.showMessageDialog(null, "El usuario no se ha podido crear","Error" ,JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
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