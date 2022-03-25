package br.com.TodoList.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.TodoList.todolist.entity.Tarefas;
import br.com.TodoList.todolist.repositories.repositorio;

@Service
public class TarefasService {

	@Autowired
	private repositorio tarefasRepositorio;
	
	public Tarefas cadastrarTarefa(Tarefas tarefa) {
		return tarefasRepositorio.save(tarefa);
	}
	
	public List<Tarefas> buscarTarefas(){
		return tarefasRepositorio.findAll();
	}
	
	public Tarefas buscarTarefaPorId(int id) {
		return tarefasRepositorio.findById(id).orElse(null);
	}
	
	public Tarefas editarTarefa(Tarefas tarefa) {
		Tarefas existing_tarefa = tarefasRepositorio.findById(tarefa.getId()).orElse(null);
		existing_tarefa.setNome(tarefa.getNome());
		existing_tarefa.setDescricao(tarefa.getDescricao());
		return tarefasRepositorio.save(existing_tarefa);
	}
	
	public String deletarTarefa(int id) {
		tarefasRepositorio.deleteById(id);
		return "Terafa com o id: " + id + "\nFoi removida!";
	}
}
