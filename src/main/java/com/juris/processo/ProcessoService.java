package com.juris.processo;

import com.juris.model.Processo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProcessoService {

    private final ProcessoRepository repository;

    public void save(Processo processo) {
        repository.save(processo);
    }

    public List<Processo> findAll() {
        return repository.findAll();
    }
}
