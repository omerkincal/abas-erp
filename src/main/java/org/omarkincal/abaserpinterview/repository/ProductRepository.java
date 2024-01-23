package org.omarkincal.abaserpinterview.repository;

import org.omarkincal.abaserpinterview.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
