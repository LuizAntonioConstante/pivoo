package com.dev.pivoo.model;

import com.dev.pivoo.model.enums.finance_type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class finance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public finance_type type;

    public LocalDateTime paidreceived_date;

    @CreationTimestamp
    public LocalDateTime create_date;

    public LocalDateTime remove_date;

    public BigDecimal amount;

    public LocalDate due_date;

    @ManyToOne
    public client id_client;

    @ManyToOne
    public timeslot id_timeslot;

    @ManyToOne
    public planningfinance id_planning;

}
