package com.example.microservicecommande.commande;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandeService {
    @Autowired
    private CommandeRepository repo  ;


    public Commande addCommande (Commande c) {
        return repo.save(c);
    }

}
