package tech.devinhouse.m01s09springdata.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.m01s09springdata.models.Pet;
import tech.devinhouse.m01s09springdata.repositories.PetRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired private PetRepository petRepository;

    public List<Pet> get() {
        return petRepository.findAll();
    }
    public List<Pet> get(String nome) {
        return petRepository.findByNomeContaining(nome);
    }

    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    public boolean remove(Integer id) {
        try {
            Optional<Pet> pet = petRepository.findById(id);
            if (pet.isEmpty())
                return false;

            petRepository.delete(pet.get());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Pet> getByTutor(String nome) {
        return petRepository.findByTutorNome(nome);
    }

    public Integer countByTutor(String nome) {
        return petRepository.countByTutorNome(nome);
    }

    public List<String> findNomeByTutor(String nome) {
        return petRepository.findNomeByTutor(nome);
    }

}
