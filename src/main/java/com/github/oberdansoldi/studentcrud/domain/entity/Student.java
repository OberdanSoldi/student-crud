package com.github.oberdansoldi.studentcrud.domain.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "rm", nullable = false)
    private Long rm;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cpf", nullable = false, length = 11)
    private String cpf;
}
