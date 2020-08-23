package com.foxcreations.springtest.app.DTO;



public class DTOConsulta {
	
	private Integer  id ;

	private   String nombre;

	private  String  funcion;

	
	private  String jefe;


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


	public String getFuncion() {
		return funcion;
	}


	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}


	public String getJefe() {
		return jefe;
	}


	public void setJefe(String jefe) {
		this.jefe = jefe;
	}


	public DTOConsulta(Integer id, String nombre, String funcion, String jefe) {
		
		this.id = id;
		this.nombre = nombre;
		this.funcion = funcion;
		this.jefe = jefe;
	}


	public DTOConsulta() {
		
	}

}
