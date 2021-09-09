package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import access.LibrosDAO;

import javax.swing.JTextPane;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAgregar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private Form form;
	private Table table;
	
	public VentanaAgregar(Table table) {
		this("","","",false, false, table);
	}

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public VentanaAgregar(final String idLibro,String textoNombre, String TextoDescr, Boolean chckbxPrestado, final Boolean editar, final Table table) {
		this.table = table;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel lblNewLabel = new JLabel("Agregar nuevo registro");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel, BorderLayout.NORTH);
		}
		{
			form = new Form(textoNombre, TextoDescr, chckbxPrestado);
			contentPanel.add(form, BorderLayout.CENTER);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Guardar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int idLibroDef = 1;
						if(!idLibro.equals("")) {
							idLibroDef = Integer.parseInt(idLibro);
						}
						
						String nombreLibro = form.getTextNombreLibro().getText();
						String descripcionLibro = form.getTextDescripcion().getText();
						Boolean libroPrestado = form.getChckbxNewCheckBox().isSelected();
						if(editar) {
							LibrosDAO.modificarLibro(idLibroDef,nombreLibro, descripcionLibro, libroPrestado);

							table.actualizarTabla();
						}else {
							
							LibrosDAO.agregarLibro(nombreLibro, descripcionLibro, libroPrestado);
							table.actualizarTabla();
						}
						dispose();
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
	}

	public JButton getOkButton() {
		return okButton;
	}
	public Form getForm() {
		return form;
	}
}
