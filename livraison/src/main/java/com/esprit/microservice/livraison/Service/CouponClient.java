package com.esprit.microservice.livraison.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(name = "coupon-service", url = "http://coupon-service:8081")
public interface CouponClient {
    @GetMapping("/api/coupons/getCoupon/{id}")
    ResponseEntity<Coupon> lireCouponParId(@PathVariable Long id);

}