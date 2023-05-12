package br.com.senac.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.senac.config.PessoaDetails;
import br.com.senac.model.Pessoa;
import br.com.senac.repository.PessoaRepository;

public class PessoaDetailService implements UserDetailsService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Pessoa> pessoa = pessoaRepository.findByNome(username);
		
		if(pessoa == null) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		
		
		return new PessoaDetails(pessoa.get());
	}

	
}
