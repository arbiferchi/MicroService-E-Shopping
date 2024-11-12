package com.esprit.microservice.livraison.Repository;

import com.esprit.microservice.livraison.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    List<Delivery> findByStatus(String status);

    List<Delivery> findByCustomerName(String customerName);

    List<Delivery> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<Delivery> findByEstimatedDeliveryTimeBetween(LocalDateTime startTime, LocalDateTime endTime);

    List<Delivery> findByOrderNumberContaining(String orderNumber);

    List<Delivery> findByDeliveryAddressContaining(String address);

    List<Delivery> findByTotalAmountBetween(Double minAmount, Double maxAmount);

    long countByStatus(String status);
}