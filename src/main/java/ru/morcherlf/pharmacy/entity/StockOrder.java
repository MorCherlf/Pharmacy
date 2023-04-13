package ru.morcherlf.pharmacy.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "StockOrder")
public class StockOrder {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "CreateTime", nullable = false)
    private Timestamp createTime;

    @Column(name = "CompletedTime", nullable = false)
    private Timestamp completedTime;

    @Column(name = "TotalPrice", nullable = false)
    private Float totalPrice;

    @Column(name = "Payment", length = 50, nullable = false)
    private String payment;

    @Column(name = "SerialNumber", length = 80, nullable = false)
    private String serialNumber;

    @Column(name = "Statement", length = 50, nullable = false)
    private String statement;

    @OneToMany(mappedBy = "stockOrder",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<StockOrderItem> stockOrderItemList;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name="StaffID")
    private Staff staff;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name="SupplierID")
    private Supplier supplier;
}
