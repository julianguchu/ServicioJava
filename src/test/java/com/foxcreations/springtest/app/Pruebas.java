package com.foxcreations.springtest.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.foxcreations.springtest.app.models.Empleado;
import com.foxcreations.springtest.app.repository.Repositorio;
import com.foxcreations.springtest.app.service.Servicio;

@RunWith(MockitoJUnitRunner.class)
public class Pruebas {
	
	
	@InjectMocks
	private Servicio servicio;
	
	@Mock
	private  Repositorio repo;
	

@Test
	public void probarCrear() {
		
		
		
		
	}
	
   @Test
	public void probarListar() {
		
		
		
		when(repo.findAll()).thenReturn(Arrays.asList(new  Empleado(7,"Christian Garcia", "desempleado", null),
				new  Empleado(7,"pedro ramires", "catador", new  Empleado(7,"Christian Garcia", "desempleado", null))));
	
		
		assertEquals(2, servicio.listarEmpleados());
   }
	

@Test
	public void probarEliminar() {
		
		
		
		
	}

}
