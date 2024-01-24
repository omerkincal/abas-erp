package org.omarkincal.abaserpinterview.repository;

import org.omarkincal.abaserpinterview.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByOrderId(Integer orderId);
}
