package ru.morcherlf.pharmacy.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@Table(name = "Shop")
public class Shop {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "Address", length = 300, nullable = false)
    private String address;

    @Column(name = "Telephone", nullable = false)
    private String telephone;

    @OneToMany(mappedBy = "shop",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Staff> staffList;

    @OneToMany(mappedBy = "shop",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Deliverer> delivererList;

    @OneToMany(mappedBy = "shop",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Orders> ordersList;

    @OneToMany(mappedBy = "shop",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JsonManagedReference(value = "medicationDetail-shop")
    @ToString.Exclude
    private List<MedicationDetail> medicationDetailList;

}
