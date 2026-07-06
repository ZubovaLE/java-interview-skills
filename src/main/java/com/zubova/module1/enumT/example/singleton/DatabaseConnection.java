
package com.zubova.module1.enumT.example.singleton;

import java.sql.Connection;

public enum DatabaseConnection {
    INSTANCE;

    private Connection connection;

    DatabaseConnection() {
        // инициализация соединения
    }

    public Connection getConnection() {
        return connection;
    }
}