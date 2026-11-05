package com.dev.soccer.DTO.requests;

import com.dev.soccer.model.client;
import com.dev.soccer.model.enums.week_days;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDateTime;

public record timeslotRequest (
    week_days timeslot_day,

    Time timeslot_hour,

    Long client_id,

    BigDecimal price,

    String status,

    Boolean paid,

    LocalDateTime cancel_date
){}
