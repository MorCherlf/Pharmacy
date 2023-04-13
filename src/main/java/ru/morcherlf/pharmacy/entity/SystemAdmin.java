package ru.morcherlf.pharmacy.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "SystermAdmin")
public class SystemAdmin {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "Username", length = 100, nullable = false)
    private String username;

    @Column(name = "Password", length = 80, nullable = false)
    private String password;
}
