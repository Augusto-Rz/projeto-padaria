package org.example.services;

import org.example.entities.Cliente;
import org.example.repositories.ClienteRepository;
import org.example.services.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    //Listar todos os clientes
    public List<Cliente> findALL() {
        return repository.findAll();
    }

    //Listar um único cliente pelo id
    public Cliente findById(Long id) {
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Cliente insert(Cliente cliente) {
        return repository.save(cliente);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public boolean update(Long id, Cliente cliente) {
        Optional<Cliente> optional = repository.findById(id);
        if (optional.isPresent()) {
            Cliente cliente1 = optional.get();
            cliente1.setNome(cliente.getNome());
            cliente1.setCpf(cliente.getCpf());
            cliente1.setDataNacimento(cliente.getDataNacimento());
            cliente1.setStatus(cliente.getStatus());
            repository.save(cliente1);
            return true;
        }
        return false;
    }
}
