package com.restorant.Restorant.pyload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResProduct {
    private Integer id;
    private String name;
    private String photo;
    private double price;
    private String description;

}
