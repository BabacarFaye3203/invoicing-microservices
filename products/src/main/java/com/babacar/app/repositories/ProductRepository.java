package com.babacar.app.repositories;

import com.babacar.app.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Products,Long> {

    Optional<Products> findByUuid(String uuid);
}
