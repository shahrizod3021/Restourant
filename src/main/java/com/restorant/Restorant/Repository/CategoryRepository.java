package com.restorant.Restorant.Repository;

import com.restorant.Restorant.Entity.Category;
import com.restorant.Restorant.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
    boolean existsCategoryByName(String name);

}
