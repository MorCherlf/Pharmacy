package ru.morcherlf.pharmacy.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "Member")
public class Member {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name", length = 50, nullable = false)
    private String name;

    @Column(name = "FullName", length = 80, nullable = false)
    private String fullName;

    @Column(name = "Age", nullable = false)
    private int age;

    @Column(name = "Telephone", nullable = false)
    private int telephone;

    @Column(name = "RegisterTime", nullable = false)
    private Timestamp registerTime;

    @OneToOne(mappedBy = "member", cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private User user;

    @OneToMany(mappedBy = "member",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JsonManagedReference(value = "order-member")
    private List<Orders> ordersList;

}
