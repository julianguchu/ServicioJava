package com.foxcreations.springtest.app.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.foxcreations.springtest.app.DTO.DTOConsulta;
import com.foxcreations.springtest.app.models.Empleado;
import com.foxcreations.springtest.app.repository.Repositorio;

@Service
public class Servicio {
	
	private Repositorio repo;
	
@Autowired	
public Servicio(Repositorio repo) {
	this.repo=repo;
	

}

@Transactional
@Modifying(clearAutomatically = true)
public  Empleado  guardar(Empleado emp) {
	return repo.save(emp);
}

public List<Empleado> listarEmpleados(){
	
	
	
	return  (List<Empleado>) repo.findAll();
	
}



public  Empleado buscarId(Integer id )  throws  NoSuchElementException{
	
	
	return repo.findById(id).get();
	
	
}

 

public  String  borrar(Empleado emp) throws Exception{
	 repo.delete(emp);
	
	return " ha sido borrado";
	
}

public List<DTOConsulta> getListaDto(){
	
	
	return repo.getLista();
	
}


public List<DTOConsulta> listaJefes(){
	
	
	
	return repo.getJefes();
	
}
}
