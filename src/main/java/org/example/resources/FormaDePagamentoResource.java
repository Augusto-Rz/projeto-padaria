package org.example.resources;

import org.example.entities.FormaDePagamento;
import org.example.services.FormaDePagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(value = "/fpagamentos")
public class FormaDePagamentoResource {
    @Autowired
    public FormaDePagamentoService service;

    @GetMapping
    public ResponseEntity<List<FormaDePagamento>> getAll(){
        List<FormaDePagamento> formaDePagamento = service.findAll();
        return ResponseEntity.ok(formaDePagamento);
    }
    @GetMapping("/id")
    public ResponseEntity<FormaDePagamento> findById(@PathVariable Long id) {
        Optional<FormaDePagamento> formaDePagamento = service.findById(id);
        return formaDePagamento.map(ResponseEntity::ok).orElseGet(()
                -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<FormaDePagamento> insert(@RequestBody FormaDePagamento formaDePagamento){
        FormaDePagamento created = service.insert(formaDePagamento);
        return ResponseEntity.status(HttpStatus.MULTI_STATUS.CREATED).body(created);
    }
    @DeleteMapping("/id")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/id")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody FormaDePagamento formaDePagamento){
        if (service.update(id, formaDePagamento)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
