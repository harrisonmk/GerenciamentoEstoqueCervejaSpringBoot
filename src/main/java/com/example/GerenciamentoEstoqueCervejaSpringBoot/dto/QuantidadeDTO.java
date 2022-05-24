package com.example.GerenciamentoEstoqueCervejaSpringBoot.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import lombok.Builder;


@Builder
public class QuantidadeDTO {

    @NotNull
    @Max(100)
    private Integer quantidade;

    
    
    
    public QuantidadeDTO(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public QuantidadeDTO() {
    }


    
    
    public Integer getQuantidade() {
        return quantidade;
    }

  
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    
    

}
