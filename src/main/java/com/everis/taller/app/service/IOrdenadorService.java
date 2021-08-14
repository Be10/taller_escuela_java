package com.everis.taller.app.service;

import java.util.List;

import com.everis.taller.app.domain.Ordenador;

public interface IOrdenadorService {
	
	public Ordenador guardarOrdenador(Ordenador o);
	public List<Ordenador> listarOrdenador();
	public Ordenador updateOrdenador(Ordenador o);
	public void eliminarOrdenador(Long id);
	public Ordenador buscarOrdenador(Long id);

}