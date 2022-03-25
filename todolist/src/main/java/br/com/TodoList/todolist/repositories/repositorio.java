package br.com.TodoList.todolist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.TodoList.todolist.entity.Tarefas;

@Repository
public interface repositorio extends JpaRepository<Tarefas, Integer>{
	Tarefas findbyName(String nome);
}
