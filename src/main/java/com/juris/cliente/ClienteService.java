package com.juris.cliente;

import com.juris.exception.NotFoundException;
import com.juris.model.Cliente;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public void save(Cliente cliente) {
        repository.save(cliente);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public Cliente findById(String id){
        return repository.findById(id).orElseThrow(()-> new NotFoundException("Cliente não encontrado."));
    }
}
