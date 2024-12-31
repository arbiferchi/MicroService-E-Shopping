package tn.esprit.Microservices.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.Microservices.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit,Long> {


}
