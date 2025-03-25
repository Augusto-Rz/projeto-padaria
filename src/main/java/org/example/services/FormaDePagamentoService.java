package org.example.services;

import org.example.entities.FormaDePagamento;
import org.example.repositories.FormaDePagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormaDePagamentoService {
    @Autowired
    public FormaDePagamentoRepository repository;

    public List<FormaDePagamento>findAll(){
        return repository.findAll();
    }

    public Optional<FormaDePagamento>findById(Long id){
        return repository.findById(id);
    }
    public FormaDePagamento insert(FormaDePagamento formaPagamento){
        return repository.save(formaPagamento);
    }

    public void delete(Long id ){
        repository.deleteById(id);
    }

    public boolean update(Long id, FormaDePagamento formaPagamento){
        Optional<FormaDePagamento>optional=repository.findById(id);
        if (optional.isPresent()){
            FormaDePagamento formaPagamento1 = optional.get();
            formaPagamento1.setDescricao(formaPagamento.getDescricao());
            formaPagamento1.setTipo(formaPagamento.getTipo());
            repository.save(formaPagamento1);
            return true;
        }
        return false;
    }
}
