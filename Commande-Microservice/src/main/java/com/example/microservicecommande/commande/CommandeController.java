package com.example.microservicecommande.commande;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommandeController {
    @Autowired
    private CommandeService service ;
    @PostMapping("/addCommande ")
    public Commande addClinique (@RequestBody Commande clinique)
    {
        return service.addCommande(clinique) ;
    }

}
