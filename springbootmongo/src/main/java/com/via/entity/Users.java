package com.via.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Users {

    @MongoId
    private String id;

    private String name;

    private String gender;

    private int number;

    private String password;

    private String role;

}
