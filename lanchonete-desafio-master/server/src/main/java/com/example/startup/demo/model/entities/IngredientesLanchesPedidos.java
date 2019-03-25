package com.example.startup.demo.model.entities;

import com.example.startup.demo.model.entities.dados.Ingrediente;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "ingredientes_lanches_pedidos")
public class   IngredientesLanchesPedidos {
    @Id
    @GeneratedValue
    private Long id;

    private int quantidade;

    /*Vários IngredientesLanchesPedidos podem ser associados a um Ingrediente*/
    @ManyToOne
    @JoinColumn(name = "ingrediente_id")
    private Ingrediente ingrediente;

    @Transient
    private Long ingrediente_id;

    /*Vários IngredientesLanchesPedidos podem ser associados a um Lanche Pedido*/
    @ManyToOne
    @JoinColumn (name="lanche_id")
    private LanchesPedidos lanches_pedidos;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "posted_at")
    private Date postedAt = new Date();

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_updated_at")
    private Date lastUpdatedAt = new Date();

    public IngredientesLanchesPedidos() {

    }

    public Long getIngrediente_id() {
        return ingrediente_id;
    }

    public void setIngrediente_id(Long ingrediente_id) {
        this.ingrediente_id = ingrediente_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public LanchesPedidos getLanches_pedidos() {
        return lanches_pedidos;
    }

    public void setLanches_pedidos(LanchesPedidos lanches_pedidos) {
        this.lanches_pedidos = lanches_pedidos;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}