package tech.devinhouse.m01s09springdata.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "kit_servico")
public class KitServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    @JoinColumn(nullable = false)
    private Kit kit;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Servico servico;

}
