package com.connexao.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.connexao.cursomc.domain.Cidade;


public interface CidadeRepository extends JpaRepository<Cidade,Integer>{
	
	
}
