package vista;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

public class PanelResultado extends JPanel{
	
	private JTextPane panelResultados;
	private JLabel lblMuestra;
	private JLabel lblInfo;
	private VentanaInicio principal;
	
	public PanelResultado(VentanaInicio i) {
		principal = i;
		
		setLayout(new BorderLayout());
		setBorder(new TitledBorder("Resultados"));
		
		panelResultados = new JTextPane();
		panelResultados.setText("Aquí se mostrará el resultado...");
		panelResultados.setEditable(false);
		
		JScrollPane sp = new JScrollPane(panelResultados);
		
		lblMuestra = new JLabel("El resultado de la operación elegida es: ");
		lblInfo = new JLabel("\nInfo: ");
		
		add(lblMuestra, BorderLayout.NORTH);
		add(sp, BorderLayout.CENTER);
		add(lblInfo, BorderLayout.SOUTH);
		
	}
	
	public void mostrarResultados(String resultado, String info) {
		lblInfo.setText(info);
		panelResultados.setText(resultado);
	}

}
