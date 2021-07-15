package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.domain.TimeComparator;
import ru.netology.manager.TicketManager;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TicketTest {
    private TicketRepository ticketRepository = new TicketRepository();
    private TicketManager ticketManager = new TicketManager(ticketRepository);
    private TimeComparator timeComparator = new TimeComparator();
    private Ticket first = new Ticket(1, 2000, "LED", "KVK", 200);
    private Ticket second = new Ticket(2, 3000, "VKO", "KUF", 120);
    private Ticket third = new Ticket(3, 1500, "SVO", "KVK", 80);
    private Ticket fourth = new Ticket(4, 2500, "RVH", "FRU", 90);
    private Ticket fifth = new Ticket(5, 500, "LED", "GOJ", 95);
    private Ticket sixth = new Ticket(6, 3000, "LED", "KVK", 90);
    private Ticket seventh = new Ticket(7, 3200, "RVH", "FRU", 100);

    @BeforeEach
    public void shouldAdd() {
        ticketManager.add(first);
        ticketManager.add(second);
        ticketManager.add(third);
        ticketManager.add(fourth);
        ticketManager.add(fifth);
        ticketManager.add(sixth);
        ticketManager.add(seventh);
    }


    @Test
    void shouldSortByPrice() {
        Ticket[] actual = new Ticket[]{first, second, third, fourth, fifth};
        Ticket[] expected = new Ticket[]{fifth, third, first, fourth, second};

        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
        for (Ticket ticket : actual) {
            System.out.println(ticket);
        }
    }

    @Test
    void shouldFindLEDtoKVKAndSort() {
        Ticket[] expected = new Ticket[]{first, sixth};
        Ticket[] actual = ticketManager.searchByAirports("LED", "KVK");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindRVHtoFRUAndSort() {
        Ticket[] expected = new Ticket[]{fourth, seventh};
        Ticket[] actual = ticketManager.searchByAirports("RVH", "FRU");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFound() {
        Ticket[] expected = new Ticket[0];
        Ticket[] actual = ticketManager.searchByAirports("RGH", "FAU");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindRVHtoFRUAndSortByTime() {
        Ticket[] expected = new Ticket[]{fourth, seventh};
        Ticket[] actual = ticketManager.searchByAirportsAndSortByTime("RVH", "FRU", timeComparator);
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldFindLEDtoKVKAndSortByTime() {
        Ticket[] expected = new Ticket[]{sixth, first};
        Ticket[] actual = ticketManager.searchByAirportsAndSortByTime("LED", "KVK", timeComparator);
        assertArrayEquals(expected, actual);
    }
}



