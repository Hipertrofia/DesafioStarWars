package com.starwars.api.services;

import java.util.List;

import com.starwars.api.documents.Planeta;

public interface PlanetaService {

	Planeta cadastrar(Planeta planeta);
	
	List<Planeta> listarTodos();
	
	Planeta listarPorNome(String nome);
	
	Planeta listarPorId(String id);
			
	void remover(String id);
}
