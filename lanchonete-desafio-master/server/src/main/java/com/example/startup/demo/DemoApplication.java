package com.example.startup.demo;

import com.example.startup.demo.model.entities.dados.Ingrediente;
import com.example.startup.demo.model.entities.dados.Lanche;
import com.example.startup.demo.model.entities.dados.Promocao;
import com.example.startup.demo.model.entities.IngredientesLanchesPedidos;
import com.example.startup.demo.model.entities.LanchesPedidos;
import com.example.startup.demo.model.repository.LancheRepository;
import com.example.startup.demo.model.repository.LanchesPedidosRepository;
import com.example.startup.demo.model.repository.IngredientesLanchesPedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Criado por Fernando Henrique de Souza em 23/02/19
 */


/**
 * Inicia a aplicação.
 */
@SpringBootConfiguration
@EnableAutoConfiguration
public class DemoApplication {

	@Autowired
	private static IngredientesLanchesPedidosRepository tagRepository;

	@Autowired
	private static LancheRepository lancheRepository;

	@Autowired
	private static LanchesPedidosRepository postRepository;

	public DemoApplication(LanchesPedidosRepository postRepository,
						   IngredientesLanchesPedidosRepository tagRepository,
						   LancheRepository lancheRepository){
		this.postRepository = postRepository;
		this.tagRepository = tagRepository;
		this.lancheRepository = lancheRepository;
	}

	/**
	 * Primeiro método executado na aplicação.
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		// Create a Post

		Lanche lanche = lancheRepository.findById(1L).get();
		System.out.println("1010101");
		/*LanchesPedidos lanche = new LanchesPedidos();
		lanche.setLanche(new Lanche(1L));

		// Create two tags
		IngredientesLanchesPedidos ingrediente1 = new IngredientesLanchesPedidos();
		IngredientesLanchesPedidos ingrediente2 = new IngredientesLanchesPedidos();

		ingrediente1.setIngrediente(new Ingrediente(1L));
		ingrediente2.setIngrediente(new Ingrediente(1L));

		List list = new ArrayList();
		list.add(ingrediente1);
		list.add(ingrediente2);

		lanche.setIngredientes(list);


		Set listPromocao = new HashSet<>();
		((HashSet) listPromocao).add(new Promocao(1L));

		lanche.setPromocoes(listPromocao);

		postRepository.save(lanche);

		Long a = Integer.toUnsignedLong(168);
		LanchesPedidos l = postRepository.findById(a).get();

		System.out.println("aaaa");*/
	}
}
