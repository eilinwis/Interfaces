package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;


public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }


    public void add(Ticket item) {
        repository.save(item);
    }

    public Ticket[] searchByAirports(String from, String to) {
        Ticket[] found = new Ticket[0];
        for (Ticket tick : repository.findAll()) {
            if (tick.matches(from, to)) {
                Ticket[] tmp = new Ticket[found.length + 1];
                System.arraycopy(found, 0, tmp, 0, found.length);
                tmp[tmp.length - 1] = tick;
                found = tmp;
            }
        }
        Arrays.sort(found);
        return found;
    }
}



