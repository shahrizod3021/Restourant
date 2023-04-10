package com.restorant.Restorant.pyload;

import com.restorant.Restorant.Entity.Product;
import com.restorant.Restorant.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqBuy {
    private String phoneNumber;
    private Integer nechta;



}
