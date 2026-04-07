package com.servicore.backend.repository;

import com.servicore.backend.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    Optional<Supplier> findByIdAndActiveTrue(Long id);

    boolean existsByNameAndActiveTrue(String name);

    List<Supplier> findByActiveTrue();
}
