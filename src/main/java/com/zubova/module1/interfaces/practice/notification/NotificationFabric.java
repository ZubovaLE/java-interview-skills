package com.zubova.module1.interfaces.practice.notification;


import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Logger;

public class NotificationFabric {

    private static final Logger LOGGER = Logger.getLogger(NotificationFabric.class.getName());
    private static final ConcurrentLinkedQueue<NotificationRequest> notifications = new ConcurrentLinkedQueue<>();

    public static boolean addNotification(NotificationRequest notificationRequest) {
        return notifications.add(notificationRequest);
    }

    public static NotificationRequest extractNotification() {
        return notifications.poll();
    }

    public static void processNotification() {
        NotificationRequest notificationRequest = extractNotification();
        if (notificationRequest == null) {
            LOGGER.info("No notifications");
        }
    }

}