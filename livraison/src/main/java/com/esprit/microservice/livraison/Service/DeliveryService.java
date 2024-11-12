package com.esprit.microservice.livraison.Service;

import com.esprit.microservice.livraison.Repository.DeliveryRepository;
import com.esprit.microservice.livraison.entity.Delivery;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;

    public Delivery createDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }

    public Delivery getDeliveryById(Long id) {
        return deliveryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Delivery not found with id: " + id));
    }

    public List<Delivery> getDeliveriesByStatus(String status) {
        return deliveryRepository.findByStatus(status);
    }

    public List<Delivery> getDeliveriesByCustomer(String customerName) {
        return deliveryRepository.findByCustomerName(customerName);
    }

    public Delivery updateDeliveryStatus(Long id, String status) {
        Delivery delivery = getDeliveryById(id);
        delivery.setStatus(status);
        delivery.setUpdatedAt(LocalDateTime.now());
        return deliveryRepository.save(delivery);
    }

    public Delivery updateEstimatedDeliveryTime(Long id, LocalDateTime estimatedTime) {
        Delivery delivery = getDeliveryById(id);
        delivery.setEstimatedDeliveryTime(estimatedTime);
        return deliveryRepository.save(delivery);
    }

    public void deleteDelivery(Long id) {
        deliveryRepository.deleteById(id);
    }

    public List<Delivery> getDeliveriesByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return deliveryRepository.findByCreatedAtBetween(startDate, endDate);
    }
}