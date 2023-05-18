package br.com.senac.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.senac.model.Pessoa;
import br.com.senac.repository.PessoaRepository;

@Service
public class PessoaService {

	public BCryptPasswordEncoder encoder;
	
	@Autowired
	private PessoaRepository pessoaRepository; 
	
	public PessoaService(BCryptPasswordEncoder encoder) {
		this.encoder = encoder;
	}
	
	
	
	public Pessoa create(Pessoa pessoa) {
		
		pessoa.setSenha(encoder.encode(pessoa.getSenha()));
		List perfil = new ArrayList();
		
		return pessoaRepository.save(pessoa);
	}
	
}
