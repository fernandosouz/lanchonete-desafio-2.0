package com.example.startup.demo.controllers;

import com.example.startup.demo.model.entities.IngredientesLanchesPedidos;
import com.example.startup.demo.model.entities.LanchesPedidos;
import com.example.startup.demo.model.entities.dados.Ingrediente;
import com.example.startup.demo.model.entities.dados.Promocao;
import com.example.startup.demo.model.repository.IngredienteRepository;
import com.example.startup.demo.model.repository.PromocaoRepository;
import com.example.startup.demo.utils.Constantes;
import java.util.List;

/**
 * Criado por  Fernando Henrique de Souza em 26/02/19.
 */

/**
 * Classe que simula o repositório de informações da entidade "Promoção".
 */
public class LancheController {

    LanchesPedidos lanche;

    IngredienteRepository ingredienteRepository;
    PromocaoRepository promocaoRepository;

    /**
     *
     *  Construtor que define lanche que será manipulado.
     **/
    public LancheController(LanchesPedidos lanche) {
        this.lanche = lanche;
    }

    /**
     *
     * Construtor default
     **/
    public LancheController() {

    }

    public LanchesPedidos getLanche() {
        return lanche;
    }

    public void setLanche(LanchesPedidos lanche) {
        this.lanche = lanche;
    }

    private void aplicaPromocao(Long codigoDaPromocao, Object objetoNulo){
        aplicaPromocao(codigoDaPromocao, 1);
    }

    /**Método que aplica uma determina promoção no valor com desconto do lanche
     *
     * Esse método define o cálculo que será aplicado em cada promoção, definindo o valor com desconto do lanche.
     *
     * A quantidade de vezes que a promoção "Light" será aplicada é sempre 1, pois não depende da quantidade de porções
     * de um ingrediente específico
     *
     * @author Fernando Henrique de Souza
     * @param codigoDaPromocao Código da promoção que será aplicada
     * @param quantidadeDeAplicacoes Quantidade de vezes que a promoção será aplicada
     */
    private void aplicaPromocao(Long codigoDaPromocao, int quantidadeDeAplicacoes){
        if(codigoDaPromocao == 1){
            quantidadeDeAplicacoes = 1;
        }

        Promocao promocao = promocaoRepository.findById(codigoDaPromocao).get();
        lanche.getPromocoes().add(promocao);
        promocao.setQuantidadeDeAplicacoes(quantidadeDeAplicacoes);
        double valorASerDescontado = 0.0;
        valorASerDescontado = promocao.getCalculadoraDePromocao().calcula(this.lanche);
        promocao.setCalculadoraDePromocao(null);

        lanche.setValorComDesconto(lanche.getValorComDesconto() - valorASerDescontado);
    }

    /**Esse método contém a regra de negócio que informa se a promoção deve ou não ser aplicada.
     *
     *
     * @author Fernando Henrique de Souza
     * @param codigoDaPromocao Código da promoção que será aplicada
     * @return boolean que representa se o lanche participa da promoção
     */
    private Boolean participaDaPromocao(Long codigoDaPromocao) {
        /*Strategy*/
        switch (codigoDaPromocao.intValue()) {
            case 1:
                Ingrediente ingredienteAlface = ingredienteRepository.findById(Constantes.CODIGO_ALFACE).get();
                Ingrediente ingredienteBacon = ingredienteRepository.findById(Constantes.CODIGO_BACON).get();

                return lanche.getIngredientes().stream().filter(o -> o.getIngrediente().equals(ingredienteAlface)).findFirst().isPresent() &&
                !lanche.getIngredientes().stream().filter(o -> o.getIngrediente().equals(ingredienteBacon)).findFirst().isPresent();

            case 2:
                /*Se tem 3 ou mais porções de hambúrguer de carne*/
                Ingrediente ingredienteHamburguerDeCarne = ingredienteRepository.findById(Constantes.CODIGO_HAMBURGUER_CARNE).get();
                return 0 < (int) lanche.getIngredientes().stream().filter(
                        o -> o.getIngrediente().equals(ingredienteHamburguerDeCarne)).findFirst().get()
                        .getQuantidade() / 3;
            case 3:
                /*Se tem 3 ou mais porções de queijo*/
                Ingrediente ingredienteQueijo = ingredienteRepository.findById(Constantes.CODIGO_QUEIJO).get();
                return 0 < (int) lanche.getIngredientes().stream().filter(
                        o -> o.getIngrediente().equals(ingredienteQueijo)).findFirst().get()
                        .getQuantidade() / 3;
            default: return false;
        }
    }

    /**Método que verifica se o lanche participa da promoção e chama o método que aplica as alterações.
     *
     * @author Fernando Henrique de Souza
     */
    public void aplicaPromocoes(){
        if(participaDaPromocao(Constantes.CODIGO_PROMO_LIGHT)){
            aplicaPromocao(Constantes.CODIGO_PROMO_LIGHT, null);
        }
        if(participaDaPromocao(Constantes.CODIGO_PROMO_MUITA_CARNE)){
            aplicaPromocao(Constantes.CODIGO_PROMO_MUITA_CARNE, retornaQuantidadeDeAplicacoesPorCodigoDeProduto(Constantes.CODIGO_HAMBURGUER_CARNE));
        }
        if(participaDaPromocao(Constantes.CODIGO_PROMO_MUITO_QUEIJO)){
            aplicaPromocao(Constantes.CODIGO_PROMO_MUITO_QUEIJO, retornaQuantidadeDeAplicacoesPorCodigoDeProduto(Constantes.CODIGO_QUEIJO));
        }
    }


    public int retornaQuantidadeDeAplicacoesPorCodigoDeProduto(Long codigoDoIngrediente){
        Ingrediente ingrediente = ingredienteRepository.findById(codigoDoIngrediente).get();
        return (int) this.lanche.getIngredientes().stream().filter(
                o -> o.getIngrediente().equals(codigoDoIngrediente)).findFirst().get()
                .getQuantidade() / 3;
    }

    /**Esse método que adiciona o ingrediente ao lanche pela quantidade.
     *
     *
     * @author Fernando Henrique de Souza
     * @param codigoDoIngrediente Código da promoção que será aplicada
     * @param quantidade Código da promoção que será aplicada
     */
    public void adicionarIngredientePorCodigoEQuantidade(Long codigoDoIngrediente, Integer quantidade){
        Ingrediente ingrediente = ingredienteRepository.findById(codigoDoIngrediente).get();


        IngredientesLanchesPedidos ingredientesLanchesPedidos = new IngredientesLanchesPedidos();
        ingredientesLanchesPedidos.setQuantidade(quantidade);
        ingredientesLanchesPedidos.setIngrediente(ingrediente);
    }


    /**Esse método chama o método que adiciona os ingredientes no lanche e o método que aplica as promoções.
     *
     * @author Fernando Henrique de Souza
     * @param ingredienteList lista de ingredientes que será adicionada ao lanche
     * @return Lanche com as alterações
     */
    public LanchesPedidos aplicarAlteracoes(List<IngredientesLanchesPedidos> ingredienteList){

        ingredienteList.forEach(i -> {
                if(i.getQuantidade() == 0)  return;
                i.setIngrediente(ingredienteRepository.findById(i.getIngrediente_id()).get());
                lanche.getIngredientes().add(i);
        });

        aplicaPromocoes();

        return lanche;
    }
}
