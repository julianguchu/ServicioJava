package com.foxcreations.springtest.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.foxcreations.springtest.app.models.Empleado;
import com.foxcreations.springtest.app.repository.Repositorio;
import com.foxcreations.springtest.app.service.Servicio;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class EmpleadosApplicationTests {


	@InjectMocks
	private Servicio servicio;
	
	@Mock
	private  Repositorio repo;
	

@Test
	public void probarCrear() {
		Empleado empleado= new Empleado(30, "Angel Lara", "Albañil", null);
	when(repo.save(empleado)).thenReturn(empleado);
		
	
	assertEquals(empleado, servicio.guardar(empleado));
}
		
		
	
	
   @Test
	public void probarListar() {
		
		
		
		when(repo.findAll()).thenReturn(Arrays.asList(new  Empleado(7,"Christian Garcia", "desempleado", null),
				new  Empleado(7,"pedro ramires", "catador", new  Empleado(7,"Christian Garcia", "desempleado", null))));
	
		
		assertEquals(2, servicio.listarEmpleados().size());
   }
	

@Test
	public void probarEliminar() {
	Empleado empleado= new Empleado(30, "Angel Lara", "Albañil", null);
	servicio.borrar(empleado);
	verify(repo, times(1)).delete(empleado);

		
		
		
		
	}
}
