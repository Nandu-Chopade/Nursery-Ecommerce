package com.nursery.Notification;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nursery.user.model.User;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByRecipientAndReadOrderByTimestampDesc(User recipient, boolean read);
    // Add other query methods as needed
}

