package com.agencia.gnomoTur.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.agencia.gnomoTur.entities.Viagem;
import com.agencia.gnomoTur.repositorys.ViagemRepository;

@CrossOrigin(origins = "#")
@RestController
@RequestMapping(value = "/viagens")
public class ViagemController {
	
	@Autowired
	private ViagemRepository viagemRepository;
	
	
	// GET
	@GetMapping
	public ResponseEntity<List<Viagem>> findAll() {
		List<Viagem> viagens = viagemRepository.findAll();
		
		return ResponseEntity.ok().body(viagens);
	}
	
	// GET id
	@GetMapping(value = "/{id_viagem}")
	public ResponseEntity<Viagem> findById(@PathVariable Long id_viagem) {
		Viagem viagem = viagemRepository.findById(id_viagem).get();
		
		return ResponseEntity.ok().body(viagem);
	}
	
	// CREATE
		@PostMapping
		public Viagem createEmployee(@RequestBody Viagem Viagem) {
			return viagemRepository.save(Viagem);
		}
		
		
		// UPDATE
		@PutMapping("{id_viagem}")
		public ResponseEntity<Viagem> update(@PathVariable long id_viagem,@RequestBody Viagem viagemDetails){
			Viagem updateViagem = viagemRepository.findById(id_viagem).get();
			
			updateViagem.setDataIda(viagemDetails.getDataIda());
			updateViagem.setDataVolta(viagemDetails.getDataVolta());
			
			viagemRepository.save(updateViagem);
			return ResponseEntity.ok(updateViagem);
			
		}
		
		// DELETE
		@DeleteMapping("{id_viagem}")
		public ResponseEntity<HttpStatus> delete(@PathVariable long id_viagem){
			Viagem viagem = viagemRepository.findById(id_viagem).get();
			viagemRepository.delete(viagem);
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	}

