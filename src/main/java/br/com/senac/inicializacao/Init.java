package br.com.senac.inicializacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.model.Aluno;
import br.com.senac.model.Curso;
import br.com.senac.model.Pessoa;
import br.com.senac.model.Professor;
import br.com.senac.service.AlunoService;
import br.com.senac.service.CursoService;
import br.com.senac.service.PessoaService;
import br.com.senac.service.ProfessorService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	AlunoService alunoService;
	@Autowired
	CursoService cursoService;
	
	@Autowired
	ProfessorService professorService;
	
	@Autowired
	PessoaService pessoaService;
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Lucas");
		alunoService.salvar(aluno1);
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Arthur");
		alunoService.salvar(aluno2);
		
		Aluno aluno3 = new Aluno();
		aluno3.setNome("Jose");
		alunoService.salvar(aluno3);
		
		Curso curso = new Curso();
		curso.setNome("SpringBoot");
		
		Professor professor = new Professor();
		professor.setNome("Marcelo Estruc");
		professorService.salvar(professor);
		
		curso.setProfessor(professor);
		cursoService.salvar(curso);
		
		
		
		List<Aluno> alunos = alunoService.buscarTodosAlunos();
		
		for(Aluno aluno : alunos) {
			System.out.println(aluno.getNome());
		}
		
		
		
		Pessoa p1 = new Pessoa();
		p1.setNome("Estruc");
		p1.setSenha("123");
		
		pessoaService.create(p1);
		
		Pessoa p2 = new Pessoa();
		p2.setNome("Lucas");
		p2.setSenha("123");
		
		
		pessoaService.create(p2);
		
		
	}
}
