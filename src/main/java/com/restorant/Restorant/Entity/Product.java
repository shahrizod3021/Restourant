package com.restorant.Restorant.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product{

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;
 @Column(nullable = false)
 private String name;

 private String photo;
 private double price;
 private String description;

 public Product(String name, String photo, double price, String desc) {
  this.name = name;
  this.photo = photo;
  this.price = price;
  this.description = desc;
 }
}
