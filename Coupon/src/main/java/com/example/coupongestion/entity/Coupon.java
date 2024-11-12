package com.example.coupongestion.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
public class Coupon {
    @Id
    @GeneratedValue
    private Long id;
    private String code;
    private BigDecimal pourcentageReduction;
    private BigDecimal montantReduction;
    private LocalDate dateDebut;
    private LocalDate dateExpiration;
    private boolean estActif;
    private Integer utilisationsMax;
    private int utilisationsActuelles;
public Coupon(){

}
    public Coupon(String code, BigDecimal pourcentageReduction, BigDecimal montantReduction, LocalDate dateDebut, LocalDate dateExpiration, boolean estActif, Integer utilisationsMax, int utilisationsActuelles) {
        this.code = code;
        this.pourcentageReduction = pourcentageReduction;
        this.montantReduction = montantReduction;
        this.dateDebut = dateDebut;
        this.dateExpiration = dateExpiration;
        this.estActif = estActif;
        this.utilisationsMax = utilisationsMax;
        this.utilisationsActuelles = utilisationsActuelles;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public BigDecimal getPourcentageReduction() {
        return pourcentageReduction;
    }

    public BigDecimal getMontantReduction() {
        return montantReduction;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public LocalDate getDateExpiration() {
        return dateExpiration;
    }

    public boolean isEstActif() {
        return estActif;
    }

    public Integer getUtilisationsMax() {
        return utilisationsMax;
    }

    public int getUtilisationsActuelles() {
        return utilisationsActuelles;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPourcentageReduction(BigDecimal pourcentageReduction) {
        this.pourcentageReduction = pourcentageReduction;
    }

    public void setMontantReduction(BigDecimal montantReduction) {
        this.montantReduction = montantReduction;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateExpiration(LocalDate dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public void setEstActif(boolean estActif) {
        this.estActif = estActif;
    }

    public void setUtilisationsMax(Integer utilisationsMax) {
        this.utilisationsMax = utilisationsMax;
    }

    public void setUtilisationsActuelles(int utilisationsActuelles) {
        this.utilisationsActuelles = utilisationsActuelles;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
