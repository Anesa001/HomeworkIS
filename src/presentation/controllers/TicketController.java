package presentation.controllers;


import core.Ticket;
import core.TicketRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class TicketController {
    private TicketRepository ticketRepository;

    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void addTicket(String movieTitle, LocalDate validityDate, BigDecimal price) {
        Ticket ticket = new Ticket(movieTitle, validityDate, price);
        ticketRepository.addTicket(ticket);
    }

    public void updateTicket(int id, String movieTitle, LocalDate validityDate, BigDecimal price) {
        Ticket ticket = ticketRepository.getTicketById(id);
        if (ticket != null) {
            ticket.setMovieTitle(movieTitle);
            ticket.setValidityDate(validityDate);
            ticket.setPrice(price);
            ticketRepository.updateTicket(ticket);
        }
    }

    public void deleteTicket(int id) {
        ticketRepository.deleteTicket(id);
    }

    public List<Ticket> getAllTickets() {
        return List.of(ticketRepository.getAllTickets());
    }

    public List<Ticket> getTicketsByValidityDate(LocalDate date) {
        // Filter tickets by validity date
        List<Ticket> tickets = List.of(ticketRepository.getAllTickets());
        return tickets.stream()
                .filter(ticket -> ticket.getValidityDate().equals(date))
                .collect(Collectors.toList());
    }
}

