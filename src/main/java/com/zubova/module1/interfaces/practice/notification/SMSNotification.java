package com.zubova.module1.interfaces.practice.notification;

public class SMSNotification implements NotificationSender {
    @Override
    public void sendNotification(String message) {

    }

    @Override
    public boolean isAvailable() {
        return false;
    }


    @Override
    public NotificationType getNotificationtype() {
        return NotificationType.SMS;
    }
}
