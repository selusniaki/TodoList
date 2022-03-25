package br.com.TodoList.todolist.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.TodoList.todolist.entity.Tarefas;
import br.com.TodoList.todolist.service.TarefasService;

@CrossOrigin(origins = { "http://localhost:8080" })
@RestController
public class ControllerTarefas {
	
	@Autowired
	private TarefasService tarefasService;
	private final Logger logger = org.slf4j.LoggerFactory.getLogger(ControllerTarefas.class);
	
	@PostMapping("/cadastrarTarefaUnica")
	public Tarefas cadastrarTarefas(@RequestBody Tarefas tarefas) {
		return tarefasService.cadastrarTarefa(tarefas);
	}
	
	@GetMapping("/tarefas")
	public List<Tarefas> buscarTodasTarefas() {
		return tarefasService.buscarTarefas();
	}
	
	@GetMapping("/tarefas/{id}")
	public Tarefas buscarTodasTarefaPorId(@PathVariable int id) {
		return tarefasService.buscarTarefaPorId(id);
	}
	
	@PutMapping("/atualizar")
	public Tarefas alterarTarefa(@RequestBody Tarefas tarefa){
		return tarefasService.editarTarefa(tarefa);
	}
	
	@DeleteMapping("/deletar/{id}")
	public String deletarTarefa(@PathVariable int id) {
		return tarefasService.deletarTarefa(id);
	}
	
}


