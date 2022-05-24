
package com.example.GerenciamentoEstoqueCervejaSpringBoot.servico;

import com.example.GerenciamentoEstoqueCervejaSpringBoot.dto.CervejaDTO;
import com.example.GerenciamentoEstoqueCervejaSpringBoot.excecoes.BeerAlreadyRegisteredException;
import com.example.GerenciamentoEstoqueCervejaSpringBoot.excecoes.BeerNotFoundException;
import com.example.GerenciamentoEstoqueCervejaSpringBoot.excecoes.BeerStockExceededException;
import com.example.GerenciamentoEstoqueCervejaSpringBoot.mapper.CervejaMapper;
import com.example.GerenciamentoEstoqueCervejaSpringBoot.modelo.Cerveja;
import com.example.GerenciamentoEstoqueCervejaSpringBoot.repositorio.CervejaRepositorio;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CervejaServico {
    
    
    
    private final CervejaRepositorio cervejaRepositorio;
     
    private final CervejaMapper cervejaMapper = CervejaMapper.INSTANCE;
    
    

    public CervejaDTO createBeer(CervejaDTO beerDTO) throws BeerAlreadyRegisteredException {
        verifyIfIsAlreadyRegistered(beerDTO.getNome());
        Cerveja beer = cervejaMapper.toModel(beerDTO);
        Cerveja savedBeer = cervejaRepositorio.save(beer);
        return cervejaMapper.toDTO(savedBeer);
    }

    public CervejaDTO findByNome(String nome) throws BeerNotFoundException {
        Cerveja foundBeer = cervejaRepositorio.findByNome(nome)
                .orElseThrow(() -> new BeerNotFoundException(nome));
        return cervejaMapper.toDTO(foundBeer);
    }

    public List<CervejaDTO> listAll() {
        return cervejaRepositorio.findAll()
                .stream()
                .map(cervejaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) throws BeerNotFoundException {
        verifyIfExists(id);
        cervejaRepositorio.deleteById(id);
    }

    private void verifyIfIsAlreadyRegistered(String nome) throws BeerAlreadyRegisteredException {
        Optional<Cerveja> optSavedBeer = cervejaRepositorio.findByNome(nome);
        if (optSavedBeer.isPresent()) {
            throw new BeerAlreadyRegisteredException(nome);
        }
    }

    private Cerveja verifyIfExists(Long id) throws BeerNotFoundException {
        return cervejaRepositorio.findById(id)
                .orElseThrow(() -> new BeerNotFoundException(id));
    }

    public CervejaDTO increment(Long id, int quantityToIncrement) throws BeerNotFoundException, BeerStockExceededException {
        Cerveja beerToIncrementStock = verifyIfExists(id);
        int quantityAfterIncrement = quantityToIncrement + beerToIncrementStock.getQuantidade();
        if (quantityAfterIncrement <= beerToIncrementStock.getMaximo()) {
            beerToIncrementStock.setQuantidade(beerToIncrementStock.getQuantidade() + quantityToIncrement);
            Cerveja incrementedBeerStock = cervejaRepositorio.save(beerToIncrementStock);
            return cervejaMapper.toDTO(incrementedBeerStock);
        }
        throw new BeerStockExceededException(id, quantityToIncrement);
    }
    
    
    
    
}
