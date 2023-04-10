package com.restorant.Restorant.Repository;

import com.restorant.Restorant.Entity.Aware;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AwaresRepository extends JpaRepository<Aware, Integer> {
  boolean existsAwareByName(String name);
}
