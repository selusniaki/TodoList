package com.example.demo.controller;

import org.springframework.stereotype.Component;

@Component(value = "tarefacontroller")
public class TarefaController {
	
	public String loadAnotacaoPage() {
        return "/home.xhtml";
    }

}
