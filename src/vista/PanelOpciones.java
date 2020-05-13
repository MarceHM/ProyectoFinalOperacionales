package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelOpciones extends JPanel implements ActionListener{

	public final static String PROCESOS = "Procesos";
	public final static String DISCOS = "Discos conectados";
	public final static String ARCHIVO = "Archivo más grande";
	public final static String MEMORIA = "Memoria libre";
	public final static String CONEXIONES = "Conexiones activas";
	
	private JButton btnProcesos;
	private JButton btnDiscos;
	private JButton btnArchivo;
	private JButton btnMemoria;
	private JButton btnConexiones;
	private VentanaInicio principal;
	
	public PanelOpciones(VentanaInicio i) {
		principal = i;
		
		setLayout(new GridLayout(5, 1, 5, 5));
		setBorder(new TitledBorder("Seleccione una opcion: "));
		
		btnProcesos = new JButton(PROCESOS);
		btnProcesos.setActionCommand(PROCESOS);
		btnProcesos.addActionListener(this);
		
		btnDiscos = new JButton(DISCOS);
		btnDiscos.setActionCommand(DISCOS);
		btnDiscos.addActionListener(this);
		
		btnArchivo = new JButton(ARCHIVO);
		btnArchivo.setActionCommand(ARCHIVO);
		btnArchivo.addActionListener(this);

		btnMemoria = new JButton(MEMORIA);
		btnMemoria.setActionCommand(MEMORIA);
		btnMemoria.addActionListener(this);
		
		btnConexiones = new JButton(CONEXIONES);
		btnConexiones.setActionCommand(CONEXIONES);
		btnConexiones.addActionListener(this);
		
		add(btnProcesos);
		add(btnDiscos);
		add(btnArchivo);
		add(btnMemoria);
		add(btnConexiones);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		
		if(comando.equals(PROCESOS)) {
			principal.mostrarProcesos();
			
		}else if(comando.equals(DISCOS)) {
			principal.mostrarDiscos();
			
		}else if(comando.equals(ARCHIVO)) {
			principal.mostrarArchivo();
			
		}else if(comando.equals(MEMORIA)) {
			principal.mostrarMemoria();
			
		}else if(comando.equals(CONEXIONES)) {
			principal.mostrarConexiones();
			
		}else {
			System.out.println("Botón invalido");
		}
	}
}
