package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Tarefa;

@Repository
public interface TarefaRepositorio extends JpaRepository<Tarefa, Integer>{

}
