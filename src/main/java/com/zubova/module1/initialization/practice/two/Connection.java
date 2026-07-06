package com.zubova.module1.initialization.practice.two;

class Connection {

    private Connection() {
    }

    public static Connection getConnection() {
        return ConnectionHolder.connection;
    }

    private static class ConnectionHolder {
        private static final Connection connection = new Connection();
    }

}