package infrastructure;

import core.Ticket;
import core.TicketRepository;

import java.util.ArrayList;
import java.util.List;

public class TicketRepositoryImpl implements TicketRepository {
    private List<Ticket> tickets;

    public TicketRepositoryImpl() {
        this.tickets = new ArrayList<>();
    }

    @Override
    public Ticket getTicketById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    @Override
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    @Override
    public void updateTicket(Ticket ticket) {
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getId() == ticket.getId()) {
                tickets.set(i, ticket);
                break;
            }
        }
    }

    @Override
    public void deleteTicket(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                tickets.remove(ticket);
                break;
            }
        }
    }
        public Ticket getAllTickets() {
            return new ArrayList<>(tickets);
        }
    public List<Ticket> getTicketsByGenre(String genre) {
        List<Ticket> ticketsByGenre = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (ticket.getGenre().equals(genre)) {
                ticketsByGenre.add(ticket);
            }
        }
        return ticketsByGenre;
    }


}

