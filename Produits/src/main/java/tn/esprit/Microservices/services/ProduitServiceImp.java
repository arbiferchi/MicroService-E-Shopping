package tn.esprit.Microservices.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esprit.Microservices.entities.Produit;
import tn.esprit.Microservices.repositories.ProduitRepository;

import java.util.List;

@Service
public class ProduitServiceImp implements IProduitService {
    @Autowired
    private  CouponClient couponClient;

    @Autowired
    private ProduitRepository produitRepository;

    public Produit addProduit(Produit p) {
        return produitRepository.save(p);
    }

    @Override
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    @Override
    public Produit getProduitById(long idProduit) {
        return produitRepository.findById(idProduit).orElse(null);
    }

    @Override
    public void deleteProduit(long idProduit) {
        produitRepository.deleteById(idProduit);
    }

    @Override
    public Produit updateProduit(Produit p) {
        return produitRepository.save(p);
    }

    public ResponseEntity<Coupon> getcoupon(Long id) {
        return couponClient.lireCouponParId(id);
    }
}
