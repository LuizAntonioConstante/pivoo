package com.dev.soccer.service;

import com.dev.soccer.DTO.requests.financeRequest;
import com.dev.soccer.Mapper.financeMapper;
import com.dev.soccer.Repository.clientRepository;
import com.dev.soccer.Repository.financeRepository;
import com.dev.soccer.Repository.planningfinanceRepository;
import com.dev.soccer.Repository.timeslotRepository;
import com.dev.soccer.model.client;
import com.dev.soccer.model.finance;
import com.dev.soccer.model.planningfinance;
import com.dev.soccer.model.timeslot;
import jakarta.transaction.Transactional;

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
