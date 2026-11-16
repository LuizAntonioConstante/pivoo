package com.dev.pivoo.Repository;

import com.dev.pivoo.model.client;
import com.dev.pivoo.model.finance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface financeRepository extends JpaRepository<finance,Long> {

    @Query("SELECT c FROM finance c WHERE c.remove_date IS NULL")
    List<finance> findActiveFinances();

    @Query("SELECT c FROM finance c WHERE c.remove_date IS NOT NULL")
    List<finance> findInactiveFinances();

}
