package tech.devinhouse.m01s09springdata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.m01s09springdata.models.Pet;
import tech.devinhouse.m01s09springdata.services.PetService;

import java.util.List;

@RestController
@RequestMapping(path = "pet")
public class PetController {

    @Autowired private PetService petService;

    @GetMapping
    public List<Pet> get(String nome, Integer pagina, Integer tamanho) {
        if (nome != null && !nome.isEmpty()) {
            return petService.get(nome);
        }
//        return petService.get();
        return petService.get(pagina, tamanho);
    }

    @GetMapping(path = "findByTutor")
    public List<Pet> findByTutor(String nome) {
        return petService.getByTutor(nome);
    }

    @GetMapping(path = "countByTutor")
    public Integer countByTutor(String nome) {
        return petService.countByTutor(nome);
    }

    @GetMapping(path = "findNomeByTutor")
    public List<String> findNomeByTutor(String nome) {
        return petService.findNomeByTutor(nome);
    }

    @PostMapping
    public Pet post(@RequestBody Pet pet) {
        return petService.save(pet);
    }

    @PutMapping
    public Pet put(@RequestBody Pet pet) {
        return petService.save(pet);
    }

    @DeleteMapping
    public boolean delete(Integer id) {
        return petService.remove(id);
    }

}
