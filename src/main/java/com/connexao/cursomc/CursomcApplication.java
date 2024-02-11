package com.connexao.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.connexao.cursomc.domain.Categoria;
import com.connexao.cursomc.domain.Cidade;
import com.connexao.cursomc.domain.Cliente;
import com.connexao.cursomc.domain.Endereco;
import com.connexao.cursomc.domain.Estado;
import com.connexao.cursomc.domain.Produto;
import com.connexao.cursomc.domain.enums.TipoCliente;
import com.connexao.cursomc.repositories.CategoriaRepository;
import com.connexao.cursomc.repositories.CidadeRepository;
import com.connexao.cursomc.repositories.ClienteRepository;
import com.connexao.cursomc.repositories.EnderecoRepository;
import com.connexao.cursomc.repositories.EstadoRepository;
import com.connexao.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired 
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null,"Computador", 2000.00);
		Produto p2 = new Produto(null,"Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Campinas",est1);
		Cidade c2 = new Cidade(null, "São Paulo",est1);
		Cidade c3 = new Cidade(null, "Uberlândia",est2);
		
		est2.getCidades().addAll(Arrays.asList(c1,c2));
		est1.getCidades().addAll(Arrays.asList(c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cliente = new Cliente(null,"Jurandir Ricardo","jurandir.silva@cimapi.com.br","11336841818",TipoCliente.PESSOAFISICA);
		cliente.getTelefones().addAll(Arrays.asList("11913143901","11970631717"));
		
		Endereco endereco = new Endereco(null,"Rua Ceará","47","Casa","Vila Eliza","07865500",cliente,c1);
		Endereco endereco1 = new Endereco(null,"Rua Tiers","533","2ºAndar","Canindé","03031-000",cliente,c1);
		
		cliente.getEnderecos().addAll(Arrays.asList(endereco, endereco1));
		
		clienteRepository.saveAll(Arrays.asList(cliente));
		enderecoRepository.saveAll(Arrays.asList(endereco,endereco1));		
		
	}

}
