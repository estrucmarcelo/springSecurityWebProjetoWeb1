package br.com.senac.config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.senac.model.Pessoa;

public class PessoaDetails implements UserDetails {

	private String nome;
	private String senha;
	
	
	
	public PessoaDetails(Pessoa pessoa) {
		nome = pessoa.getNome();
		senha = pessoa.getSenha();
		
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return (Collection<? extends GrantedAuthority>) null;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return nome;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	
}
