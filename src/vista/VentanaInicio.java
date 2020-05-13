package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import modelo.Administrador;

public class VentanaInicio extends JFrame{

	private PanelOpciones panelOpciones;
	private PanelResultado panelResultado;
	private Administrador administrador;
	
	public VentanaInicio() {
		
		setLayout(new BorderLayout());
		setTitle("Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(700, 400));
		setLocationRelativeTo(null);
		
		panelOpciones = new PanelOpciones(this);
		panelResultado = new PanelResultado(this);
		administrador = new Administrador();
		
		add(panelOpciones, BorderLayout.WEST);
		add(panelResultado, BorderLayout.CENTER);
		
		pack();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VentanaInicio ventana = new VentanaInicio();
		ventana.setVisible(true);
	}

	public void mostrarProcesos() {
		String info = "<html><body>Info: Se muestran los cinco (5) procesos que más CPU <br>están consumiendo en este momento.</body></html>";
		String resultado = administrador.ejecutar(Administrador.RUTA_PROCESOS);
		panelResultado.mostrarResultados(resultado, info);
	}
	
	public void mostrarDiscos() {
		String info = "<html><body>Info: Se muestran los filesystems o discos conectados a la máquina. <br>Incluir en cada disco su tamaño y cantida de espacio libre (en bytes).</body></html>";
		String resultado = administrador.ejecutar(Administrador.RUTA_DISCOS);
		panelResultado.mostrarResultados(resultado, info);
	}
	
	public void mostrarArchivo() {
		String info = "<html><body>Info: Se muestran el nombre y el tamaño del archivo más grande <br>almacenado en el disco o filesystem especificado.</body></html>";
		String resultado = administrador.ejecutar(Administrador.RUTA_ARCHIVO, seleccionarDirectorio());
		panelResultado.mostrarResultados(resultado, info);
	}
	
	public void mostrarMemoria() {
		String info = "<html><body>Info: Se muestran la cantidad de memoria libre y cantidad de <br>espacio de swap en uso (en bytes y porcentaje).</body></html>";
		String resultado = administrador.ejecutar(Administrador.RUTA_MEMORIA);
		panelResultado.mostrarResultados(resultado, info);
	}
	
	public void mostrarConexiones() {
		String info = "<html><body>Info: Se muestra el número de conexiones de red activas actualmente.</body></html>";
		String resultado = administrador.ejecutar(Administrador.RUTA_CONEXIONES);
		panelResultado.mostrarResultados(resultado, info);
	}
	
	public String seleccionarDirectorio() {
		JFileChooser selectorArchivos = new JFileChooser();
		selectorArchivos.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int seleccion = selectorArchivos.showOpenDialog(this);
		File archivo = selectorArchivos.getSelectedFile();
		
		
		
		if ((archivo == null) || (archivo.getName().equals(""))) {
			 JOptionPane.showMessageDialog(this, "Nombre de archivo inválido", "Nombre de archivo inválido", JOptionPane.ERROR_MESSAGE);
		}else {
			System.out.println(archivo.getPath());
		}
		
		return archivo.getPath();
	}
}
