package tn.esprit.MicroService.services;


import tn.esprit.MicroService.entities.Reclamation;

import java.util.List;

public interface IReclamationService {
    Reclamation addReclamation(Reclamation r) ;
    public List<Reclamation> getAllReclamations();


    public Reclamation getReclamationById(long idReclamation);
    public void deleteReclamation(long idReclamation);
    public Reclamation updateReclamation(Reclamation r);

}
