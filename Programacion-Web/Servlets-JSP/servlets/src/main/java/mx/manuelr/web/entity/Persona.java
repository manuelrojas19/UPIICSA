package mx.manuelr.web.entity;

public class Persona {
	private Integer id;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private String curp;

	public Persona() {

	}

	public Persona(Integer id, String nombre, String primerApellido, String segundoApellido, String curp) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.curp = curp;
	}

	public Persona(Integer id, String nombre, String primerApellido, String curp) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.curp = curp;
	}
	
	public Persona(String nombre, String primerApellido, String segundoApellido, String curp) {
		super();
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.curp = curp;
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

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

}
