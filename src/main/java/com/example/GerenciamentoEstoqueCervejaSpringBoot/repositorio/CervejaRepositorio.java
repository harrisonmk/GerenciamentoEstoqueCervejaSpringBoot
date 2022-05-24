
package com.example.GerenciamentoEstoqueCervejaSpringBoot.repositorio;

import com.example.GerenciamentoEstoqueCervejaSpringBoot.modelo.Cerveja;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CervejaRepositorio extends JpaRepository<Cerveja, Long> {
    
   Optional<Cerveja> findByNome(String nome); 
    
}
