package com.example.realestate.Payload;

import com.example.realestate.model.Category;
import com.example.realestate.model.LandStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

public class PlotRequest {

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



    @NotNull
    @Valid
    private Category category;

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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPlotNumber() {
        return plotNumber;
    }

    public void setPlotNumber(String plotNumber) {
        this.plotNumber = plotNumber;
    }

    public LandStatus getStatus(LandStatus booked, LandStatus sold, LandStatus available) {
        return status;
    }

    public void setStatus(LandStatus status) {
        this.status = status;
    }

    public Category getCategory(List<Category> all) {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
