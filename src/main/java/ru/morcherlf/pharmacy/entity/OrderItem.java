package ru.morcherlf.pharmacy.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "OrderItem")
public class OrderItem {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "Count", nullable = false)
    private int count;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="OrderID")
    private Orders orders;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="MedicationID", referencedColumnName = "ID")
    private Medication medication;
}
