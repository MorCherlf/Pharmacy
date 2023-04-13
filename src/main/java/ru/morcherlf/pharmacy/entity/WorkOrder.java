package ru.morcherlf.pharmacy.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "WorkOrder")
public class WorkOrder {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "Statement", length = 50)
    private String statement;

    @Column(name = "CreateTime", nullable = false)
    private Timestamp createTime;

    @Column(name = "Content", columnDefinition="TEXT", nullable = false)
    private String content;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="SupporterID")
    private Supporter supporter;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="StaffID")
    private Staff staff;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="OnlineOrderID")
    private OnlineOrder onlineOrder;
}
