package tech.devinhouse.m01s09springdata.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.m01s09springdata.models.Servico;
import tech.devinhouse.m01s09springdata.repositories.ServicoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired private ServicoRepository servicoRepository;

    public List<Servico> get() {
        return servicoRepository.findByAtivoTrueOrderByNome();
    }

    public Servico save(Servico servico) {
        return servicoRepository.save(servico);
    }

    public boolean remove(Integer id) {
        try {
            Servico servico = servicoRepository.findByIdAndAtivoTrue(id);
            if (servico == null)
                return false;

            servico.setAtivo(false);
            save(servico);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
