package tech.devinhouse.m01s09springdata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.m01s09springdata.models.Pessoa;
import tech.devinhouse.m01s09springdata.repositories.PessoaRepository;
import tech.devinhouse.m01s09springdata.services.PessoaService;

import java.util.List;

@RestController
@RequestMapping(path = "pessoa")
public class PessoaController {

    @Autowired private PessoaService pessoaService;

    @GetMapping
    public List<Pessoa> get() {
        return pessoaService.findAll();
    }

    @PostMapping
    public Pessoa post(@RequestBody Pessoa pessoa) {
        return pessoaService.save(pessoa);
    }

}
