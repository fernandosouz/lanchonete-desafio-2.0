package com.example.startup.demo.model.entities.dados;

import com.example.startup.demo.model.entities.LanchesPedidos;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static com.example.startup.demo.model.CalculadorasDePromocao.Promocao.mapadePromocoes;

@Entity
@Table(name = "promocao")
public class Promocao {

    @Id
    @GeneratedValue
    private Long id;

    private String descricao;

    private int quantidadeDeAplicacoes;

    @ManyToMany(mappedBy="promocoes")
    private Set<LanchesPedidos> lanchesPedidos = new HashSet<LanchesPedidos>();

    @Transient
    com.example.startup.demo.model.CalculadorasDePromocao.Promocao calculadoraDePromocao;

    public Promocao() {

    }

    public Promocao(Long id) {
        this.id = id;
        calculadoraDePromocao = mapadePromocoes.get(id);
    }

    public int getQuantidadeDeAplicacoes() {
        return quantidadeDeAplicacoes;
    }

    public void setQuantidadeDeAplicacoes(int quantidadeDeAplicacoes) {
        this.quantidadeDeAplicacoes = quantidadeDeAplicacoes;
    }

    public com.example.startup.demo.model.CalculadorasDePromocao.Promocao getCalculadoraDePromocao() {
        return calculadoraDePromocao;
    }

    public void setCalculadoraDePromocao(com.example.startup.demo.model.CalculadorasDePromocao.Promocao calculadoraDePromocao) {
        this.calculadoraDePromocao = calculadoraDePromocao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<LanchesPedidos> getLanchesPedidos() {
        return lanchesPedidos;
    }

    public void setLanchesPedidos(Set<LanchesPedidos> lanchesPedidos) {
        this.lanchesPedidos = lanchesPedidos;
    }
}
