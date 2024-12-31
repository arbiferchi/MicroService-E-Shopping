package tn.esprit.Microservices.services;

import tn.esprit.Microservices.entities.Produit;

import java.util.List;

public interface IProduitService {
    Produit addProduit(Produit p);
    List<Produit> getAllProduits();

    Produit getProduitById(long idProduit);
    void deleteProduit(long idProduit);
    Produit updateProduit(Produit p);
}
