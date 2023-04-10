package com.restorant.Restorant.pyload;

import com.restorant.Restorant.Entity.Product;
import com.restorant.Restorant.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResBuy {
    private User oluvchi;
    private Product mahsulot;
    private Integer nechta;
    private double price;

    private Timestamp zakazVaqti;

}
