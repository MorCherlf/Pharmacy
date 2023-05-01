package ru.morcherlf.pharmacy.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@Table(name = "Shop")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class Shop {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "Address", length = 300, nullable = false)
    private String address;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Telephone", nullable = false)
    private String telephone;

    @JsonIgnore
    @OneToMany(mappedBy = "shop",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Staff> staffList;

    @JsonIgnore
    @OneToMany(mappedBy = "shop",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Deliverer> delivererList;

    @JsonIgnore
    @OneToMany(mappedBy = "shop",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Orders> ordersList;

    @JsonIgnore
    @OneToMany(mappedBy = "shop",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JsonManagedReference(value = "medicationDetail-shop")
    @ToString.Exclude
    private List<MedicationDetail> medicationDetailList;

}
