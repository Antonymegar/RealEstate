package com.example.realestate.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity(name = "secondInstallment")
public class SecondInstallment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    private BigDecimal amount;

    @NotNull
    private BigDecimal pending;


    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dueDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime paidDate;

    @JsonProperty("Currency")
    private String currency;

    @OneToOne(mappedBy = "secondInstallment")
    private FirstInstallment firstInstallment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "installment_phase3",
            joinColumns =
                    { @JoinColumn(name = "secondInstallment_id",  referencedColumnName = "id") },
            inverseJoinColumns =
                    { @JoinColumn(name = "installment3_id",  referencedColumnName = "id") })
    private FinalInstallment finalInstallment;
}
