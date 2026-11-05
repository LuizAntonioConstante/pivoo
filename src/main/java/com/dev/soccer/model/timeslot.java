package com.dev.soccer.model;

import com.dev.soccer.model.enums.week_days;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class timeslot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public week_days timeslot_day;

    public Time timeslot_hour;

    @ManyToOne
    @JoinColumn(name = "client_id")
    public client client;

    public BigDecimal price;

    public String status;

    public Boolean paid;

    @CreationTimestamp
    public LocalDateTime init_date;

    public LocalDateTime cancel_date;

}
