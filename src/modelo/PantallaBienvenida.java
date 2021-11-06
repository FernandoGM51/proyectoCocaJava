package modelo;

/* Esta clase representará la pantalla de bienvenida
 * y login de la app.
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/*
 * El GUI de bienvenida/loguin va a tener un botón para acceder
 * con lo cual tenemos que usar "ActionListener".
 * Además usaremos, en total, 3 componentes: 4 JLabel, un JTextField
 * y un JButton
 */

public class PantallaBienvenida extends JFrame implements ActionListener {
	private JTextField textField;
	private JLabel label1, label2, label3, label4;
	private JButton boton1;
	//vamos a crear una variable que se pueda usar en los otros GUIs tmb.
	//Para ello vamos a hacerla "publica" y que va a ser static
	//Cualquier clase va a poder usar esta variable
	public static String  nombreUsuario = "";
	
	public PantallaBienvenida() {
		setLayout(null);
		//LINEA MUY IMPORTANTE. CIERRA EL PROCESO y evita que se siga ejecutando
		//en segundo plano
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//seteamos titulo
		setTitle("Bienvenido");
		//seteamos color de fondo en rojo
		getContentPane().setBackground(new Color(255,0,0));
		
		//cambiar el ícono de la ventana (por default sale el de Java)
		setIconImage(new ImageIcon(getClass().getResource("images/icon.png")).getImage());
		
		//ahora vamos con las label
		//primero el label que contendrá la imagen de la marca
		//Creamos un obj de tipo "ImageIcon" y guardamos en base a la dir.
		ImageIcon imagen = new ImageIcon("images/logo.png");
		//ahora vamos a colocarlo dentro del label
		label1 = new JLabel(imagen); //en vez de ponele un nombre entre comillas, le pongo el obj ImageIcon
		label1.setBounds(25, 15, 300, 150);
		add(label1);
		
		//vamos con la 2da etiqueta. Ojo! estos textos tendrán distinto tamalo y color blanco
		label2 = new JLabel("Sistema de Control Vacacional");
		label2.setBounds(35, 135, 300, 30);
		label2.setFont(new Font("Andale Mono", 3, 18));
		label2.setForeground(new Color(255,255,255));
		add(label2);
		
		//vamos con la 3ra
		label3 = new JLabel("Ingrese su nombre");
		label3.setBounds(45, 212, 200, 30);
		label3.setFont(new Font("Andale Mono", 1, 12));
		label3.setForeground(new Color(255,255,255));
		add(label3);
		
		//ahora la 4ta
		label4 = new JLabel("©2017 The Coca-Cola Company");
		label4.setBounds(85, 375, 300, 30);
		label4.setFont(new Font("Andale Mono", 1, 12));
		label4.setForeground(new Color(255,255,255));
		add(label4);
		
		//textfield para el ingreso con la pecualiaridad de su tono gris. y su letra roja
		textField = new JTextField();
		textField.setBounds(45, 240, 255, 25);
		textField.setBackground(new Color(224,224,224)); //color gris
		textField.setFont(new Font("Andale Mono", 1, 14)); //tipo, grosor y tamaño de letra
		textField.setForeground(new Color(255,0,0)); //texto color rojo
		add(textField);
		
		//ahora el boton
		boton1 = new JButton("Ingresar");
		boton1.setBounds(125, 280, 100, 30);
		boton1.setBackground(new Color(255,255,255));
		boton1.setFont(new Font("Andale Mono", 1, 14));
		boton1.setForeground(new Color(255,0,0));
		boton1.addActionListener(this);
		add(boton1);
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==boton1) {
			nombreUsuario = textField.getText().trim(); //el metodo trim elimina los espacios antes o dps del nombre
			if(nombreUsuario.equals("")) {
				//si el textField esta en blanco se enviara un msj de error
				JOptionPane.showMessageDialog(null, "Debes ingresar tu nombre");
			}else {
				//seteamos todo para la siguiente interfez, la de Licencia
				Licencia ventanaLicencia = new Licencia();
				ventanaLicencia.setBounds(0, 0, 600, 360);
				ventanaLicencia.setVisible(true);
				ventanaLicencia.setResizable(false);
				ventanaLicencia.setLocationRelativeTo(null);
				this.setVisible(false); //hacemos que la interfaz de bievenida se cierre cuando se ejecute la de licencia
				
			}
		}
	}
	
}
