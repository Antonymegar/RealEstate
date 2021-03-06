package com.example.realestate.model;

import com.example.realestate.model.audit.DateAudit;
import com.example.realestate.phoneValidator.EmailOrPhone;
import com.example.realestate.phoneValidator.PhoneNumberValidationAnnotationName;
import com.example.realestate.phoneValidator.ValidPhoneNumber;
import com.example.realestate.phoneValidator.phoneNumberConstraint;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name ="users" , uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class User extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @NotBlank
    @Size(max = 40)
    private String name;

    @NotBlank
    @Size(max = 15)
    private String username;

    @NaturalId
    @NotBlank
    @Size(max =40)
    @Email
    private String email;

    @phoneNumberConstraint
    private  String phoneNumber;

    @NotBlank
    @Size(max = 100)
    private String password;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_chama")
    private Chama chama;

    public User(Chama chama) {
        this.chama = chama;
    }

    public Chama getChama() {
        return chama;
    }

    public void setChama(Chama chama) {
        this.chama = chama;
    }

    //    public User(Group group) {
//        this.group = group;
//    }
//
//    public Group getGroup() {
//        return group;
//    }
//
//    public void setGroup(Group group) {
//        this.group = group;
//    }
//    @OneToMany(
//            mappedBy = "user",
//            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY,
//            orphanRemoval = true
//    )
//    @Size(min =2 , max= 6)
//    @Fetch(FetchMode.SELECT)
//    @BatchSize(size= 20)
//    private List<Plot> plots = new ArrayList<>();

//    public User(List<Plot> plots) {
//        this.plots = plots;
//
//
//    }
//
//
//    public List<Plot> getPlots() {
//        return plots;
//    }
//
//
//
//    public void setPlots(List<Plot> plots) {
//        this.plots = plots;
//    }

    public User() {

    }

    public User(String name, String username,String email,String phoneNumber, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.phoneNumber= phoneNumber;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }



}
