package com.restorant.Restorant.pyload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqCategory {
    private String name;
    private boolean isActive;

    private String photo;
}
