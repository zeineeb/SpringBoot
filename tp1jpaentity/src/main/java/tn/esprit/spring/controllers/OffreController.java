package tn.esprit.spring.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.entity.Offre;
import tn.esprit.spring.entity.Partenaire;
import tn.esprit.spring.entity.Universite;
import tn.esprit.spring.model.MailRequest;
import tn.esprit.spring.services.EmailService;
import tn.esprit.spring.services.IoffreService;
import tn.esprit.spring.services.IpartenaireService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/OffreC")
public class OffreController {

    @Autowired
    IoffreService ioffreService;

    @Autowired
    EmailService emailService;
    @GetMapping("/")
    public Iterable<Offre>  GetAllOffre(){
        return ioffreService.retrieveAllOffre();
    }

    @GetMapping("/retrieve-Offre/{Offre-id}")
    public Offre retrieveOffre(@PathVariable("Offre-id") Long OffreId) {
        return ioffreService.retrieveOffre(OffreId);
    }

    @PostMapping("/addOffre")
    @ResponseBody
    public void addOffre(@RequestBody Offre o ) {
        ioffreService.ajouterOffre(o);
    }

    @PutMapping("/updateOffre")
    @ResponseBody
    public void updatePOffre(@RequestBody Offre offre) {
        ioffreService.updateOffre(offre);
    }

    @DeleteMapping("/deleteOffre/{Offre-id}")
    @ResponseBody
    public void deleteEtudiant(@PathVariable("Offre-id") Long OffreId ) {
        ioffreService.deleteOffre(OffreId);
    }
    @PutMapping(value = "/affectationOffre_Partenaire/{offre-id}/{par-id}")
    public void affectationOffrePartenaire(@PathVariable("offre-id") Long offretId ,@PathVariable("par-id") Long parId )
    {
        ioffreService.assignOffreToPartenaire(offretId,parId);
    }

  /**  @GetMapping("/emailt/")
    public List<Offre> email(){
        return ioffreService.retrieveoffreParPartenaaire() ;
    }*/

   /**@RequestMapping(method = RequestMethod.POST,path = "/register")
    @ResponseBody
    public String register(@RequestBody Universite userInfo) throws Exception {
        emailService.sendEmail(userInfo);
        return "Email Sent..!";}*/



    }
