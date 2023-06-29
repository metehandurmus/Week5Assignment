package dev.patika.week5assignment.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CHAIRS")
@Getter
@Setter
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Chair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "chairtype_id", referencedColumnName = "id")
    private ChairType chairType;

    @ManyToOne
    @JoinColumn(name = "expedition_id", referencedColumnName = "id")
    private Expedition expedition;

    @Column
    private double price;
}
