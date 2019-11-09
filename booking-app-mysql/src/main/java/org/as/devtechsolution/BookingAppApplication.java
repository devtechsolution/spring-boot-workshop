package org.as.devtechsolution;

import java.util.Date;

import org.as.devtechsolution.entity.Ticket;
import org.as.devtechsolution.service.BookingService;
import org.as.devtechsolution.service.TicketBookingServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BookingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingAppApplication.class, args);
	}

}
