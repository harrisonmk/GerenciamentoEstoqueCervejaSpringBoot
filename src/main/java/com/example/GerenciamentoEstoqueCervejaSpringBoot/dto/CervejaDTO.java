
package com.example.GerenciamentoEstoqueCervejaSpringBoot.dto;

import com.example.GerenciamentoEstoqueCervejaSpringBoot.enums.TipoCerveja;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Builder;


@Builder
public class CervejaDTO {
    
    
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 200)
    private String nome;
    
    @NotNull
    @Size(min = 1, max = 200)
    private String marca;
    
    @NotNull
    @Max(500)
    private int maximo;
    
    @NotNull
    @Max(100)
    private int quantidade;
    
    
    @Enumerated(EnumType.STRING)
    @NotNull
    private TipoCerveja tipo;
    
    
    
    

    public CervejaDTO(Long id, String nome, String marca, int maximo, int quantidade, TipoCerveja tipo) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.maximo = maximo;
        this.quantidade = quantidade;
        this.tipo = tipo;
    }

    public CervejaDTO() {
    }
    
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public TipoCerveja getTipo() {
        return tipo;
    }

    public void setTipo(TipoCerveja tipo) {
        this.tipo = tipo;
    }
    
    
    
    
}
