package tech.devinhouse.m01s09springdata.models;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "servico")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Boolean ativo = Boolean.TRUE;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private BigDecimal valor = BigDecimal.ZERO;

}
