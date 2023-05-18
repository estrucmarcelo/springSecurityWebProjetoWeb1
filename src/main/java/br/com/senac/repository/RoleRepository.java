package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String>{

}
