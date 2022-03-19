package com.agencia.gnomoTur.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agencia.gnomoTur.entities.Destino;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Long> {
	

}