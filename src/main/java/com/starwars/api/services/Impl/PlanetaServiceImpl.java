package com.starwars.api.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starwars.api.documents.Planeta;
import com.starwars.api.repositories.PlanetaRepository;
import com.starwars.api.services.PlanetaService;

@Service
public class PlanetaServiceImpl implements PlanetaService {

	@Autowired
	private PlanetaRepository planetaRepository;
	
	@Override
	public List<Planeta> listarTodos() {
		return this.planetaRepository.findAll();
	}

	

	@Override
	public Planeta cadastrar(Planeta planeta) {
		return this.planetaRepository.save(planeta);
	}
	
	@Override
	public void remover(String id) {
		this.planetaRepository.deleteById(id);

	}


	
	@Override
	public Planeta listarPorNome(String nome) {
		return Optional.ofNullable(this.planetaRepository.findByNome(nome))
				.orElseThrow(() -> new IllegalArgumentException("Este Planeta não existe"));
				
	}
	
	
	
	@Override
	public Planeta listarPorId(String id) {
		return Optional.ofNullable(this.planetaRepository.findById(id))
				.orElseThrow(() -> new IllegalArgumentException("Este Planeta não existe"));
	}


}
