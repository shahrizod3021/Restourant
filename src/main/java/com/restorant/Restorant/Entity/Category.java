package com.restorant.Restorant.Entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;
    private boolean isActive;

    private String photo;

    @OneToMany
    private List<Product> product;


    public Category(String name, boolean isActive, String photo) {
        this.name = name;
        this.isActive = isActive;
        this.photo = photo;
    }
}
