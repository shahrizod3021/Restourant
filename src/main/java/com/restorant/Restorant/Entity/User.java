package com.restorant.Restorant.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String phoneNumber;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createAt;

    @Column(nullable = false)
    @UpdateTimestamp
    private Timestamp updateAt;

    public User(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
