package com.dev.soccer.DTO.requests;

import com.dev.soccer.model.client;
import com.dev.soccer.model.enums.week_days;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDateTime;

@Getter
@Setter
public class timeslotRequest {
    private week_days timeslot_day;

    private Time timeslot_hour;

    private Long client_id;

    private BigDecimal price;

    private String status;

    private Boolean paid;

    private LocalDateTime cancel_date;
}
