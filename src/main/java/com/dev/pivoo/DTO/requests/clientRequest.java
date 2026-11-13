package com.dev.pivoo.DTO.requests;

import com.dev.pivoo.model.enums.client_type;
import java.time.LocalDateTime;

public record clientRequest(
    client_type client_type,

    String name,

    String phone1,

    String phone2,

    String address,

    String cpf_cnpj,

    String mail,

    LocalDateTime cancel_date
){}
