package mx.ipn.upiicsa.poo.practica05.model;

import java.time.LocalDateTime;
import java.util.List;

public class Diagrama {
	private Integer id;
	private String nombre;
	private String descripcion;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaModificacion;
	private String json;
	private List<Figura> figuras;
	
	public Diagrama(Integer id, String nombre, String descripcion, LocalDateTime fechaCreacion, LocalDateTime fechaModificacion) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
	}
	
	public Diagrama(Integer id, String nombre, String descripcion, LocalDateTime fechaCreacion, LocalDateTime fechaModificacion,
			String json) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.json = json;
	}

	public Diagrama(String nombre, String descripcion, LocalDateTime fechaCreacion, LocalDateTime fechaModificacion,
			String json) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.json = json;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDateTime getFechaActualizacion() {
		return fechaModificacion;
	}

	public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
		this.fechaModificacion = fechaActualizacion;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public List<Figura> getFiguras() {
		return figuras;
	}

	public void setFiguras(List<Figura> figuras) {
		this.figuras = figuras;
	}
	
	

}
