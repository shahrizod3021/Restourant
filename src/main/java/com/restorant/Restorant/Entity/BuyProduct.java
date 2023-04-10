package com.restorant.Restorant.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BuyProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private User user;

    @OneToOne
    private Product product;

    private Integer nechta;
    private double price;

    @Column(nullable = false)
    @CreationTimestamp
    private Timestamp zakazVaqti;

    public BuyProduct(User user, Product product, Integer nechta, double price) {
        this.user = user;
        this.product = product;
        this.nechta = nechta;
        this.price = price;
    }
}
