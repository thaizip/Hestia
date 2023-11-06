package hestia.msStore.repository;

import hestia.msStore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByProductName(String productName);

}