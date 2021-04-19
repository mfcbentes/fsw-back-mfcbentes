package br.com.mfcbentes.fullstackweek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.mfcbentes.fullstackweek.domain.Pessoa;


public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
