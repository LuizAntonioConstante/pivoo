package com.dev.pivoo.DTO.requests;

import java.time.LocalDateTime;

public record planningfinanceRequest(

        String planning,

        LocalDateTime exclude_date
){}
