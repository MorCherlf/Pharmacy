package ru.morcherlf.pharmacy.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Introduction")
public class Introduction {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "Introduction", length = 1000, nullable = false)
    private String introduction;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
