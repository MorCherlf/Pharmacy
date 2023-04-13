package ru.morcherlf.pharmacy.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Supplier")
public class Supplier {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name", length = 50, nullable = false)
    private String name;

    @Column(name = "Contact", length = 80, nullable = false)
    private String contact;

    @ManyToMany(mappedBy = "supplierList")
    private List<Medication> medicationList;

    @OneToMany(mappedBy = "supplier",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<StockOrder> stockOrderList;
}
