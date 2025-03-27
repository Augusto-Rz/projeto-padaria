package org.example.repositories;

import org.example.entities.FormaDePagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaDePagamentoRepository extends JpaRepository<FormaDePagamento,Long> {
}
