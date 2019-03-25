package com.example.startup.demo.model.entities;

import com.example.startup.demo.model.entities.dados.Lanche;
import com.example.startup.demo.model.entities.dados.Promocao;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name = "lanches_pedidos")
public class LanchesPedidos {
    @Id
    @GeneratedValue
    private Long id;

    @Size(max = 250)
    private String observacoes;

    /*Vários LanchesPedidos pode ser associados a um Lanche*/
    @ManyToOne
    @JoinColumn(name = "lanche_id")
    private Lanche lanche;

    /*Um Lanche Pedido pode ter vários IngredientesLanchesPedidos (IngredienteLanchesPEdidos != Ingrediente)*/
    @OneToMany(mappedBy="lanches_pedidos", cascade = CascadeType.ALL, fetch= FetchType.EAGER)
    private List<IngredientesLanchesPedidos> ingredientes;

    /*Vários LanchesPedidos podem participar de várias Promocoes*/
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "lanches_pedidos_promocao",
            joinColumns = { @JoinColumn(name = "lanches_pedidos") },
            inverseJoinColumns = { @JoinColumn(name = "promocao") })
    private Set<Promocao> promocoes = new HashSet<>();

    private double valorTotal;
    private double valorComDesconto;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "posted_at")
    private Date postedAt = new Date();

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_updated_at")
    private Date lastUpdatedAt = new Date();

    public LanchesPedidos() {

    }

    public double getValorTotal(){
        double ret = 0;
        for(IngredientesLanchesPedidos i : this.getIngredientes()){
            ret += i.getIngrediente().getValor();
        }
        return ret;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorComDesconto() {
        return valorComDesconto;
    }

    public void setValorComDesconto(double valorComDesconto) {
        this.valorComDesconto = valorComDesconto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Lanche getLanche() {
        return lanche;
    }

    public void setLanche(Lanche lanche) {
        this.lanche = lanche;
    }

    public Date getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Date postedAt) {
        this.postedAt = postedAt;
    }

    public Date getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Date lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public List<IngredientesLanchesPedidos> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredientesLanchesPedidos> ingredientes) {
        this.ingredientes = ingredientes;

        ingredientes.forEach(i -> i.setLanches_pedidos(this));
    }

    public Set<Promocao> getPromocoes() {
        return promocoes;
    }

    public void setPromocoes(Set<Promocao> promocoes) {
        this.promocoes = promocoes;
    }
}