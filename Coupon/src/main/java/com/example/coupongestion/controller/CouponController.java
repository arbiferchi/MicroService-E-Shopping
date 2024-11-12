package com.example.coupongestion.controller;

import com.example.coupongestion.entity.Coupon;
import com.example.coupongestion.services.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coupons")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @PostMapping
    public ResponseEntity<Coupon> creerCoupon(@RequestBody Coupon coupon) {
        return new ResponseEntity<>(couponService.creerCoupon(coupon), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Coupon>> lireTousLesCoupons() {
        return ResponseEntity.ok(couponService.lireTousLesCoupons());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coupon> lireCouponParId(@PathVariable Long id) {
        return couponService.lireCouponParId(id)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coupon> mettreAJourCoupon(@PathVariable Long id, @RequestBody Coupon coupon) {
        return ResponseEntity.ok(couponService.mettreAJourCoupon(id, coupon));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerCoupon(@PathVariable Long id) {
        couponService.supprimerCoupon(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
