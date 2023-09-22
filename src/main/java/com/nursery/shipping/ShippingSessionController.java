package com.nursery.shipping;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shipping-sessions")
public class ShippingSessionController {

    private ShippingSessionService shippingSessionService;

    @GetMapping
    public ResponseEntity<List<ShippingSession>> getAllShippingSessions() {
        List<ShippingSession> shippingSessions = shippingSessionService.getAllShippingSessions();
        return new ResponseEntity<>(shippingSessions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShippingSession> getShippingSessionById(@PathVariable Long id) {
        Optional<ShippingSession> shippingSession = shippingSessionService.getShippingSessionById(id);
        return shippingSession.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ShippingSession> createShippingSession(@RequestBody ShippingSession shippingSession) {
        ShippingSession createdShippingSession = shippingSessionService.createShippingSession(shippingSession);
        return new ResponseEntity<>(createdShippingSession, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShippingSession> updateShippingSession(@PathVariable Long id,
                                                                @RequestBody ShippingSession shippingSession) {
        if (!shippingSessionService.getShippingSessionById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ShippingSession updatedShippingSession = shippingSessionService.updateShippingSession(id, shippingSession);
        return new ResponseEntity<>(updatedShippingSession, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShippingSession(@PathVariable Long id) {
        if (!shippingSessionService.getShippingSessionById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        shippingSessionService.deleteShippingSession(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
