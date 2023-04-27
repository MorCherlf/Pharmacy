package ru.morcherlf.pharmacy.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "Orders")
public class Orders {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "CompletedTime", nullable = false)
    private Timestamp completedTime;

    @Column(name = "TotalPrice", nullable = false)
    private Float totalPrice;

    @Column(name = "PayPrice", nullable = false)
    private Float payPrice;

    @Column(name = "Payment", length = 50, nullable = false)
    private String payment;

    @Column(name = "SerialNumber", length = 80, nullable = false)
    private String serialNumber;

    @Column(name = "Statement", length = 50, nullable = false)
    private String statement;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "OnlineOrderID", referencedColumnName = "ID")
    private OnlineOrder onlineOrder;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name="MemberID")
    @JsonBackReference(value = "order-member")
    private Member member;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name="ShopID")
    private Shop shop;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name="StaffID")
    private Staff staff;

    @OneToMany(mappedBy = "orders",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<OrderItem> orderItemList;
}
