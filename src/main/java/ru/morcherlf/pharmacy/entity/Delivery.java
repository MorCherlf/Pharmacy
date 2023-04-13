package ru.morcherlf.pharmacy.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "Delivery")
public class Delivery {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "Statement", length = 50)
    private String  Statement;

    @Column(name = "DeliveryTime")
    private Timestamp deliveryTime;

    @Column(name = "DeliveryType", nullable = false)
    private Boolean deliveryType;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="DelivererID")
    private Deliverer deliverer;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="AddressID", referencedColumnName = "ID")
    private Address address;

    @OneToOne(mappedBy = "delivery", cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private OnlineOrder onlineOrder;

}
