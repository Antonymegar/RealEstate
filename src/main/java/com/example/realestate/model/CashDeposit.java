package com.example.realestate.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name= "cashdeposits")
public class CashDeposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private BigDecimal DepositAmount;

    @NotNull
    private BigDecimal PendingAmount;

    @JsonProperty("Currency")
    private String currency;

    @NotNull(message="{cashdeposits.date.notnull}")
    @Future(message = "{cashdeposits.date.future}")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime Date;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name= "plot_id " , nullable =false)
    private Plot plot;


    public CashDeposit (){

    }

    public CashDeposit(Plot plot) {
        this.plot= plot;
    }


    public Plot getPlot() {
        return plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    public CashDeposit(BigDecimal depositAmount, BigDecimal pendingAmount, LocalDateTime date) {
        DepositAmount = depositAmount;
        PendingAmount = pendingAmount;
        Date = date;
    }

    public BigDecimal getDepositAmount() {
        return DepositAmount;
    }

    public void setDepositAmount(BigDecimal depositAmount) {
        DepositAmount = depositAmount;
    }

    public BigDecimal getPendingAmount() {
        return PendingAmount;
    }

    public void setPendingAmount(BigDecimal pendingAmount) {
        PendingAmount = pendingAmount;
    }

    public LocalDateTime getDate() {
        return Date;
    }

    public void setDate(LocalDateTime date) {
        Date = date;
    }
}
