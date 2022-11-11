package tech.devinhouse.m01s09springdata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.m01s09springdata.models.Servico;
import tech.devinhouse.m01s09springdata.services.ServicoService;

import java.util.List;

@RestController
@RequestMapping(path = "servico")
public class ServicoController {

    @Autowired private ServicoService servicoService;

    @GetMapping
    public List<Servico> get() {
        return servicoService.get();
    }

    @PostMapping
    public Servico post(@RequestBody Servico servico) {
        return servicoService.save(servico);
    }

    @PutMapping
    public Servico put(@RequestBody Servico servico) {
        return servicoService.save(servico);
    }

    @DeleteMapping
    public boolean delete(Integer id) {
        return servicoService.remove(id);
    }

}
