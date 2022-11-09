package tech.devinhouse.m01s09springdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.m01s09springdata.models.Tutor;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Integer> {
}
