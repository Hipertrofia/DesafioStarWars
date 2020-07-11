package com.starwars.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.starwars.api.documents.Planeta;

public interface PlanetaRepository extends MongoRepository<Planeta, String> {

	Planeta findByNome(String nome);
}
