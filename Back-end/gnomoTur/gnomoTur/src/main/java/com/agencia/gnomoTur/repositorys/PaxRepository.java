package com.agencia.gnomoTur.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agencia.gnomoTur.entities.Pax;

@Repository
public interface PaxRepository extends JpaRepository<Pax, Long> {
	

}