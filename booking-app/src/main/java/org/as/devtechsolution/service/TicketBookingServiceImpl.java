package org.as.devtechsolution.service;

import java.util.Optional;

import org.as.devtechsolution.entity.Ticket;
import org.as.devtechsolution.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketBookingServiceImpl implements BookingService {
	
	@Autowired
	private TicketRepository repo;

	@Override
	public Ticket bookTicket(Ticket ticket) {
		return repo.save(ticket);
	}

	@Override
	public Ticket getTicketById(Integer ticketId) {
		Ticket ticket= null;
		Optional<Ticket> result = repo.findById(ticketId);
		if(result.isPresent()) {
			ticket=result.get();
		}
		return ticket;
	}

	@Override
	public Iterable<Ticket> getAllBookedTickets() {
		
		return repo.findAll();
	}

	@Override
	public void deleteTicket(Integer ticketId) {
		repo.deleteById(ticketId);

	}

	@Override
	public Ticket updateEmailByTicketId(Integer ticketId, String email) {
		Ticket ticket=null;
		Ticket updatedTicket=null;
		try {
			ticket = repo.getOne(ticketId);
			ticket.setEmail(email);
			updatedTicket= repo.save(ticket);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return updatedTicket;
	}

}
