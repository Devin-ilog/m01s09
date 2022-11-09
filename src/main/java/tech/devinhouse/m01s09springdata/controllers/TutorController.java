package tech.devinhouse.m01s09springdata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.m01s09springdata.models.Tutor;
import tech.devinhouse.m01s09springdata.services.TutorService;

import java.util.List;

@RestController
@RequestMapping(path = "tutor")
public class TutorController {

    @Autowired private TutorService tutorService;

    @GetMapping
    public List<Tutor> get() {
        return tutorService.get();
    }

    @PostMapping
    public Tutor post(@RequestBody Tutor tutor) {
        return tutorService.save(tutor);
    }

    @PutMapping
    public Tutor put(@RequestBody Tutor tutor) {
        return tutorService.save(tutor);
    }

    @DeleteMapping
    public boolean delete(Integer id) {
        return tutorService.remove(id);
    }

}
