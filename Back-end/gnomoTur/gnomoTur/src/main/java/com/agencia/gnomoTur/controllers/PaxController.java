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
import com.agencia.gnomoTur.entities.Pax;
import com.agencia.gnomoTur.entities.Viagem;
import com.agencia.gnomoTur.repositorys.DestinoRepository;
import com.agencia.gnomoTur.repositorys.PaxRepository;
import com.agencia.gnomoTur.repositorys.ViagemRepository;


@CrossOrigin(origins = "#")
@RestController
@RequestMapping(value = "/paxs")
public class PaxController {
	
	
	
	@Autowired
	private PaxRepository paxRepository;
	
	@Autowired
	private DestinoRepository DestinoRepository;
	
	@Autowired
	private ViagemRepository viagemRepository;
	
	
	
	@GetMapping
	public ResponseEntity<List<Pax>> findAll() {
		List<Pax> paxs = paxRepository.findAll();
		
		return ResponseEntity.ok().body(paxs);
	}

	@GetMapping(value = "/{id_pax}")
	public ResponseEntity<Pax> findById(@PathVariable Long id_pax) {
		Pax pax = paxRepository.findById(id_pax).get();
		
		return ResponseEntity.ok().body(pax);
	}
	 
	// CREATE
		@PostMapping
		public Pax create (@RequestBody Pax pax) {
			return paxRepository.save(pax);
		}
		
		
		// UPDATE
		@PutMapping("{id_pax}")
		public ResponseEntity<Pax> update(@PathVariable long id_pax,@RequestBody Pax paxDetails){
			Pax updatePax = paxRepository.findById(id_pax).get();
			Destino destino = DestinoRepository.findById(paxDetails.getDestino().getId_destino()).get();
			Viagem viagem = viagemRepository.findById(paxDetails.getViagem().getId_viagem()).get();
			
			updatePax.setNome(paxDetails.getNome());
			updatePax.setIdade(paxDetails.getIdade());
			updatePax.setCpf(paxDetails.getCpf());
			updatePax.setPagamento(paxDetails.getPagamento());
			updatePax.setDestino(destino);
			updatePax.setViagem(viagem);
			
			
			
			return ResponseEntity.ok(updatePax);
			
		}
		
		// DELETE
		@DeleteMapping("{id_pax}")
		public ResponseEntity<HttpStatus> delete(@PathVariable long id_pax){
			Pax pax = paxRepository.findById(id_pax).get();
			paxRepository.delete(pax);
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	}


