package com.nursery.shipping;

import java.util.List;
import java.util.Optional;

public interface ShippingSessionService {
    List<ShippingSession> getAllShippingSessions();
    Optional<ShippingSession> getShippingSessionById(Long id);
    ShippingSession createShippingSession(ShippingSession shippingSession);
    ShippingSession updateShippingSession(Long id, ShippingSession shippingSession);
    void deleteShippingSession(Long id);
}
