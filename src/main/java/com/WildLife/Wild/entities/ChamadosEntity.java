package com.WildLife.Wild.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "chamados")
@Getter
@Setter
public class ChamadosEntity {
    @Column(name = "id_chamado")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_chamado;
    @Column(name = "nome")
    private String nome;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "nome_animal")
    private String nome_animal;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "UF")
    private String UF;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "local_encontrado")
    private String local_encontrado;
    @Column(name = "data")
    private Date data;
    @Column(name = "observaçao")
    private String observaçao;
}
