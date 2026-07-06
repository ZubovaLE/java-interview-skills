package com.zubova.module1.multithreading.example.monitor;

import java.util.HashMap;
import java.util.Map;

class TicketBooking {
    private final Object seatLock = new Object();
    private Map<Integer, Boolean> seats = new HashMap<>();

    public TicketBooking(int totalSeats) {
        // Инициализация всех мест как свободных (true)
        for (int i = 1; i <= totalSeats; i++) {
            seats.put(i, true);
        }
    }

    public void bookSeat(int seatNumber) {
        synchronized(seatLock) {
            if (seats.get(seatNumber)) {
                System.out.println(Thread.currentThread().getName() + " бронирует место " + seatNumber);
                seats.put(seatNumber, false);
                System.out.println("Место " + seatNumber + " успешно забронировано.");
            } else {
                System.out.println("Место " + seatNumber + " уже занято.");
            }
        }
    }
}