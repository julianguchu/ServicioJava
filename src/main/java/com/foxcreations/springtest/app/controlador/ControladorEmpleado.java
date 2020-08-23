package com.foxcreations.springtest.app.controlador;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foxcreations.springtest.app.DTO.DTOConsulta;
import com.foxcreations.springtest.app.models.Empleado;
import com.foxcreations.springtest.app.service.Servicio;
@CrossOrigin(origins = "*")
@RestController
public class ControladorEmpleado {

	@Autowired
	private Servicio service;

	@GetMapping("/listEmpleados")
	public List<Empleado> listEmpleados() {

		return service.listarEmpleados();

	}

	@PostMapping("/crear")
	public Empleado createEmpleado(@RequestBody Empleado empleado) {

		return service.guardar(empleado);

	}

	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<?> borrar(@PathVariable("id") Integer id) throws NoSuchElementException  {
		
		
			try {
				Empleado empleado = service.buscarId(id);
				System.out.println(empleado.getId()+ " "+ empleado.getFullName()+" "+empleado.getFuntion());
				return new ResponseEntity<>(service.borrar(empleado), HttpStatus.ACCEPTED);
			} 
			catch (NoSuchElementException e) {
				return new ResponseEntity<>("no existe usuario a eliminar", HttpStatus.NOT_FOUND);
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				return new ResponseEntity<>("debes reasignar a los subordinados antes de eliminar", HttpStatus.NOT_FOUND);
			} 
		
			 
		 
		
		
	}
	
	@GetMapping("/listaDto")
	
	public List<DTOConsulta> getlistaDTO(){
		
		
		
		return service.getListaDto();
		
	}
	 
	@GetMapping("/listaJefes")
	public List<DTOConsulta> getJefes(){
		
	return	service.listaJefes();//.stream().filter( objeto  ->{ return objeto.getNombre()!= null;} ).collect(Collectors.toList());
	}
	
	@PostMapping("/guardarFormulario")
	public String registroFormulario(@RequestBody DTOConsulta objeto) throws Exception{
		try {
			System.out.println(objeto.getId() + " " + objeto.getNombre() + " " + objeto.getFuncion()+ " " + objeto.getJefe());
			service.buscarId((objeto.getId()));
			return "el empleado ya existe, no se puede guardar";
		
		} catch (Exception e) {
			if(objeto.getJefe()== null || objeto.getJefe().equals("")) {
				
				service.guardar(new Empleado(objeto.getId(),objeto.getNombre(),objeto.getFuncion(), null));
				return "empleado guardado";
			}
		Empleado  jefeSeleccionado=	service.buscarId(Integer.parseInt(objeto.getJefe()));
		Empleado empleadoPersist= new Empleado(objeto.getId(),objeto.getNombre(),objeto.getFuncion(), jefeSeleccionado);
			service.guardar(empleadoPersist);
		return "empleado guardado";  
		} 
		 

		 
		
		
	}

}
