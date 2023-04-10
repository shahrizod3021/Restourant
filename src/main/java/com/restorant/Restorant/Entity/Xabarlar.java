package com.restorant.Restorant.Entity;

import com.restorant.Restorant.Entity.AbsEntity.AbsNameEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Xabarlar extends AbsNameEntity {
    private String message;

    private String phoneNumbers;

    public Xabarlar(String name, String message, String phoneNumbers) {
        super(name);
        this.message = message;
        this.phoneNumbers = phoneNumbers;
    }
}
