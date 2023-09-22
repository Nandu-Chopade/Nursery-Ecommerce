package com.nursery.Notification;

import java.util.List;

import com.nursery.user.model.User;

public interface NotificationService {
    List<Notification> getUnreadNotificationsForUser(User user);

    void markNotificationAsRead(Notification notification);

    void createNotification(User recipient, String type, String message);
    // Add other methods as needed
}
