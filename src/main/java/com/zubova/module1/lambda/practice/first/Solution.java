package com.zubova.module1.lambda.practice.first;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("DEPOSIT", 5000.00, "RUB"));
        transactions.add(new Transaction("DEPOSIT", 100, "EUR"));
        transactions.add(new Transaction("DEPOSIT", 1003, "USD"));
        transactions.add(new Transaction("DEPOSIT FROM OTHER PERSON", 2000.00, "RUB"));
        transactions.add(new Transaction("DEPOSIT FROM OTHER PERSON", 20.00, "EUR"));

        Map<String, Double> result = transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getCurrency,
                        Collectors.summingDouble(Transaction::getAmount)
                )) // Шаги 1 и 2: Группируем по валюте и сразу считаем сумму
                .entrySet().stream() // Создаем новый стрим из результатов (Map.Entry<String, Double>)
                .filter(entry -> entry.getValue() > 1000) // Шаг 3: Фильтруем по сумме
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed()) // Шаг 4: Сортируем по убыванию суммы
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, // Merge function, на случай дубликатов
                        LinkedHashMap::new // Сохраняем порядок после сортировки
                ));

        result.forEach((currency, sum) -> System.out.printf("Валюта: %s, Сумма: %.2f%n", currency, sum));


//        // 1. Сгруппировать транзакции по валюте
//        Map<String, List<Transaction>> transactionsByCurrency = transactions.stream()
//                .collect(Collectors.groupingBy(Transaction::getCurrency));
//
//        // 2. Посчитать сумму по каждой валюте
//        transactionsByCurrency.keySet().stream()
//                .map(key -> transactionsByCurrency.get(key).stream()
//                        .map(Transaction::getAmount)
//                        .reduce(Double::sum))
//                .forEach(System.out::println);
//
//        // 3. Отфильтровать валюты с общей суммой больше 1000
//        List<Transaction> collected = transactions.stream()
//                .filter(transaction -> transaction.getAmount() > 1000.00)
//                .toList();
//
//        // 4. Отсортировать результат по убыванию суммы
//        List<Transaction> list = collected.stream()
//                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())
//                .toList();
    }
}
