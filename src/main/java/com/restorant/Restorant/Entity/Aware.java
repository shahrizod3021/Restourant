package com.restorant.Restorant.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Awares")
public class Aware{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(nullable = false, unique = true)
    private String name;

    private String link;
    private String color;


    public Aware(String name, String link, String color) {
        this.name = name;
        this.link = link;
        this.color = color;
    }
}
