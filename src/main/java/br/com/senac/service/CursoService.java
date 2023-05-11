package br.com.senac.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.Curso;
import br.com.senac.repository.CursoRepository;

@Service
public class CursoService {
	@Autowired
	CursoRepository cursoRepository;
	
	public List<Curso> buscarTodosCursos(){
		return cursoRepository.findAll();
	}
	
	public Curso buscarPorID(Integer id){
		return cursoRepository.findById(id).get();
	}
	
	public Curso salvar(Curso curso) {
		return cursoRepository.save(curso);
	}
	
	public Curso atualizar(Curso curso) {
		return cursoRepository.save(curso);
	}

	public void excluir(Integer id) {
		cursoRepository.deleteById(id);
	}
}
