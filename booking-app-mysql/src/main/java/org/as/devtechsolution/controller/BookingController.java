package org.as.devtechsolution.controller;

import org.as.devtechsolution.entity.Ticket;
import org.as.devtechsolution.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/booking")
public class BookingController {
	
	@Autowired 
	private BookingService bookingService;
	
	@PostMapping(value="/tickets")
	public Ticket bookTicket(@RequestBody Ticket ticket) {
		return bookingService.bookTicket(ticket);
		
	}
	
	@GetMapping(value="/tickets/{id}")
	public Ticket getTicketById(@PathVariable("id") Integer ticketId) {
		return bookingService.getTicketById(ticketId);
		
	}
	
	@GetMapping(value="/tickets")
	public Iterable<Ticket> getAllBookedTickets() {
		return bookingService.getAllBookedTickets();
		
	}
	
	@DeleteMapping(value="/tickets/{id}")
	public void canceledTicketById(@PathVariable("id") Integer ticketId) {
		 bookingService.deleteTicket(ticketId);;
		
	}
	
	@PutMapping(value="/tickets/{id}/{email:.+}")
	public Ticket updateEmailByTicketId(@PathVariable("id") Integer ticketId, @PathVariable("email") String  email) {
		 Ticket updateEmail = bookingService.updateEmailByTicketId(ticketId, email);
		 if(updateEmail!=null) {
			 return updateEmail;
		 }
		 
		 return updateEmail;
		
	}
	
	
	
	

}
