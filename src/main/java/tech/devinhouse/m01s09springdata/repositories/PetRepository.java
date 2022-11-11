package tech.devinhouse.m01s09springdata.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tech.devinhouse.m01s09springdata.models.Pet;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {

    List<Pet> findByNomeContaining(String nome, Sort sort);

    List<Pet> findByNomeContaining(String nome, Pageable pageable);

    // DerivedQueries
    List<Pet> findByNomeContainingOrderById(String nome);

//    // JPQL
//    @Query("SELECT p FROM Pet p WHERE p.nome LIKE %:nome%")
//    List<Pet> findByNomeContaining(String nome);

//    // SQL Nativo
//    @Query(value = "SELECT * FROM pet p WHERE p.nome LIKE %:nome%", nativeQuery = true)
//    List<Pet> findByNomeContaining(String nome);

    /*
     * SELECT p.* FROM pet p
     * JOIN tutor t ON t.id = p.tutor_id
     * WHERE t.nome = :nomeTutor
     */
    @Query("SELECT p FROM Pet p WHERE p.tutor.nome = :nomeTutor")
    List<Pet> findByTutorNome(String nomeTutor);

    @Query("SELECT COUNT(p) FROM Pet p WHERE p.tutor.nome = :nomeTutor")
    Integer countByTutorNome(String nomeTutor);

    @Query("SELECT p.nome FROM Pet p WHERE p.tutor.nome = :nomeTutor")
    List<String> findNomeByTutor(String nomeTutor);

}
