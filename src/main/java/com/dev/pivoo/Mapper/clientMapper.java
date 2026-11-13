package com.dev.pivoo.Mapper;

import com.dev.pivoo.DTO.requests.clientRequest;
import com.dev.pivoo.model.client;
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

    public void updateEntity(client editClient, clientRequest request){

        if (request.client_type() != null){
            editClient.setClient_type(request.client_type());
        }

        if (request.name() != null){
            editClient.setName(request.name());
        }

        if (request.phone1() != null){
            editClient.setPhone1(request.phone1());
        }

        if (request.phone2() != null){
            editClient.setPhone2(request.phone2());
        }

        if (request.address() != null){
            editClient.setAddress(request.address());
        }

        if (request.cpf_cnpj() != null){
            editClient.setCpf_cnpj(request.cpf_cnpj());
        }

        if (request.mail() != null){
            editClient.setMail(request.mail());
        }
    }
}
