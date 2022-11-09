package tech.devinhouse.m01s09springdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tech.devinhouse.m01s09springdata.models.Pet;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {

    // DerivedQueries
    List<Pet> findByNomeContaining(String nome);

//    // JPQL
//    @Query("SELECT p FROM Pet p WHERE p.nome LIKE %:nome%")
//    List<Pet> findByNomeContaining(String nome);

//    // SQL Nativo
//    @Query(value = "SELECT * FROM pet p WHERE p.nome LIKE %:nome%", nativeQuery = true)
//    List<Pet> findByNomeContaining(String nome);

}
