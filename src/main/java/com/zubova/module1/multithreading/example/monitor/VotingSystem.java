package com.zubova.module1.multithreading.example.monitor;

class VotingSystem {
    private int totalVotes = 0;

    public synchronized void addVotes(int votes) {
        totalVotes += votes;
        System.out.println("Общее число голосов обновлено: " + totalVotes);
    }

    public synchronized int getTotalVotes() {
        return totalVotes;
    }
}