package tech.devinhouse.m01s09springdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.m01s09springdata.models.Kit;

import java.util.Date;
import java.util.List;

@Repository
public interface KitRepository extends JpaRepository<Kit, Integer> {

    List<Kit> findByAtivoTrueOrderByNome();

    Kit findByIdAndAtivoTrue(Integer id);

    List<Kit> findByValidadeAfter(Date dataInicial);

    List<Kit> findByValidadeBetween(Date dataInicial, Date dataFinal);

}
