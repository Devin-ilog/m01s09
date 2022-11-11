package tech.devinhouse.m01s09springdata.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.m01s09springdata.models.Kit;
import tech.devinhouse.m01s09springdata.models.KitServico;
import tech.devinhouse.m01s09springdata.repositories.KitRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class KitService {

    @Autowired private KitRepository kitRepository;

    public List<Kit> get() {
        return kitRepository.findByAtivoTrueOrderByNome();
    }

    public Kit save(Kit kit) {
        for (KitServico kitServico : kit.getItens()) {
            kitServico.setKit(kit);
        }
        return kitRepository.save(kit);
    }

    public boolean remove(Integer id) {
        try {
            Kit kit = kitRepository.findByIdAndAtivoTrue(id);
            if (kit == null)
                return false;

//            kit.setAtivo(false);
//            save(kit);
            kitRepository.delete(kit);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Kit> findByValidade(Date dataInicial, Date dataFinal) {
        if (dataInicial == null) {
            return new ArrayList<>();
        }
        if (dataFinal == null) {
            return kitRepository.findByValidadeAfter(dataInicial);
        }
        return kitRepository.findByValidadeBetween(dataInicial, dataFinal);
    }
}
