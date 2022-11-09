package tech.devinhouse.m01s09springdata.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tutor")
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

}
