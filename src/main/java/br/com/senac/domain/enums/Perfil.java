package br.com.senac.domain.enums;

import org.springframework.security.core.GrantedAuthority;


public enum Perfil implements GrantedAuthority {

	
	ADMIN("ROLE_ADMIN"),USER("ROLE_USER");
	
	private String descricao;
	
	Perfil(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

	@Override
	public String getAuthority() {
		return this.descricao;
	}
	
	
	
	
}
