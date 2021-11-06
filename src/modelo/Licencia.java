package modelo;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Licencia extends JFrame implements ActionListener, ChangeListener{
	private JLabel label1, label2;
	private JCheckBox check1;
	private JButton boton1, boton2;
	private JScrollPane scrollPane1;
	private JTextArea textArea1;
	//vamos a crear una variable para guardar el valor de la variable "nombreUsuario" que viene
	//de la clase "PantallaBienvenida"
	private String nombre = "";
	
	public Licencia () {
		setLayout(null);
		//LINEA MUY IMPORTANTE. CIERRA EL PROCESO y evita que se siga ejecutando
		//en segundo plano
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Licencia de uso");
		setIconImage(new ImageIcon(getClass().getResource("images/icon.png")).getImage());
		//vamos a recuperar el valor de la variable que esta en la clase "PantallaBienvenida"
		//primero creamos el obj. de la clase en cuestion
		PantallaBienvenida stringDeVentanaBienvenida = new PantallaBienvenida();
		//2do vamos a recuperar el valor de la variable que queremos
		nombre = stringDeVentanaBienvenida.nombreUsuario; //recordar! podemos acceder a ella
		//porque la variable "nombreUsuario" fue definida como "public" y "static"
		
		label1 = new JLabel("TERMINOS Y CONDICIONES");
		label1.setBounds(215, 5, 200, 30);
		label1.setFont(new Font("Andale Mono", 1, 14));
		label1.setForeground(new Color(0,0,0));
		add(label1);
		
		textArea1 = new JTextArea();
		textArea1.setEditable(false); // Para que no sea editable lo que aparece
		textArea1.setFont(new Font("Andale Mono", 0, 9));
		textArea1.setText("\n\n           TÉRMINOS Y CONDICIONES" +
                "\n\n           A.  PROHIBIDA SU VENTA O DISTRIBUCIÓN SIN AUTORIZACIÓN DE LA GEEKIPEDIA DE ERNESTO." +
                "\n           B.  PROHIBIDA LA ALTERACIÓN DEL CÓDIGO FUENTE O DISEÑO DE LAS INTERFACES GRÁFICAS." +
                "\n           C.  LA GEEKIPEDIA DE ERNESTO NO SE HACE RESPONSABLE DEL MAL USO DE ESTE SOFTWARE." +
                "\n\n         LOS ACUERDOS LEGALES EXPUESTOS ACONTINUACIÓN RIGEN EL USO QUE USTED HAGA DE ESTE SOFTWARE" +
                "\n         (LA GEEKIPEDIA DE ERNESTO Y EL AUTOR ERNESTO), NO SE RESPONSABILIZAN DEL USO QUE USTED" + 
                "\n         HAGA CON ESTE SOFTWARE Y SUS SERVICIOS. PARA ACEPTAR ESTOS TERMINOS HAGA CLIC EN (ACEPTO)" +
                "\n         SI USTED NO ACEPTA ESTOS TERMINOS, HAGA CLIC EN (NO ACEPTO) Y NO UTILICE ESTE SOFTWARE." + 
                "\n\n         PARA MAYOR INFORMACIÓN SOBRE NUESTROS PRODUCTOS O SERVICIOS, POR FAVOR VISITE" + 
                "\n         http://www.youtube.com/ernestoperezm");
		scrollPane1 = new JScrollPane(textArea1);
		scrollPane1.setBounds(10, 40, 575, 200);
		add(scrollPane1);

		check1 = new JCheckBox("Si, yo " + nombre + " acepto");
		check1.setBounds(10, 250, 300, 30);
		check1.addChangeListener(this);
		add(check1);
		
		boton1 = new JButton("Continuar");
		boton1.setBounds(10, 290, 100, 30);
		boton1.addActionListener(this);
		boton1.setEnabled(false);
		add(boton1);
		
		boton2 = new JButton("No Acepto");
		boton2.setBounds(120, 290, 100, 30);
		boton2.addActionListener(this);
		boton2.setEnabled(true);
		add(boton2);
		
		ImageIcon imagen = new ImageIcon("images/coca-cola.png");
		label2 = new JLabel(imagen);
		label2.setBounds(315, 135, 300, 300);
		add(label2);
	}
	
	public void stateChanged(ChangeEvent e) {
		if(check1.isSelected()) {
			boton1.setEnabled(true);
			boton2.setEnabled(false);
		}else {
			boton1.setEnabled(false);
			boton2.setEnabled(true);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==boton1) {
			//enlazamos el objeto y metodos para crear (y pasar) a la interfaz ppal.
			Principal ppal = new Principal();
			ppal.setBounds(0, 0, 640, 535);
			ppal.setVisible(true);
			ppal.setResizable(false);
			ppal.setLocationRelativeTo(null);
			this.setVisible(false);
			
		}else if(e.getSource()==boton2) {
			//y sino acepta los terminos y condiciones tiene que volver a la interfaz
			//de bienvenida. O sea a la "PantallaBienvenida"
			PantallaBienvenida ventanaBienvenida = new PantallaBienvenida();
			ventanaBienvenida.setBounds(0, 0, 350, 450);
			ventanaBienvenida.setVisible(true);
			ventanaBienvenida.setResizable(false);
			ventanaBienvenida.setLocationRelativeTo(null);
			this.setVisible(false);
		}
	}
	
}
