package com.juris.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@Builder
@Document("user")
public class User {
    @Id
    private String id;
    @NotNull
    private String name;
    private String email;
    private String password;
    private String phone;
}
