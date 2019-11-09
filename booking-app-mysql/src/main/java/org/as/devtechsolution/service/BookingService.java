package org.as.devtechsolution.service;

import org.as.devtechsolution.entity.Ticket;

public interface BookingService {
	
	public Ticket bookTicket(Ticket ticket);
	public Ticket getTicketById(Integer ticketId) ;
	public Iterable<Ticket> getAllBookedTickets() ;
	public void deleteTicket(Integer ticketId) ;
	public Ticket updateEmailByTicketId(Integer ticketId, String newEmail) ;

}
