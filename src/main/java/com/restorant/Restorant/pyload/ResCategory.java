package com.restorant.Restorant.pyload;

import com.restorant.Restorant.Entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResCategory {
    private Integer id;
    private String name;
    private boolean active;

    private String photo;
    private List<Product> mahsulotlar = new ArrayList<>();

}
