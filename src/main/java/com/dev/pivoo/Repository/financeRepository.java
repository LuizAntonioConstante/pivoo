package com.dev.pivoo.Repository;

import com.dev.pivoo.model.client;
import com.dev.pivoo.model.finance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface financeRepository extends JpaRepository<finance,Long> {

    @Query("SELECT f FROM finance f WHERE f.remove_date IS NULL")
    List<finance> findActiveFinances();

    @Query("SELECT f FROM finance f WHERE f.remove_date IS NOT NULL")
    List<finance> findInactiveFinances();

    @Query("SELECT f FROM finance f WHERE f.due_date < :today AND f.paidreceived_date IS NULL AND f.remove_date IS NULL")
    List<finance> findOverdueFinances(@Param("today") LocalDate today);

}
