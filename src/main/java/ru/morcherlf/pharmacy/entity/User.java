package ru.morcherlf.pharmacy.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@Table(name = "User")
public class User {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    @Column(name = "Password", length = 100, nullable = false)
    private String password;

    @Column(name = "Email", length = 100, nullable = false)
    private String email;

    @Column(name = "Username", length = 80, nullable = false)
    private String username;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="MemberID", referencedColumnName = "ID")
    @JsonBackReference(value = "order-member")
    @ToString.Exclude
    private Member member;

    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<OnlineOrder> onlineOrderList;

    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Address> addressList;
}
