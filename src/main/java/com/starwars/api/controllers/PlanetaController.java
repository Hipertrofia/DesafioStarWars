package com.starwars.api.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starwars.api.documents.Planeta;
import com.starwars.api.reponses.Response;
import com.starwars.api.services.PlanetaService;

@RestController
@RequestMapping(path="/api/planeta")
public class PlanetaController {

	@Autowired
	private PlanetaService planetaService;
	
	@GetMapping
	public ResponseEntity<Response<List<Planeta>>> listarTodos(){
		return ResponseEntity.ok(new Response<List<Planeta>>(this.planetaService.listarTodos()));
	}
	
	@PostMapping
	public ResponseEntity<Response<Planeta>> cadastrar(@Valid @RequestBody Planeta planeta, BindingResult result){
		if (result.hasErrors()) {
			List<String> erros= new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Planeta>(erros));
		}
		
		return ResponseEntity.ok(new Response<Planeta>(this.planetaService.cadastrar(planeta)));
	}

	@DeleteMapping(path="/{id}")
	public ResponseEntity<Response<Integer>> remover(@PathVariable(name="id")String id){
		this.planetaService.remover(id);
		return ResponseEntity.ok(new Response<Integer>(1));
	}

	@GetMapping(path="/{nome}")
    public ResponseEntity<Response<Planeta>> listarPorNome(@PathVariable(name="nome")String nome){
		return ResponseEntity.ok(new Response<Planeta>(planetaService.listarPorNome(nome)));
	}
	
	@GetMapping(path="{/id}")
	public ResponseEntity<Response<Planeta>> listarPorId(@PathVariable(name="id")String id){
		return ResponseEntity.ok(new Response<Planeta>(planetaService.listarPorId(id))); 
	}
}
