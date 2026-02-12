package com.eazybytes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Set;

@Entity
@Getter @Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private long id;

    private String name;

    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;

    // WRITE_ONLY serve para não retornar a senha no app, é por segurança (add nos projeto)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String pwd;

    private String role;

    @Column(name = "create_dt")
    @JsonIgnore // Não retorna para o usuário
    private Date createDt;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER) // EAGER = carrega o pai e em seguida todos os filhos da autoridade
    @JsonIgnore
    private Set<Authority> authorities;
}

