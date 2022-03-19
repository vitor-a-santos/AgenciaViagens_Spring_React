package com.agencia.gnomoTur;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.agencia.gnomoTur.entities.Destino;
import com.agencia.gnomoTur.entities.Pax;
import com.agencia.gnomoTur.entities.Viagem;
import com.agencia.gnomoTur.repositorys.DestinoRepository;
import com.agencia.gnomoTur.repositorys.PaxRepository;
import com.agencia.gnomoTur.repositorys.ViagemRepository;

@SpringBootApplication
public class GnomoTurApplication implements CommandLineRunner {

	@Autowired
	private DestinoRepository destinoRepository;
	
	@Autowired
	private PaxRepository paxRepository;
	
	@Autowired
	private ViagemRepository viagemRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(GnomoTurApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	/*
	
		
	Destino d1 = new Destino(null, "Salvador", "Bahia", "R$ 999");
	Destino d2 = new Destino(null, "Manaus", "Amazonas", "R$ 1199");
	
	Viagem v1 = new Viagem(null, "23/10/2022", "30/10/2022");
	Viagem v2 = new Viagem(null, "01/09/2022", "15/09/2022");
	
	 
	Pax p1 = new Pax(null, "Luan", "25", "99988877766", "Crédito", d1, v1);
	Pax p2 = new Pax(null, "Izadora", "18", "22233344455", "Pix", d2, v2);
	
	
	
	d1.getPaxs().addAll(Arrays.asList(p2));
	d2.getPaxs().addAll(Arrays.asList(p1));
	
	v1.getPaxs().addAll(Arrays.asList(p2));
	v2.getPaxs().addAll(Arrays.asList(p1));
	
	
	destinoRepository.save(d1);
	destinoRepository.save(d2);
	
	viagemRepository.save(v1);
	viagemRepository.save(v2);

	
	
	paxRepository.save(p1);
	paxRepository.save(p2);
	
	*/
}
}