package com.connexao.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.connexao.cursomc.domain.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria,Integer>{
	
	
}
