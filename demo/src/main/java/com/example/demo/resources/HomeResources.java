package com.example.demo.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Tarefa;
import com.example.demo.repositories.TarefaRepositorio;

@RestController
@RequestMapping(path = "/tarefa")
public class HomeResources {
	
	private TarefaRepositorio tarefaRepositorio; 
	
	public HomeResources(TarefaRepositorio tarefaRepositorio) {
		super();
		this.tarefaRepositorio = tarefaRepositorio;
	}
	
	@PostMapping("/cadastrarTarefa")
	public ResponseEntity<Tarefa> cadastrarTarefas(@RequestBody Tarefa tarefa) {
			tarefaRepositorio.save(tarefa);
		return new ResponseEntity<Tarefa>(tarefa, HttpStatus.OK);
	}
	
	@GetMapping("/tarefas")
	public ResponseEntity<Tarefa> buscarTodasTarefas() {
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		tarefas = tarefaRepositorio.findAll();
		return new ResponseEntity<Tarefa>((Tarefa) tarefas, HttpStatus.OK);
	}
	
	@GetMapping("/tarefas/{id}")
	public ResponseEntity<Optional<Tarefa>> buscarTodasTarefaPorId(@PathVariable int id) {
		Optional<Tarefa> tarefa;
		try {
			tarefa = tarefaRepositorio.findById(id);
			return new ResponseEntity<Optional<Tarefa>>(tarefa, HttpStatus.OK);
		}catch (NoSuchElementException nsee) {
			return new ResponseEntity<Optional<Tarefa>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Tarefa> alterarTarefa(@PathVariable Integer id, @RequestBody Tarefa newtarefa){
		return tarefaRepositorio.findById(id).map(tarefa -> {
			tarefa.setNome(newtarefa.getNome());
			tarefa.setDescricao(newtarefa.getDescricao());
			Tarefa tarefaAtulaizada = tarefaRepositorio.save(tarefa);
			return  ResponseEntity.ok().body(tarefaAtulaizada);
		}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Optional<Tarefa>> deletarTarefa(@PathVariable int id) {
		try {
			tarefaRepositorio.deleteById(id);
			return new ResponseEntity<Optional<Tarefa>>(HttpStatus.OK);
		}catch (NoSuchElementException nsee) {
			return new ResponseEntity<Optional<Tarefa>>(HttpStatus.NOT_FOUND);
		}
	}

}
