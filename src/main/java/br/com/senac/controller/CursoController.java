package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.model.Curso;
import br.com.senac.service.CursoService;
import br.com.senac.service.ProfessorService;

@Controller
@RequestMapping("curso")
public class CursoController {
	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private ProfessorService professorService;
	

	@GetMapping("/listarCursos")	
	public ModelAndView buscarTodosCursos() {
		ModelAndView mv = new ModelAndView("curso/paginaListaCurso");
		mv.addObject("cursos",cursoService.buscarTodosCursos());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarCurso() {
		ModelAndView mv = new ModelAndView("curso/cadastraCurso");
		mv.addObject("curso", new Curso());
		mv.addObject("professores",professorService.buscarTodosProfessores());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarCurso(Curso curso) {
		cursoService.salvar(curso);
		return buscarTodosCursos();
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView excluirCurso(@PathVariable ("id") Integer id) {
		cursoService.excluir(id);
		return buscarTodosCursos();
	}
}
