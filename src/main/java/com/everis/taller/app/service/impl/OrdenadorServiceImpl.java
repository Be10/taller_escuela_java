package com.everis.taller.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.everis.taller.app.domain.Ordenador;
import com.everis.taller.app.repository.IRepositoryOrdenador;
import com.everis.taller.app.service.IOrdenadorService;


@Service
public class OrdenadorServiceImpl implements IOrdenadorService{
	
	
	@Autowired
	public IRepositoryOrdenador repo;

	@Override
	public Ordenador guardarOrdenador(Ordenador o) {

		return repo.save(o);

	}

	@Override
	public List<Ordenador> listarOrdenador() {
		
		return repo.findAll();
		
	}

	@Override
	public Ordenador updateOrdenador(Ordenador o) {
		
		return repo.save(o);
		
	}

	@Override
	public void eliminarOrdenador(Long id) {
		
		 repo.deleteById(id);
		
	}

	@Override
	public Ordenador buscarOrdenador(Long id) {
		
		return repo.findById(id).get();
	}

}