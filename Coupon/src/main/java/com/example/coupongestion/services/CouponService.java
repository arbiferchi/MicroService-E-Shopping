package com.example.coupongestion.services;

import com.example.coupongestion.entity.Coupon;
import com.example.coupongestion.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CouponService {
    @Autowired
    private CouponRepository couponRepository;


    public Coupon creerCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    public List<Coupon> lireTousLesCoupons() {
        return couponRepository.findAll();
    }

    public Optional<Coupon> lireCouponParId(Long id) {
        return couponRepository.findById(id);
    }

    public Coupon mettreAJourCoupon(Long id, Coupon coupon) {
        coupon.setId(id);
        return couponRepository.save(coupon);
    }

    public void supprimerCoupon(Long id) {
        couponRepository.deleteById(id);
    }
}
