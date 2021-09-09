package view;

import javax.swing.*;

import access.LibrosDAO;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;

public class PanelButtons extends JPanel {

	private String idDato;
	private String idNombre;
	private String idDescripcion;
	private Boolean idPrestado;
	private JButton btnEditar;
	private MainWindow principal;
	private Table table;
	
	public PanelButtons(MainWindow principal, Table table) {
		this();
		this.principal = principal;
		this.table = table;
	}
	/**
	 * Create the panel.
	 */
	public PanelButtons() {
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(!idNombre.equals("")) {
						VentanaAgregar nuevaVentana = new VentanaAgregar(idDato,idNombre,idDescripcion,idPrestado,true, table);
						nuevaVentana.setModalityType(ModalityType.APPLICATION_MODAL);
						nuevaVentana.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						nuevaVentana.setVisible(true);
					}
				}catch (Exception e1){}
			}
		});
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAgregar nuevaVentana = new VentanaAgregar(table);
				nuevaVentana.setModalityType(ModalityType.APPLICATION_MODAL);
				nuevaVentana.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				nuevaVentana.setVisible(true);
			}
		});
		add(btnNuevo);
		add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(!idDato.equals(null)) {
						LibrosDAO.eliminarLibro(Integer.parseInt(idDato));
						table.actualizarTabla();
					}
				}catch (Exception e1){}
			}
		});
		add(btnEliminar);

	}
	
	public void actualizarInfoModifacionLibro(ArrayList<String> filaSeleccionada) {
		idDato = filaSeleccionada.get(0);
		idNombre = filaSeleccionada.get(1);
		idDescripcion = filaSeleccionada.get(2);
		if(filaSeleccionada.get(3).equals("true")) {
			idPrestado = true;
		}else {
			idPrestado = false;
		}
		
		
		updateUI();
		invalidate();
		repaint();
	}

}
