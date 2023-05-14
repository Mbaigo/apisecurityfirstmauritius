package com.mbaigo.dockers.api.model;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Employee {
    private long id;
    private String firsName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String matricule;
}
