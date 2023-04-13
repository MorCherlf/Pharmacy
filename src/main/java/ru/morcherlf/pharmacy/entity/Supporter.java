package ru.morcherlf.pharmacy.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Supporter")
public class Supporter {
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

    @OneToMany(mappedBy = "supporter",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<WorkOrder> workOrderList;
}
