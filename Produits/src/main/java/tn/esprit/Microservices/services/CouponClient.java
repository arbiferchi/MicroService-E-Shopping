package tn.esprit.Microservices.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "coupon-service", url = "http://coupon-service:8081")
public interface CouponClient {
    @GetMapping("/api/coupons/getCoupon/{id}")
    ResponseEntity<Coupon> lireCouponParId(@PathVariable Long id);

}