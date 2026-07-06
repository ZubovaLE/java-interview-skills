package com.zubova.module1.enumT.practice.taskPriority;

public enum TaskPriority {
    HIGH(60),
    MEDIUM(120),
    LOW(240);

    private final int timeInMinutes;

    TaskPriority(int timeInMinutes) {
        this.timeInMinutes = timeInMinutes;
    }

    public int getTimeInMinutes() {
        return timeInMinutes;
    }

    /**
     * Проверяет, имеет ли текущий приоритет более высокий ранг, чем другой.
     * @param other Приоритет для сравнения.
     * @return true, если текущий приоритет выше.
     */
    public boolean isHigherThan(TaskPriority other) {
        return this.ordinal() < other.ordinal();
    }

    /**
     * Статический метод для получения более высокого из двух приоритетов.
     * @return Более высокий приоритет.
     */
    public static TaskPriority getHigherPriority(TaskPriority p1, TaskPriority p2) {
        return p1.ordinal() < p2.ordinal() ? p1 : p2;
    }
    
}