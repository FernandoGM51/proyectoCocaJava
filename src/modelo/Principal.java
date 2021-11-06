package modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*Implementación de la interfez principal
 * Es la app con la que el usuario va a interactuar.
 */

public class Principal extends JFrame implements ActionListener{
	private JMenuBar mb;
	private JMenu menuOpciones, menuCalcular, menuAcercaDe, menuColorFondo;
	private JMenuItem miCalculo, miRojo, miNegro, miMorado, miElCreador, miSalir, miNuevo;
	private JLabel labelLogo, labelBienvenido, labelTitle, labelNombre, labelAPaterno,
	labelAMaterno, labelDepartamento, labelAntiguedad, labelResultado, labelFooter;
	private JTextField txtNombreTrabajador, txtAPaternoTrabajador, txtAMaternoTrabajador;
	private JComboBox comboDepartamento, comboAntiguedad;
	private JScrollPane scrollPane1;
	private JTextArea textArea1;
	//vamos a crear una variable para recuperar el nombre del usuario, introducido en la
	//interfaz de bievenida. para ello creamos un obj de tipo pantallaBienvenida y lo extraemos
	//recordar que podemos hacerlo porque es una variable de tipo publica y estatica
	private String nombreAdministrador="";
	
	public Principal() {
		//titulo y fondo de la interfaz
		setLayout(null);
		//LINEA MUY IMPORTANTE. CIERRA EL PROCESO y evita que se siga ejecutando
		//en segundo plano
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Pantalla Principal");
		getContentPane().setBackground(new Color(255,0,0));
		setIconImage(new ImageIcon(getClass().getResource("images/icon.png")).getImage());
		PantallaBienvenida pb = new PantallaBienvenida();
		nombreAdministrador = pb.nombreUsuario; //listo!
		
		//barra de menu
		mb = new JMenuBar();
		mb.setBackground(new Color(255,0,0));
		setJMenuBar(mb);
		
		//pestañas
		menuOpciones = new JMenu("Opciones");
		menuOpciones.setBackground(new Color(255,0,0));
		menuOpciones.setFont(new Font("Andale Mono", 1, 14));
		menuOpciones.setForeground(new Color(255,255,255)); //color fuente
		mb.add(menuOpciones);
		
		menuCalcular = new JMenu("Calcular");
		menuCalcular.setBackground(new Color(255,0,0));
		menuCalcular.setFont(new Font("Andale Mono", 1, 14));
		menuCalcular.setForeground(new Color(255,255,255)); //color fuente
		mb.add(menuCalcular);
		
		menuAcercaDe = new JMenu("Acerca de");
		menuAcercaDe.setBackground(new Color(255,0,0));
		menuAcercaDe.setFont(new Font("Andale Mono", 1, 14));
		menuAcercaDe.setForeground(new Color(255,255,255)); //color fuente
		mb.add(menuAcercaDe);
		
		//sub pestañas o submenus
		menuColorFondo = new JMenu("Color de fondo");
		menuColorFondo.setFont(new Font("Andale Mono", 1, 14));
		menuColorFondo.setForeground(new Color(255,0,0));
		menuOpciones.add(menuColorFondo);
		
		//items de menu
		miCalculo = new JMenuItem("Vacaciones");
		miCalculo.setFont(new Font("Andale Mono",1,14));
		miCalculo.setForeground(new Color(255,0,0));
		miCalculo.addActionListener(this);
		menuCalcular.add(miCalculo);
		
		miNegro = new JMenuItem("Negro");
		miNegro.setFont(new Font("Andale Mono",1,14));
		miNegro.setForeground(new Color(255,0,0));
		miNegro.addActionListener(this);
		menuColorFondo.add(miNegro);
		
		miRojo = new JMenuItem("Rojo");
		miRojo.setFont(new Font("Andale Mono",1,14));
		miRojo.setForeground(new Color(255,0,0));
		miRojo.addActionListener(this);
		menuColorFondo.add(miRojo);
		
		miMorado = new JMenuItem("Morado");
		miMorado.setFont(new Font("Andale Mono",1,14));
		miMorado.setForeground(new Color(255,0,0));
		miMorado.addActionListener(this);
		menuColorFondo.add(miMorado);
		
		miNuevo = new JMenuItem("Nuevo");
		miNuevo.setFont(new Font("Andale Mono", 1, 14));
		miNuevo.setForeground(new Color(255,0,0));
		miNuevo.addActionListener(this);
		menuOpciones.add(miNuevo);
		
		miElCreador = new JMenuItem("Creado por...");
		miElCreador.setFont(new Font("Andale Mono", 1, 14));
		miElCreador.setForeground(new Color(255,0,0));
		miElCreador.addActionListener(this);
		menuAcercaDe.add(miElCreador);
		
		miSalir = new JMenuItem("Salir");
		miSalir.setFont(new Font("Andale Mono", 1, 14));
		miSalir.setForeground(new Color(255,0,0));
		miSalir.addActionListener(this);
		menuOpciones.add(miSalir);
		
		//ahora vamos con las labels
		ImageIcon imagen = new ImageIcon("images/logo.png");
		labelLogo = new JLabel(imagen);
		labelLogo.setBounds(5, 5, 250, 100);
		add(labelLogo);
		
		labelBienvenido = new JLabel("Bienvenido " + nombreAdministrador);
		labelBienvenido.setBounds(250, 30, 300, 50);
		labelBienvenido.setFont(new Font("Andale Mono", 1, 32));
		labelBienvenido.setForeground(new Color(255,255,255));
		add(labelBienvenido);
		
		labelTitle = new JLabel("Datos del trabajador para el cálculo de vacaciones");
		labelTitle.setBounds(45, 140, 900, 25);
		labelTitle.setFont(new Font("Andale Mono", 0, 24));
		labelTitle.setForeground(new Color(255,255,255));
		add(labelTitle);
		
		//labels y sus respectivos textFields
		labelNombre = new JLabel("Nombre completo:");
		labelNombre.setBounds(25, 188, 180, 25);
		labelNombre.setFont(new Font("Andale Mono", 1, 12));
		labelNombre.setForeground(new Color(255,255,255));
		add(labelNombre);
		
		txtNombreTrabajador = new JTextField();
		txtNombreTrabajador.setBounds(25, 213, 150, 25);
		txtNombreTrabajador.setBackground(new Color(224,224,224));
		txtNombreTrabajador.setFont(new Font("Andale Mono", 1, 14));
		txtNombreTrabajador.setForeground(new Color(255,0,0));
		add(txtNombreTrabajador);
		
		labelAPaterno = new JLabel("Apellido Paterno:");
		labelAPaterno.setBounds(25, 248, 180, 25);
		labelAPaterno.setFont(new Font("Andale Mono", 1, 12));
		labelAPaterno.setForeground(new Color(255,255,255));
		add(labelAPaterno);
		
		txtAPaternoTrabajador = new JTextField();
		txtAPaternoTrabajador.setBounds(25, 273, 150, 25);
		txtAPaternoTrabajador.setBackground(new Color(224,224,224));
		txtAPaternoTrabajador.setFont(new Font("Andale Mono", 1, 14));
		txtAPaternoTrabajador.setForeground(new Color(255,0,0));
		add(txtAPaternoTrabajador);
		
		labelAMaterno = new JLabel("Apellido Materno:");
		labelAMaterno.setBounds(25, 308, 180, 25);
		labelAMaterno.setFont(new Font("Andale Mono", 1, 12));
		labelAMaterno.setForeground(new Color(255,255,255));
		add(labelAMaterno);
		
		txtAMaternoTrabajador = new JTextField();
		txtAMaternoTrabajador.setBounds(25, 334, 150, 25);
		txtAMaternoTrabajador.setBackground(new Color(224,224,224));
		txtAMaternoTrabajador.setFont(new Font("Andale Mono", 1, 14));
		txtAMaternoTrabajador.setForeground(new Color(255,0,0));
		add(txtAMaternoTrabajador);
		
		labelDepartamento = new JLabel("Selecciona el Departamento:");
		labelDepartamento.setBounds(220, 188, 180, 25);
		labelDepartamento.setFont(new Font("Andale Mono", 1, 12));
		labelDepartamento.setForeground(new Color(255,255,255));
		add(labelDepartamento);
		
		comboDepartamento = new JComboBox();
		comboDepartamento.setBounds(220, 213, 220, 25);
		comboDepartamento.setBackground(new Color(224,224,224));
		comboDepartamento.setFont(new Font("Andale Mono", 1, 14));
		comboDepartamento.setForeground(new Color(255,0,0));
		add(comboDepartamento);
		//items del combo departamento
		comboDepartamento.addItem("");
		comboDepartamento.addItem("Atención al Cliente");
		comboDepartamento.addItem("Departamento de Logística");
		comboDepartamento.addItem("Departamento de Gerencia");
		
		labelAntiguedad = new JLabel("Selecciona la antiguedad:");
		labelAntiguedad.setBounds(220, 248, 180, 25);
		labelAntiguedad.setFont(new Font("Andale Mono", 1, 12));
		labelAntiguedad.setForeground(new Color(255,255,255));
		add(labelAntiguedad);
		
		comboAntiguedad = new JComboBox();
		comboAntiguedad.setBounds(220, 273, 220, 25);
		comboAntiguedad.setBackground(new Color(224,224,224));
		comboAntiguedad.setFont(new Font("Andale Mono", 1, 14));
		comboAntiguedad.setForeground(new Color(255,0,0));
		add(comboAntiguedad);
		//items del combo antiguedad
		comboAntiguedad.addItem("");
		comboAntiguedad.addItem("1 año de servicio");
		comboAntiguedad.addItem("2 a 6 años de servicio");
		comboAntiguedad.addItem("7 o más años de servicio");
		
		labelResultado = new JLabel("Resultado del cálculo:");
		labelResultado.setBounds(220, 307, 180, 25);
		labelResultado.setFont(new Font("Andale Mono", 1, 12));
		labelResultado.setForeground(new Color(255,255,255));
		add(labelResultado);
		
		textArea1 = new JTextArea();
		textArea1.setEditable(false);
		textArea1.setBackground(new Color(224,224,224));
		textArea1.setFont(new Font("Andale Mono", 1, 11));
		textArea1.setForeground(new Color(255,0,0));
		textArea1.setText("\n   Aquí aparece el resultado del cálculo de las vacaciones.");
		scrollPane1 = new JScrollPane(textArea1);
		scrollPane1.setBounds(220, 333, 385, 90);
		add(scrollPane1);
		
		//label footer
		labelFooter = new JLabel("©2017 The Coca-Cola Company | Todos los derechos reservados");
		labelFooter.setBounds(135, 445, 500, 30);
		labelFooter.setFont(new Font("Andale Mono", 1, 12));
		labelFooter.setForeground(new Color(255,255,255));
		add(labelFooter);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==miCalculo) {
			//creo las variables temporales que necesito usar.
			String nombreTrabajador = txtNombreTrabajador.getText();
			String apPa = txtAPaternoTrabajador.getText();
			String apMa = txtAMaternoTrabajador.getText();
			String departamento = comboDepartamento.getSelectedItem().toString();
			String antiguedad = comboAntiguedad.getSelectedItem().toString();
			//vamos a validar que no queden campos en blanco
			if(nombreTrabajador.equals("") || apPa.equals("") || apMa.equals("") || 
					departamento.equals("") || antiguedad.equals("")){
				JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
			}else {
				if(departamento.equals("Atención al Cliente")) {
					if(antiguedad.equals("1 año de servicio")) {
						textArea1.setText("\n   El trabajador "+nombreTrabajador+" "+apPa+" "+apMa+
								          "\n   quien labora en "+departamento+" con "+antiguedad+
								          "\n   recibe 6 (seis) días de vacaciones.");
					}
					if(antiguedad.equals("2 a 6 años de servicio")) {
						textArea1.setText("\n   El trabajador "+nombreTrabajador+" "+apPa+" "+apMa+
								          "\n   quien labora en "+departamento+" con "+antiguedad+
								          "\n   recibe 14 (catorce) días de vacaciones.");
					}
					if(antiguedad.equals("7 o más años de servicio")) {
						textArea1.setText("\n   El trabajador "+nombreTrabajador+" "+apPa+" "+apMa+
								          "\n   quien labora en "+departamento+" con "+antiguedad+
								          "\n   recibe 20 (veinte) días de vacaciones.");
					}
				}
				if(departamento.equals("Departamento de Logística")) {
					if(antiguedad.equals("1 año de servicio")) {
						textArea1.setText("\n   El trabajador "+nombreTrabajador+" "+apPa+" "+apMa+
								          "\n   quien labora en "+departamento+" con "+antiguedad+
								          "\n   recibe 7 (siete) días de vacaciones.");
					}
					if(antiguedad.equals("2 a 6 años de servicio")) {
						textArea1.setText("\n   El trabajador "+nombreTrabajador+" "+apPa+" "+apMa+
								          "\n   quien labora en "+departamento+" con "+antiguedad+
								          "\n   recibe 15 (quince) días de vacaciones.");
					}
					if(antiguedad.equals("7 o más años de servicio")) {
						textArea1.setText("\n   El trabajador "+nombreTrabajador+" "+apPa+" "+apMa+
								          "\n   quien labora en "+departamento+" con "+antiguedad+
								          "\n   recibe 22 (veintidos) días de vacaciones.");
					}
				}
				if(departamento.equals("Departamento de Gerencia")) {
						if(antiguedad.equals("1 año de servicio")) {
							textArea1.setText("\n   El trabajador "+nombreTrabajador+" "+apPa+" "+apMa+
									          "\n   quien labora en "+departamento+" con "+antiguedad+
									          "\n   recibe 10 (diez) días de vacaciones.");
						}
						if(antiguedad.equals("2 a 6 años de servicio")) {
							textArea1.setText("\n   El trabajador "+nombreTrabajador+" "+apPa+" "+apMa+
									          "\n   quien labora en "+departamento+" con "+antiguedad+
									          "\n   recibe 20 (veinte) días de vacaciones.");
						}
						if(antiguedad.equals("7 o más años de servicio")) {
							textArea1.setText("\n   El trabajador "+nombreTrabajador+" "+apPa+" "+apMa+
									          "\n   quien labora en "+departamento+" con "+antiguedad+
									          "\n   recibe 30 (treinta) días de vacaciones.");
						}
				}
			}
			
		}
		if(e.getSource()== miRojo) {
			getContentPane().setBackground(new Color(255,0,0));
		}
		if(e.getSource()==miNegro) {
			getContentPane().setBackground(new Color(0,0,0));
		}
		if(e.getSource()==miMorado) {
			getContentPane().setBackground(new Color(51,0,51));
		}
		if(e.getSource()==miNuevo) {
			txtNombreTrabajador.setText("");
			txtAMaternoTrabajador.setText("");
			txtAPaternoTrabajador.setText("");
			comboDepartamento.setSelectedIndex(0); //setea a 0 el jComboBox
			comboAntiguedad.setSelectedIndex(0);
			textArea1.setText("\n   Aquí aparece el resultado del cálculo de las vacaciones.");
		}
		if(e.getSource()==miSalir) {
			//regresamos a la interfaz de bienvenida
			PantallaBienvenida ventanaBienvenida = new PantallaBienvenida();
			ventanaBienvenida.setBounds(0, 0, 350, 450);
			ventanaBienvenida.setVisible(true);
			ventanaBienvenida.setResizable(false);
			ventanaBienvenida.setLocationRelativeTo(null);
			this.setVisible(false);
		}
		if(e.getSource()==miElCreador) {
			JOptionPane.showMessageDialog(null, "Desarrollado por Fernando Gomez Martirena");
		}
	}//cierra el metodo
	
}//cierra la clase
