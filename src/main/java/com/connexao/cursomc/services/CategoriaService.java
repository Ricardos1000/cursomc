package com.connexao.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connexao.cursomc.domain.Categoria;
import com.connexao.cursomc.repositories.CategoriaRepository;
import com.connexao.cursomc.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	//Retorna a Categoria do produto localizada na base de dados
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " 
															+ id + ", Tipo: " 
															+ Categoria.class.getName()));
		
		return obj.orElse(null);
	}

}
