package com.restorant.Restorant.Repository;

import com.restorant.Restorant.Entity.Xabarlar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface XabarlarRepo extends JpaRepository<Xabarlar, Integer> {
    boolean existsXabarlarByNameIgnoreCase(String name);
}
