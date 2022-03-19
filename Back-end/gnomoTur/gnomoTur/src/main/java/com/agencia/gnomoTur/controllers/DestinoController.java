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

import com.agencia.gnomoTur.entities.Destino;
import com.agencia.gnomoTur.repositorys.DestinoRepository;

@CrossOrigin(origins = "#")
@RestController
@RequestMapping(value = "/destinos")
public class DestinoController {
	
	@Autowired
	private DestinoRepository DestinoRepository;
	
	// GET
	@GetMapping
	public ResponseEntity<List<Destino>> findAll() {
		List<Destino> destinos = DestinoRepository.findAll();
		
		return ResponseEntity.ok().body(destinos);
	}

	// GET ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<Destino> findById(@PathVariable Long id) {
		Destino destino = DestinoRepository.findById(id).get();
		
		return ResponseEntity.ok().body(destino);
	}

	// CREATE
	@PostMapping
	public Destino create (@RequestBody Destino destino) {
		return DestinoRepository.save(destino);
	}
	
	
	// UPDATE
	@PutMapping("{id}")
	public ResponseEntity<Destino> update(@PathVariable long id,@RequestBody Destino destinoDetails){
		Destino updateDestino = DestinoRepository.findById(id).get();
		
		updateDestino.setCidade(destinoDetails.getCidade());
		updateDestino.setEstado(destinoDetails.getEstado());
		updateDestino.setPreco(destinoDetails.getPreco());
		
		return ResponseEntity.ok(updateDestino);
		
	}
	
	// DELETE
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable long id){
		Destino destino = DestinoRepository.findById(id).get();
		DestinoRepository.delete(destino);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
}

