package tn.esprit.MicroService.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.MicroService.entities.Reclamation;

public interface ReclamationRepository extends JpaRepository<Reclamation,Long> {


}
