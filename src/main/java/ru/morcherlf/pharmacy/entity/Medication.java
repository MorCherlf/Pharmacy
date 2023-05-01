package ru.morcherlf.pharmacy.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Optional;

@Data
@Entity
@Table(name = "Medication")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class Medication {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name", length = 100, nullable = false)
    private String name;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="InformationID", referencedColumnName = "ID")
    private Information information;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "MedicationTOSupplier",joinColumns = @JoinColumn(name = "MedicationID"), inverseJoinColumns = @JoinColumn(name = "SupplierID"))
    private List<Supplier> supplierList;

    @OneToMany(mappedBy = "medication",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JsonBackReference(value = "medication-medicationDetail")
    private List<MedicationDetail> medicationDetailList;

    @ManyToOne(cascade={CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="CategoryID")
    @JsonBackReference(value = "medication-category")
    @ToString.Exclude
    private Category category;



}
