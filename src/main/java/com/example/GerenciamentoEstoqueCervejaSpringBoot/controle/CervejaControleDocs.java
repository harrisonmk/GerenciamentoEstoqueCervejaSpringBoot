
package com.example.GerenciamentoEstoqueCervejaSpringBoot.controle;

import com.example.GerenciamentoEstoqueCervejaSpringBoot.dto.CervejaDTO;
import com.example.GerenciamentoEstoqueCervejaSpringBoot.excecoes.BeerAlreadyRegisteredException;
import com.example.GerenciamentoEstoqueCervejaSpringBoot.excecoes.BeerNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "Gerencia o estoque de cerveja")
public interface CervejaControleDocs {
    
    
    @Operation(summary = "Operação de criação de cerveja")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Criação de cerveja com sucesso"),
            @ApiResponse(responseCode = "400", description = "Campos obrigatórios vazio ou valor no campo incorreto.")
    })
    CervejaDTO createBeer(CervejaDTO beerDTO) throws BeerAlreadyRegisteredException;

    @Operation(summary = "Retorna a cerveja encontrada por um determinado nome")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cerveja encontrada com sucesso no sistema"),
            @ApiResponse(responseCode = "404", description = "Cerveja com nome não encontrado.")
    })
    CervejaDTO findByName(@PathVariable String name) throws BeerNotFoundException;

    @Operation(summary = "Retorna uma lista de todas as cervejas cadastradas no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de todas as cervejas cadastradas no sistema"),
    })
    List<CervejaDTO> listBeers();

    @Operation(summary = "Excluir uma cerveja encontrada por um determinado ID válido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Cerveja deletado com sucesso do sistema"),
            @ApiResponse(responseCode = "404", description = "Cerveja com o ID fornecido não encontrado.")
    })
    void deleteById(@PathVariable Long id) throws BeerNotFoundException;
    
    
}
