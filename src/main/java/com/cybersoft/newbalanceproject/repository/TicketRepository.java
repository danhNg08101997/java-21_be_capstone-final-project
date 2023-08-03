package com.cybersoft.newbalanceproject.repository;

import com.cybersoft.newbalanceproject.entity.TicketEntitty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntitty,Integer> {

}
