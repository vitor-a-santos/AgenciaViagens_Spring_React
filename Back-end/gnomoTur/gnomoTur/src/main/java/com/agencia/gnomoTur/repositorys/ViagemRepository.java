package com.agencia.gnomoTur.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.agencia.gnomoTur.entities.Viagem;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Long> {
	

}