package com.nursery.shipping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ShippingSessionServiceImpl implements ShippingSessionService {

	@Autowired
    private ShippingSessionRepository shippingSessionRepository;

    @Override
    public List<ShippingSession> getAllShippingSessions() {
        return shippingSessionRepository.findAll();
    }

    @Override
    public Optional<ShippingSession> getShippingSessionById(Long id) {
        return shippingSessionRepository.findById(id);
    }

    @Override
    public ShippingSession createShippingSession(ShippingSession shippingSession) {
        return shippingSessionRepository.save(shippingSession);
    }

    @Override
    public ShippingSession updateShippingSession(Long id, ShippingSession shippingSession) {
        shippingSession.setId(id);
        return shippingSessionRepository.save(shippingSession);
    }

    @Override
    public void deleteShippingSession(Long id) {
        shippingSessionRepository.deleteById(id);
    }
}
