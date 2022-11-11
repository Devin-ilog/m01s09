package tech.devinhouse.m01s09springdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.m01s09springdata.models.Servico;

import java.util.List;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {

    List<Servico> findByAtivoTrueOrderByNome();

    Servico findByIdAndAtivoTrue(Integer id);

}
