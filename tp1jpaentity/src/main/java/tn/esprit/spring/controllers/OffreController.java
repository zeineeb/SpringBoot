package tn.esprit.spring.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.*;
import tn.esprit.spring.repositories.OffreRepository;
import tn.esprit.spring.services.EmailService;
import tn.esprit.spring.services.IoffreService;

import java.util.Optional;

@RestController
@RequestMapping("/OffreC")
@CrossOrigin(origins = "http://localhost:4200")
public class OffreController {

    @Autowired
    IoffreService ioffreService;
    @Autowired
    OffreRepository offreRepository;
    @Autowired
    EmailService emailService;
    @GetMapping("/")
    @CrossOrigin(origins = "http://localhost:4200")
    public Iterable<Offre>  GetAllOffre(){
        return ioffreService.retrieveAllOffre();
    }

    @GetMapping("/retrieve-Offre/{Offre-id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Offre retrieveOffre(@PathVariable("Offre-id") Long OffreId) {
        return ioffreService.retrieveOffre(OffreId);
    }

    @PostMapping("/addOffre")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public void addOffre(@RequestBody Offre o ) {
        ioffreService.ajouterOffre(o);
    }

    @PutMapping("/updateOffre")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public void updatePOffre(@RequestBody Offre offre) {
        ioffreService.updateOffre(offre);
    }

    @DeleteMapping("/deleteOffre/{Offre-id}")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
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


   @GetMapping("/search/{x}")
   @CrossOrigin(origins = "http://localhost:4200")
   public Iterable<Offre> viewHomePage(@PathVariable("x") String keyword) {
       Iterable<Offre> listoffre = ioffreService.search(keyword);
       return listoffre;
   }

    @GetMapping("/findAllEPaginate")
    @CrossOrigin(origins = "http://localhost:4200")

    public Pagepa getOffres(
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<Integer> size)
    {
        Page<Offre> offres = null;
        offres=offreRepository.findAll(
                PageRequest.of(
                        page.orElse(0),
                        size.orElse(10)
                )
        );
        Pagepa res = new Pagepa(offres.getContent(), offres.getTotalPages(),
                offres.getNumber(), offres.getSize() ,1 );

        return res;
    }





}
