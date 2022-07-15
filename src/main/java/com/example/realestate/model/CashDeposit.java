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
    @Column(name = "id")
    private Long id;

    @NotNull
    private BigDecimal DepositAmount;

    @NotNull
    private BigDecimal PendingAmount;

    @JsonProperty("Currency")
    private String currency;

    @NotNull(message="{cashdeposits.date.notnull}")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime Date;

    @NotNull(message="{cashdeposits.date.notnull}")
    @Future(message = "{cashdeposits.date.future}")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dueDate;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name= "plot_id " , nullable =false)
    private Plot plot;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "Depo_installment1",
            joinColumns =
                    { @JoinColumn(name = "cashDeposit_id",referencedColumnName = "id" ) },
            inverseJoinColumns =
                    { @JoinColumn(name = "installment1_id", referencedColumnName = "id") })
    private FirstInstallment firstInstallment;

    public CashDeposit(FirstInstallment firstInstallment) {
        this.firstInstallment = firstInstallment;
    }

    public FirstInstallment getFirstInstallment() {
        return firstInstallment;
    }

    public void setFirstInstallment(FirstInstallment firstInstallment) {
        this.firstInstallment = firstInstallment;
    }

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
