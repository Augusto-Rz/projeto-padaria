package org.example.resources;

import org.example.entities.Contato;
import org.example.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(value = "/contato")
public class ContatoResource {
    @Autowired
    public ContatoService service;

    @GetMapping
    public ResponseEntity<List<Contato>> getAll(){
        List<Contato> cliente = service.findALL();
        return ResponseEntity.ok(cliente);
    }
    @GetMapping("/id")
    public ResponseEntity<Contato> findById(@PathVariable Long id) {
        Optional<Contato> contato = Optional.ofNullable(service.findById(id));
        return contato.map(ResponseEntity::ok).orElseGet(()
                -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Contato> insert(@RequestBody Contato contato){
        Contato created = service.insert(contato);
        return ResponseEntity.status(HttpStatus.MULTI_STATUS.CREATED).body(created);
    }
    @DeleteMapping("/id")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/id")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody Contato contato){
        if (service.update(id, contato)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
