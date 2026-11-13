package com.dev.pivoo.Repository;

import com.dev.pivoo.model.client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface clientRepository extends JpaRepository<client,Long> {

    @Query("SELECT c FROM client c WHERE c.cancel_date IS NULL")
    List<client> findActiveClients();

    @Query("SELECT c FROM client c WHERE c.cancel_date IS NOT NULL")
    List<client> findInactiveClients();

}
