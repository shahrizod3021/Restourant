package com.restorant.Restorant.Repository;

import com.restorant.Restorant.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
