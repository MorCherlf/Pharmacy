package ru.morcherlf.pharmacy.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Category")
public class Category {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JsonManagedReference(value = "medication-category")
    private List<Medication> medicationList;

}
