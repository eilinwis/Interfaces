package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket implements Comparable<Ticket> {

    private int id;
    private int amount;
    private String from;
    private String to;
    private int flightTime;

    @Override
    public int compareTo(Ticket o) {
        return this.amount - o.amount;
    }

    public boolean matches(String departure, String arrival) {
        return (departure.equalsIgnoreCase(from)) && (arrival.equalsIgnoreCase(to));
    }
}
