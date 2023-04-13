package ru.morcherlf.pharmacy.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Deliverer")
public class Deliverer {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "Password", length = 100, nullable = false)
    private String password;

    @Column(name = "Username", length = 80, nullable = false)
    private String username;

    @Column(name = "Telephone", nullable = false)
    private int telephone;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="ShopID", nullable = false)
    private Shop shop;

    @OneToMany(mappedBy = "deliverer",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Delivery> deliveryList;
}
