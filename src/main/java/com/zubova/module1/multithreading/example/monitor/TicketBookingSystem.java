package com.zubova.module1.multithreading.example.monitor;

public class TicketBookingSystem {
    private int availableSeats;

    public TicketBookingSystem(int totalSeats) {
        this.availableSeats = totalSeats;
    }

    public void bookSeat(int numberOfSeats) {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " attempting to book " + numberOfSeats + " seats");
            if (numberOfSeats <= availableSeats) {
                System.out.println(Thread.currentThread().getName() + " successfully booked " + numberOfSeats + " seats");
                availableSeats -= numberOfSeats;
            } else {
                System.out.println(Thread.currentThread().getName() + " failed to book seats. Not enough seats available.");
            }
        }
    }

    public static void main(String[] args) {
        TicketBookingSystem bookingSystem = new TicketBookingSystem(10);

        Thread user1 = new Thread(() -> bookingSystem.bookSeat(4), "User1");
        Thread user2 = new Thread(() -> bookingSystem.bookSeat(7), "User2");

        user1.start();
        user2.start();
    }
}