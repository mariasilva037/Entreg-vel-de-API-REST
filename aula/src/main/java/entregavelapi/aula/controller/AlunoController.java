package entregavelapi.aula.controller;

import entregavelapi.aula.entity.Aluno;
import entregavelapi.aula.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    // 1. Endpoint do Desafio (GET com Query Params)
    @GetMapping("/identificacao")
    public String obterIdentificacao(@RequestParam String nome, @RequestParam String ra) {
        return "O RA do aluno " + nome + " é " + ra;
    }

    // 2. Endpoint para listar todos os alunos cadastrados no PostgreSQL
    @GetMapping
    public List<Aluno> listarTodos() {
        return alunoService.listarTodos();
    }

    // 3. Endpoint POST para salvar um novo aluno no PostgreSQL
    @PostMapping
    public ResponseEntity<Aluno> salvarAluno(@RequestBody Aluno aluno) {
        Aluno novoAluno = alunoService.salvar(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAluno);
    }
}