package com.nursery.controller;

import com.nursery.model.ShippingSession;
import com.nursery.service.ShippingSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shipping-sessions")
public class ShippingSessionController {

    private final ShippingSessionService shippingSessionService;

    @Autowired
    public ShippingSessionController(ShippingSessionService shippingSessionService) {
        this.shippingSessionService = shippingSessionService;
    }

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
