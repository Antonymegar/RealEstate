package com.example.realestate.model;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "chamas")
public class Chama {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min =6 , max = 60)
    private String name;

    public Chama() {

    }


    @OneToMany(mappedBy = "chama",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    @Fetch(FetchMode.SELECT)
    @BatchSize(size= 20)
    private List<Plot> plots = new ArrayList<>();

    public List<Plot> getPlots() {
        return plots;
    }

    public void setPlots(List<Plot> plots) {
        this.plots = plots;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    //
//
//    public List<Plot> getUsers() {
//        return users;
//    }
   @OneToMany(mappedBy = "chama",
   cascade = CascadeType.ALL,
   fetch = FetchType.LAZY,
   orphanRemoval =true)
   @Size(min =2 , max = 6)
   @Fetch(FetchMode.SELECT)
   @BatchSize(size =20)
   private List<User>users = new ArrayList<>();

    public Chama(List<Plot> plots, List<User> users) {
        this.plots = plots;
        this.users = users;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Chama(String name) {
        this.name = name;
    }
}
