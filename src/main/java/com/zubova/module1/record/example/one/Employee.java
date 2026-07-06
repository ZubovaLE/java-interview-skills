package com.zubova.module1.record.example.one;

record Employee(
        String name,     // Имя сотрудника
        int age,         // Возраст
        double salary,   // Зарплата
        Department dept  // Отдел (может быть null)
) {
    // Компактный конструктор с расширенной валидацией
    public Employee {
        // Проверка возраста
        if (age < 18 || age > 70) {
            throw new IllegalArgumentException("Некорректный возраст для работника");
        }

        // Проверка зарплаты
        if (salary < 0) {
            throw new IllegalArgumentException("Зарплата не может быть отрицательной");
        }

        // Безопасная обработка nullable поля
        if (dept == null) {
            dept = Department.UNKNOWN;
        }
    }


    // Дополнительные конструкторы
    public Employee(String name, int age) {
        // Вызов канонического с значениями по умолчанию
        this(name, age, 0.0, null);
    }

    // Внутренний enum для department
    enum Department {
        IT, SALES, HR, UNKNOWN
    }
}
