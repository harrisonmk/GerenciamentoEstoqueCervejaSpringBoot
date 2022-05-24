
package com.example.GerenciamentoEstoqueCervejaSpringBoot.mapper;

import com.example.GerenciamentoEstoqueCervejaSpringBoot.dto.CervejaDTO;
import com.example.GerenciamentoEstoqueCervejaSpringBoot.modelo.Cerveja;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CervejaMapper {
    
    CervejaMapper INSTANCE = Mappers.getMapper(CervejaMapper.class);

    Cerveja toModel(CervejaDTO cervejaDTO);

    CervejaDTO toDTO(Cerveja cerveja);
    
}
