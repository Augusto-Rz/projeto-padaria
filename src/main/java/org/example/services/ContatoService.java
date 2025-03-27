package org.example.services;

import org.example.entities.Contato;
import org.example.repositories.ContatoRepository;
import org.example.services.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {
    @Autowired
    private ContatoRepository repository;

    //Listar todos os contatos
    public List<Contato> findALL() {
        return repository.findAll();
    }

    //Listar um único cliente pelo id
    public Contato findById(Long id) {
        Optional<Contato> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Contato insert(Contato cliente) {
        return repository.save(cliente);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public boolean update(Long id, Contato contato) {
        Optional<Contato> optional = repository.findById(id);
        if (optional.isPresent()) {
            Contato contato1 = optional.get();
            contato1.setTelefone(contato.getTelefone());
            contato1.setCelular(contato.getCelular());
            contato1.setEmail(contato.getEmail());
            repository.save(contato1);
            return true;
        }
        return false;
    }
}
