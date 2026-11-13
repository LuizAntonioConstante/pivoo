package com.dev.pivoo.service;

import com.dev.pivoo.DTO.requests.financeRequest;
import com.dev.pivoo.Mapper.financeMapper;
import com.dev.pivoo.Repository.clientRepository;
import com.dev.pivoo.Repository.financeRepository;
import com.dev.pivoo.Repository.planningfinanceRepository;
import com.dev.pivoo.Repository.timeslotRepository;
import com.dev.pivoo.model.client;
import com.dev.pivoo.model.finance;
import com.dev.pivoo.model.planningfinance;
import com.dev.pivoo.model.timeslot;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class financeService {

    private final financeRepository financeRepository;
    private final clientRepository clientRepository;
    private final timeslotRepository timeslotRepository;
    private final planningfinanceRepository planningfinanceRepository;
    private final financeMapper financeMapper;

    public financeService(financeRepository financeRepository, clientRepository clientRepository, timeslotRepository timeslotRepository, planningfinanceRepository planningfinanceRepository, financeMapper financeMapper) {
        this.financeRepository = financeRepository;
        this.clientRepository = clientRepository;
        this.timeslotRepository = timeslotRepository;
        this.planningfinanceRepository = planningfinanceRepository;
        this.financeMapper = financeMapper;
    }

    @Transactional
    public finance savefinance(financeRequest request){

        client client = clientRepository.findById(request.id_client())
                .orElseThrow(() ->
                        new IllegalArgumentException("Client not Found")
                );

        timeslot timeslot = timeslotRepository.findById(request.id_timeslot())
                .orElseThrow(() ->
                        new IllegalArgumentException("Timeslot not Found")
                );

        planningfinance planningfinance = planningfinanceRepository.findById(request.id_planning())
                .orElseThrow(() ->
                        new IllegalArgumentException("Planning not Found")
                );

        finance financefinal = financeMapper.toEntity(request);

        financefinal.setId_client(client);
        financefinal.setId_timeslot(timeslot);
        financefinal.setId_planning(planningfinance);

        return financeRepository.save(financefinal);

    }
}
