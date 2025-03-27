package org.example.services;

import org.example.entities.Endereco;
import org.example.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository repository;

    public List<Endereco> findAll(){
        return repository.findAll();
    }

    public Optional<Endereco> findById(Long id){
        return repository.findById(id);
    }

    public Endereco insert(Endereco endereco){
        return repository.save(endereco);
    }

    public void delete(Long id ){
        repository.deleteById(id);
    }

    public boolean update(Long id, Endereco endereco){
        Optional<Endereco>optional=repository.findById(id);
        if (optional.isPresent()){
            Endereco endereco1 = optional.get();
            endereco1.setPais(endereco.getPais());
            endereco1.setEstado(endereco.getEstado());
            endereco1.setCidade(endereco.getCidade());
            endereco1.setBairro(endereco.getBairro());
            endereco1.setRua(endereco.getRua());
            repository.save(endereco1);
            return true;
        }
        return false;
    }
}

