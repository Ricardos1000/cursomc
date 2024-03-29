package com.connexao.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connexao.cursomc.domain.Cliente;
import com.connexao.cursomc.repositories.ClienteRepository;
import com.connexao.cursomc.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	//Retorna a Cliente localizada na base de dados
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " 
															+ id + ", Tipo: " 
															+ Cliente.class.getName()));
		
		return obj.orElse(null);
	}

}
