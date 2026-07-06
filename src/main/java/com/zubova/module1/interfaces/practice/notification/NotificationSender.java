package com.zubova.module1.interfaces.practice.notification;

interface NotificationSender {

    void sendNotification(String message);

    boolean isAvailable();

    NotificationType getNotificationtype();

    enum NotificationType {

        EMAIL,
        PUSH,
        SMS
    }

}