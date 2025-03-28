package org.example.services;

import org.example.dto.FornecedorDTO;
import org.example.entities.Fornecedor;
import org.example.entities.Contato;
import org.example.repositories.FornecedorRepository;
import org.example.services.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    public List<Fornecedor> findAll() {
        return repository.findAll();
    }

    public Fornecedor findById(Long id) {
        Optional<Fornecedor> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Fornecedor insert(Fornecedor cargaHoraria) {
        return repository.save(cargaHoraria);
    }

    public Fornecedor update(Long id, FornecedorDTO objDto) {
        try {
            Fornecedor entity = findById(id);

            //Atualiza os dados do fornecedor
            entity.setRazaoSocial(objDto.getRazaoSocial());
            entity.setNomefantasia(objDto.getNomefantasia());
            entity.setCnpj(objDto.getCnpj());

            //Atualiza o contato
            Contato contato = entity.getContatos().get(0);
            contato.setCelular(objDto.getCelular());
            contato.setTelefone(objDto.getTelefone());
            contato.setEmail(objDto.getEmail());
        } catch (Exception e) { //ta errado essas 2 linha de codigo
        }return null; //2°
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
