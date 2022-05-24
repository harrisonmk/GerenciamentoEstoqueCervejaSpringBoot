
package com.example.GerenciamentoEstoqueCervejaSpringBoot.controle;

import com.example.GerenciamentoEstoqueCervejaSpringBoot.dto.CervejaDTO;
import com.example.GerenciamentoEstoqueCervejaSpringBoot.dto.QuantidadeDTO;
import com.example.GerenciamentoEstoqueCervejaSpringBoot.excecoes.BeerAlreadyRegisteredException;
import com.example.GerenciamentoEstoqueCervejaSpringBoot.excecoes.BeerNotFoundException;
import com.example.GerenciamentoEstoqueCervejaSpringBoot.excecoes.BeerStockExceededException;
import com.example.GerenciamentoEstoqueCervejaSpringBoot.servico.CervejaService;
import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v1/beers")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CervejaController implements CervejaControleDocs {
    
    
    private final CervejaService servico;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CervejaDTO createBeer(@RequestBody @Valid CervejaDTO beerDTO) throws BeerAlreadyRegisteredException {
        return servico.createBeer(beerDTO);
    }

    @GetMapping("/{name}")
    public CervejaDTO findByName(@PathVariable String nome) throws BeerNotFoundException {
        return servico.findByNome(nome);
    }

    @GetMapping
    public List<CervejaDTO> listBeers() {
        return servico.listAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws BeerNotFoundException {
        servico.deleteById(id);
    }

    @PatchMapping("/{id}/increment")
    public CervejaDTO increment(@PathVariable Long id, @RequestBody @Valid QuantidadeDTO quantityDTO) throws BeerNotFoundException, BeerStockExceededException {
        return servico.increment(id, quantityDTO.getQuantidade());
    }
    
    
    
}
