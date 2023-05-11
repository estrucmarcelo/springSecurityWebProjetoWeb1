package br.com.senac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.Turma;
import br.com.senac.repository.TurmaRepository;

@Service
public class TurmaService {
	@Autowired
	private TurmaRepository turmaRepository;
	
	public List<Turma> buscarTodasTurmas(){
		return turmaRepository.findAll();
	}
	
	public Turma salvar(Turma turma) {
		return turmaRepository.save(turma);
	}
	
	public Turma atualizar(Turma turma) {
		return turmaRepository.save(turma);
	}
	
	public void deletarPorId(Integer id) {
		turmaRepository.deleteById(id);
	}
}
