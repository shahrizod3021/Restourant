package com.restorant.Restorant.pyload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ResUser {
    private UUID id;

    private String phoneNumber;

    private Timestamp createAt;

    private Timestamp updateAt;

}

