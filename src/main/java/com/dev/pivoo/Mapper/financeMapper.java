package com.dev.pivoo.Mapper;

import com.dev.pivoo.DTO.requests.financeRequest;
import com.dev.pivoo.DTO.requests.financeRequest;
import com.dev.pivoo.model.finance;
import com.dev.pivoo.model.finance;
import org.springframework.stereotype.Component;

@Component
public class financeMapper {
    public finance toEntity(financeRequest request){
        finance finance = new finance();

        finance.setType(request.type());
        finance.setPaidreceived_date(request.paidreceived_date());
        finance.setRemove_date(request.remove_date());
        finance.setAmount(request.amount());
        finance.setDue_date(request.due_date());


        return finance;
    }
    
    public void updateEntity(finance editFinance, financeRequest request){

        if (request.type() != null){
            editFinance.setType(request.type());
        }

        if (request.paidreceived_date() != null){
            editFinance.setPaidreceived_date(request.paidreceived_date());
        }

        if (request.amount() != null){
            editFinance.setAmount(request.amount());
        }

        if (request.due_date() != null){
            editFinance.setDue_date(request.due_date());
        }
    }
}
