package com.dev.soccer.Mapper;

import com.dev.soccer.DTO.requests.clientRequest;
import com.dev.soccer.model.client;
import org.springframework.stereotype.Component;

@Component
public class clientMapper {
    public client toEntity(clientRequest request){
        client client = new client();

        client.setClient_type(request.client_type());
        client.setName(request.name());
        client.setPhone1(request.phone1());
        client.setPhone2(request.phone2());
        client.setAddress(request.address());
        client.setCpf_cnpj(request.cpf_cnpj());
        client.setMail(request.mail());
        client.setCancel_date(request.cancel_date());

        return client;
    }
}
