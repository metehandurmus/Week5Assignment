package dev.patika.week5assignment.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EXPEDITIONS")
@Getter
@Setter
public class Expedition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "expeditiontype_id", referencedColumnName = "id")
    private ExpeditionType expeditionType;

    @ManyToOne
    @JoinColumn(name = "airline_id", referencedColumnName = "id")
    private AirLine airLine;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date expeditionDate;
}
