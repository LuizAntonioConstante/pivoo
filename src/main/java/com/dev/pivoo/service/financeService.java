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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

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

    @Transactional
    public void deleteFinance(Long id){

        boolean exists = financeRepository.existsById(id);
        if(exists){
            financeRepository.deleteById(id);
        }
        else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Finance not found"
            );
        }
    }

    @Transactional
    public finance editFinance(Long id, financeRequest request){

        finance editFinance = financeRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Finance not found")
        );

        financeMapper.updateEntity(editFinance, request);

        return financeRepository.save(editFinance);
    }

    @Transactional(readOnly = true)
    public List<finance> findAllFinances(){

        return financeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<finance> findActiveFinances(){

        return financeRepository.findActiveFinances();
    }

    @Transactional(readOnly = true)
    public List<finance> findInactiveFinances(){

        return financeRepository.findInactiveFinances();
    }

    @Transactional(readOnly = true)
    public finance getFinanceById(Long id){

        return financeRepository.findById(id).orElseThrow();
    }

    @Transactional
    public finance deactivateFinance(Long id){

        finance editFinance = financeRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Finance not found")
        );

        if (editFinance.getRemove_date() == null) {
            editFinance.setRemove_date(LocalDateTime.now());
        }

        return financeRepository.save(editFinance);

    }

    @Transactional
    public finance reactivateFinance(Long id){

        finance editFinance = financeRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Finance not found")
        );

        if (editFinance.getRemove_date() != null) {
            editFinance.setRemove_date(null);
        }

        return financeRepository.save(editFinance);

    }

}
