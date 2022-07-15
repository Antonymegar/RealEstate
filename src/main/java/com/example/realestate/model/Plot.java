package com.example.realestate.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

@Entity
@Table(name = "plots")
public class Plot {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max =55)
    private String  plotsize;


    @NotNull
    private BigDecimal price;

    @JsonProperty("Currency")
    private String currency;

    @NotBlank
    @Size(max = 60)
    private String plotNumber;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private LandStatus status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_userid" , nullable = false)
    private User user;

    public Plot(User user) {
        this.user = user;
    }


     @ManyToOne(fetch = FetchType.EAGER, optional = false)
     @JoinColumn(name = "category_id", nullable = false)
     private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="fK_chama",nullable = false)
    private Chama chama;

    public Plot(Chama chama) {
        this.chama = chama;
    }

    public Chama getChama() {
        return chama;
    }

    public void setChama(Chama chama) {
        this.chama = chama;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Plot () {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPlotNumber() {
        return plotNumber;
    }

    public void setPlotNumber(String plotNumber) {
        this.plotNumber = plotNumber;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Plot(String plotsize, BigDecimal price, String plotNumber, LandStatus status) {
        this.plotsize = plotsize;
        this.price = price;
        this.plotNumber = plotNumber;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlotsize() {
        return plotsize;
    }

    public void setPlotsize(String plotsize) {
        this.plotsize = plotsize;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LandStatus getStatus() {
        return status;
    }

    public void setStatus(LandStatus status) {
        this.status = status;
    }
}
