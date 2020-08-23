package com.foxcreations.springtest.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.foxcreations.springtest.app.DTO.DTOConsulta;
import com.foxcreations.springtest.app.models.Empleado;

@Repository
public interface Repositorio  extends CrudRepository<Empleado, Integer>{
	
	@Query(" select  new com.foxcreations.springtest.app.DTO.DTOConsulta( e1.id, e1.fullName, e1.funtion, e2.fullName )  "
			+ " from Empleado e1 left join Empleado e2 on  e1.boss.id= e2.id")
	List<DTOConsulta> getLista(); 

	
	
	
	@Query(" select distinct new com.foxcreations.springtest.app.DTO.DTOConsulta( e2.id, e2.fullName, e2.funtion, '')  from Empleado e1 left join Empleado e2 on  e1.boss.id= e2.id")
	List<DTOConsulta> getJefes(); 

}
     