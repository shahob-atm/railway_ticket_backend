package com.example.railway_ticket_backend.service.ticket;

import java.security.SecureRandom;

public class TicketGenerator {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public String handleGenerateTicket () {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder ticket = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            int index = secureRandom.nextInt(CHARACTERS.length());
            ticket.append(CHARACTERS.charAt(index));
        }

        return ticket.toString();
    }
}
