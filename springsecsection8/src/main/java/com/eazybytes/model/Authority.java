package com.eazybytes.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="authorities")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToOne // Muitas permissões (Authorities) pertencem a um usuário (Customer).
    @JoinColumn(name = "customer_id")
    private Customer customer;


}
