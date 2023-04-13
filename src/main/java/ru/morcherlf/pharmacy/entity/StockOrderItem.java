package ru.morcherlf.pharmacy.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "StockOrderItem")
public class StockOrderItem {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "Count", nullable = false)
    private int count;

    @Column(name = "Price", nullable = false)
    private Float price;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="StockOrderID")
    private StockOrder stockOrder;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="MedicationID", referencedColumnName = "ID")
    private Medication medication;
}
