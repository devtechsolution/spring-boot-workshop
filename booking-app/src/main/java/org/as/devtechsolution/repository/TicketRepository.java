package org.as.devtechsolution.repository;

import org.as.devtechsolution.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository// Optional
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	
	
}
