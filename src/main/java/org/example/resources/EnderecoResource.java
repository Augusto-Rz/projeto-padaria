package org.example.resources;

import org.example.entities.Endereco;
import org.example.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Resource
public class EnderecoResource {
    @Autowired
    public EnderecoService service;

    @GetMapping
    public ResponseEntity<List<Endereco>> getAll(){
        List<Endereco> endereco = service.findAll();
        return ResponseEntity.ok(endereco);
    }
    @GetMapping("/id")
    public ResponseEntity<Endereco> findById(@PathVariable Long id) {
        Optional<Endereco> endereco = service.findById(id);
        return endereco.map(ResponseEntity::ok).orElseGet(()
                -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Endereco> insert(@RequestBody Endereco endereco){
        Endereco created = service.insert(endereco);
        return ResponseEntity.status(HttpStatus.MULTI_STATUS.CREATED).body(created);
    }
    @DeleteMapping("/id")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/id")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody Endereco endereco){
        if (service.update(id, endereco)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
