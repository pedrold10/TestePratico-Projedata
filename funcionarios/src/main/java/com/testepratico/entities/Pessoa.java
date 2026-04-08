package com.testepratico.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;

}
