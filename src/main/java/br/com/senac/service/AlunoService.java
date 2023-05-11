package br.com.senac.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.Aluno;
import br.com.senac.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	public List<Aluno> buscarTodosAlunos(){
		return alunoRepository.findAll();
	}
	
	
	public Aluno buscarPorID(Integer id){
		return alunoRepository.findById(id).get();
	}
	
	public Aluno salvar(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	public Aluno atualizar(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	public void excluir(Integer id) {
		alunoRepository.deleteById(id);
	}

}
