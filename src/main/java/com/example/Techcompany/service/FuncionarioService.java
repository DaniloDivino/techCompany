package com.example.Techcompany.service;

import com.example.Techcompany.model.Funcionario;
import com.example.Techcompany.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    public Funcionario consultarFuncionarioPorId(Long id) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        return  funcionario.get();
    }

    public Funcionario cadastrarFuncionario(Funcionario novoFuncionario) {
        Funcionario funcionarioCadastrado = funcionarioRepository.save(novoFuncionario);
        return funcionarioCadastrado;
    }
}
