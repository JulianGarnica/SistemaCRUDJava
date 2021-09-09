package view;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class Form extends JPanel {
	private JLabel lblNombreLibro;
	private JTextField textNombreLibro;
	private JTextField textDescripcion;
	private JCheckBox chckbxNewCheckBox;
	
	/**
	 * Create the panel.
	 */
	
	public Form(String textoNombre, String TextoDescr, Boolean chckbxPrestado) {
		this();
		this.textNombreLibro.setText(textoNombre);
		this.textDescripcion.setText(TextoDescr);
		this.chckbxNewCheckBox.setSelected(chckbxPrestado);
		updateUI();
		repaint();
	}
	
	public Form() {
		setLayout(new GridLayout(3, 2, 2, 2));
		
		lblNombreLibro = new JLabel("Nombre del Libro");
		lblNombreLibro.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblNombreLibro);
		
		textNombreLibro = new JTextField();
		add(textNombreLibro);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n");
		add(lblDescripcion);
		
		textDescripcion = new JTextField();
		add(textDescripcion);
		textDescripcion.setColumns(10);
		
		JLabel lblEstaPrestado = new JLabel("\u00BFActualmente el libro est\u00E1 prestado?");
		add(lblEstaPrestado);
		
		chckbxNewCheckBox = new JCheckBox("S\u00ED/No");
		add(chckbxNewCheckBox);

	}

	public JTextField getTextNombreLibro() {
		return textNombreLibro;
	}
	public JTextField getTextDescripcion() {
		return textDescripcion;
	}
	public JCheckBox getChckbxNewCheckBox() {
		return chckbxNewCheckBox;
	}
}
