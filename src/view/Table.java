package view;

import access.LibrosDAO;
import model.Libros;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;


import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Table extends JPanel {
	
	
	private JTable table;
	private MainWindow principal;
	private Object[][] datosTabla;	
	private String[] columnas = {"ID", "Nombre libro", "Descripci\u00F3n", "Prestado"};
	private DefaultTableModel modeloTable;
	private JScrollPane scrollPane;
	
	ArrayList<String> campoSeleccionadoAct = new ArrayList<String>();
	
	public Table(MainWindow principal) {
		this();
		this.principal = principal;
	}
	
	/**
	 * Create the panel.
	 */
	public Table() {
		setBorder(new TitledBorder(null, "Tabla Consultas", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		
		modeloTable = new DefaultTableModel(datosTabla,columnas);
		
		table = new JTable(modeloTable);
		
		
		table.getColumnModel().getColumn(1).setPreferredWidth(98);
		table.getColumnModel().getColumn(2).setPreferredWidth(159);
		scrollPane = new JScrollPane(table);
		add(scrollPane);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	campoSeleccionadoAct.clear();
	        	
	        	String idDato = table.getValueAt(table.getSelectedRow(), 0).toString();
	        	String idNombre = table.getValueAt(table.getSelectedRow(), 1).toString();
	        	String idDescripcion = table.getValueAt(table.getSelectedRow(), 2).toString();
	        	String idPrestado = table.getValueAt(table.getSelectedRow(), 3).toString();
	        	
	        	campoSeleccionadoAct.add(idDato);
	        	campoSeleccionadoAct.add(idNombre);
	        	campoSeleccionadoAct.add(idDescripcion);
	        	campoSeleccionadoAct.add(idPrestado);
	        	
	        	principal.ActualizarDatosFormularioSeleccionado();
	            // do some actions here, for example
	            // print first column value from selected row
	        }
	    });
	}
	
	public ArrayList<String> getCampoSeleccionadoAct() {
		return campoSeleccionadoAct;
	}
	
	public void actualizarTabla() {
		System.out.println(modeloTable.getRowCount());
		try {
			if(modeloTable.getRowCount() > 0) {
				modeloTable.setRowCount(0);
			}
		}
		catch (Exception e){}
		
		ArrayList<Libros> libros = LibrosDAO.consultaLibros();

		if(libros.size() > 0) {
			modeloTable.insertRow(table.getRowCount(), new Object[] {"","","",""});
			for(int i = 0; i<libros.size(); i++) {
				Libros libroAct = libros.get(i);
				int idLibro = libroAct.getId();
				String nombreLibro = libroAct.getNombreLibro();
				String descripcion = libroAct.getDescripcion();
				boolean prestado = libroAct.getPrestado();
				modeloTable.insertRow(table.getRowCount(), new Object[] {idLibro,nombreLibro,descripcion, prestado});
			}
		}else {
			modeloTable.insertRow(table.getRowCount(), new Object[] {"","","",""});
		}
		
		
		
	}


}
