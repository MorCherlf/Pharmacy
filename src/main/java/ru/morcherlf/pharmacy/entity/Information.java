package ru.morcherlf.pharmacy.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Information")
public class Information {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "ImgURL", length = 200, nullable = false)
    private String imgURL;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="DescriptionID", referencedColumnName = "ID")
    private Description description;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="IntroductionID", referencedColumnName = "ID")
    private Introduction introduction;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Introduction getIntroduction() {
        return introduction;
    }

    public void setIntroduction(Introduction introduction) {
        this.introduction = introduction;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getImgURL() {
        return imgURL;
    }
}
