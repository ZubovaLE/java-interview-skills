package com.zubova.module1.lambda.practice.zero;

import java.util.Comparator;
import java.util.List;

class PersonsInRoomsProblem {

    public static void main(String[] args) {
        List<Room> rooms = List.of();
        solution(rooms);
    }

    private static void solution(List<Room> rooms) {
        rooms.stream()
                .max(Comparator.comparingInt(r -> r.getUsers().size()))
                .ifPresent(room -> room.getUsers().stream()
                        .min(Comparator.comparingInt(User::getAge))
                        .ifPresent(user -> writeSolution(user, room)));
    }

    private static void writeSolution(User user, Room room) {
        System.out.printf("Комната номер %s. Пользователь %s %s возраста %s%n",
                room.getNumber(), user.getFirstName(), user.getLastName(), user.getAge());
    }
}