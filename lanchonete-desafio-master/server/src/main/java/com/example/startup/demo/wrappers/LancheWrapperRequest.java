package com.example.startup.demo.wrappers;

import com.example.startup.demo.model.entities.IngredientesLanchesPedidos;

import java.util.List;

/**
 * Criado por  Fernando Henrique de Souza em 26/02/19.
 */

/**
 * Classe que empacota as propriedades do objeto recebido no endpoint @see LancheEndPoint#detalhesDoPedido()
 */
public class LancheWrapperRequest {

    private List<IngredientesLanchesPedidos> ingredientes;
    private Long codigoDoLanche;

    public Long getCodigoDoLanche() {
        return codigoDoLanche;
    }

    public void setCodigoDoLanche(Long codigoDoLanche) {
        this.codigoDoLanche = codigoDoLanche;
    }

    public List<IngredientesLanchesPedidos> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredientesLanchesPedidos> ingredientes) {
        this.ingredientes = ingredientes;
    }
}