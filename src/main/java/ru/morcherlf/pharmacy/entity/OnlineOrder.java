package ru.morcherlf.pharmacy.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "OnlineOrder")
public class OnlineOrder {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "Telephone", nullable = false)
    private int telephone;

    @Column(name = "CreateTime", nullable = false)
    private Timestamp createTime;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "DeliveryID", referencedColumnName = "ID")
    private Delivery delivery;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="UserID", nullable = false)
    private User user;

    @OneToMany(mappedBy = "onlineOrder",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<WorkOrder> workOrderList;

    @OneToOne(mappedBy = "onlineOrder", cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private Orders orders;
}
