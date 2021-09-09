package model;

public class Libros {
	private int id;
	private String nombreLibro;
	private String descripcion;
	private Boolean prestado;
	
	public Libros(int id, String nombreLibro, String descripcion, Boolean prestado) {
		this.id = id;
		this.nombreLibro = nombreLibro;
		this.descripcion = descripcion;
		this.prestado = prestado;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreLibro() {
		return nombreLibro;
	}
	public void setNombreLibro(String nombreLibro) {
		this.nombreLibro = nombreLibro;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Boolean getPrestado() {
		return prestado;
	}
	public void setPrestado(Boolean prestado) {
		this.prestado = prestado;
	}
	
	
}
