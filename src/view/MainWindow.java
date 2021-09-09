package view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class MainWindow {

	public JFrame frame;
	private Table table;
	private PanelButtons panelButtons;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 539, 551);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		table = new Table(this);
		table.actualizarTabla();
		frame.getContentPane().add(table, BorderLayout.CENTER);
		
		panelButtons = new PanelButtons(this,table);
		table.add(panelButtons);
	}
	
	
	
	public void ActualizarDatosFormularioSeleccionado() {
		ArrayList<String> filaSeleccionada = table.getCampoSeleccionadoAct();
		panelButtons.actualizarInfoModifacionLibro(filaSeleccionada);
	}
	


}
