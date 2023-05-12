package br.com.senac.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.model.Pessoa;

@Repository
public interface PessoaRepository  extends JpaRepository<Pessoa, Integer>{

	Optional<Pessoa> findByNome(String username);
}
