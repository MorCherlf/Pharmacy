package ru.morcherlf.pharmacy.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Staff")
public class Staff {
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

    @Column(name = "StaffType", nullable = false)
    private int staffType;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="ShopID")
    private Shop shop;

    @OneToMany(mappedBy = "staff",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Orders> ordersList;

    @OneToMany(mappedBy = "staff",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<WorkOrder> workOrderList;

    @OneToMany(mappedBy = "staff",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<StockOrder> stockOrderList;
}
