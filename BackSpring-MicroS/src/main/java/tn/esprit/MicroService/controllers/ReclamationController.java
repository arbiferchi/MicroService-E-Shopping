package tn.esprit.MicroService.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.MicroService.entities.Reclamation;
import tn.esprit.MicroService.services.IReclamationService;

import java.util.List;


@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RequestMapping("/api/reclamation")
public class ReclamationController  {

    private IReclamationService iReclamationService;



    @PostMapping("/addReclamation")
    public Reclamation addReclamation(
            @RequestBody Reclamation r){
        return iReclamationService.addReclamation(r);
    }



    @GetMapping("/getAllr")
    public List<Reclamation> getAllReclamation(){
        return iReclamationService.getAllReclamations();
    }



    @PutMapping("/modifierReclamation")
    public Reclamation updateReclamation(@RequestBody Reclamation r) {
        return iReclamationService.updateReclamation(r);
    }

    @GetMapping("/getReclamation/{idReclamation}")
    public Reclamation findById(@PathVariable long idReclamation) {
        return iReclamationService.getReclamationById(idReclamation);
    }

    @DeleteMapping("/supprimerReclamation/{idReclamation}")
    public void deleteReclamation(@PathVariable long idReclamation) {
        iReclamationService.deleteReclamation(idReclamation);
    }

}
