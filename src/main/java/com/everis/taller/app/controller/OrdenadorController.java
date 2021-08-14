package com.everis.taller.app.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.everis.taller.app.domain.Ordenador;
import com.everis.taller.app.repository.IRepositoryOrdenador;
import com.everis.taller.app.service.IOrdenadorService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/ordenadores")
@Log4j2
public class OrdenadorController {
	
	@Autowired
	public IOrdenadorService ordenadorService;
	
	@Autowired
	public IRepositoryOrdenador repo;

	@PostMapping("/guardar")
	public ResponseEntity<Object> metodoGuardarOrdenador(@RequestBody Ordenador o) {
		
		Ordenador ordenador= ordenadorService.guardarOrdenador(o);
		
		return new ResponseEntity<>(ordenador, HttpStatus.CREATED);
	}

	@GetMapping("/listar")
	public List<Ordenador> metodoListarOrdenador() {
		return ordenadorService.listarOrdenador();
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Object> metodoActualizarOrdenador(@RequestBody Ordenador o, @PathVariable Long id) {
		
		
		Optional<Ordenador> computadora = repo.findById(id);
		
		if(!computadora.isPresent()){
			return ResponseEntity.notFound().build();
		}
		
		//a.setIdAlumno(id);
		
		ordenadorService.updateOrdenador(o);
		
		return ResponseEntity.accepted().build();
	}

	@DeleteMapping("/eliminar/{id}")
	public void metodoEliminarOrdenador(@RequestBody Ordenador o, @PathVariable Long id) {
		
		
		
		ordenadorService.eliminarOrdenador(id);
		System.out.println("EL ORDENADOR" + id + " fue eliminado");
		log.info("EL ORDENADOR A TRAVES DE LOG " + id + "fue eliminado");

	}

	@GetMapping("/buscar")
	public Ordenador metodoBuscarOrdenador(@RequestParam Long id) {

		System.out.println("Se obtuvo el" + id);
		log.info("EL ORDENADOR A TRAVES DE LOG ");
		return ordenadorService.buscarOrdenador(id);

	}

}
