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
    public List<Pet> get() {
        return petService.get();
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
