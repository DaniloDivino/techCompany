package com.example.Techcompany.controller;

import com.example.Techcompany.model.Funcionario;
import com.example.Techcompany.repository.FuncionarioRepository;
import com.example.Techcompany.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/funcionarios")
    public List<Funcionario> getAllFuncionarios() {
        return funcionarioService.findAll();
    }


    @GetMapping(value = "/{id}")
    public Funcionario getFuncionario(@PathVariable("id") Long id) {
        Funcionario funcionarioEncontrado = funcionarioService.consultarFuncionarioPorId(id);
        return funcionarioEncontrado;
    }


    @PostMapping
    public Funcionario novoFuncionario(@RequestBody Funcionario funcionario) {
        Funcionario funcionarioCadastradoComSucesso = funcionarioService.cadastrarFuncionario(funcionario);
        return funcionarioCadastradoComSucesso;
    }
}