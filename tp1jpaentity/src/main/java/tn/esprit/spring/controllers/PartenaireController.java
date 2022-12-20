package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.*;
import tn.esprit.spring.repositories.PartenaireRepository;
import tn.esprit.spring.services.IpartenaireService;
import tn.esprit.spring.services.PartenaireServiceImp;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/PartenaireC")
@CrossOrigin(origins = "http://localhost:4200")
public class PartenaireController {

    @Autowired
    IpartenaireService ipartenaireService;
    @Autowired
    PartenaireRepository partenaireRepository;

    @GetMapping("/")
    @CrossOrigin(origins = "http://localhost:4200")
    public Iterable<Partenaire>  GetAllPatenaire(){
        return ipartenaireService.retrieveAllPartenaire();
    }

    @GetMapping("/retrieve-partenaire/{Partenaire-id}")
    public Partenaire retrievePartenaire(@PathVariable("Partenaire-id") Long PartenaireId) {
        return ipartenaireService.retrievePartenaire(PartenaireId);
    }

    @PostMapping("/addPartenaire")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public void addPartenaire(@RequestBody Partenaire Par) {
        ipartenaireService.ajouterPartenaire(Par);
    }

    @PutMapping("/updatePartenaire/{partenaire-id}")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public void updatePartenaire(@RequestBody Partenaire Par ,@PathVariable("partenaire-id") Long PartenairetId ) {
        ipartenaireService.updatePartenaire(Par, PartenairetId);
    }
    @PostMapping (value = "/affectationPartenaireUniversite/{partenaire-id}")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public Partenaire affectationPartenaireUniversite( @RequestBody Partenaire Par ,@PathVariable("partenaire-id") Long PartenairetId   )
    {
        Partenaire etudiant1 = ipartenaireService.AddAndAssignEvent(Par,PartenairetId);
        return etudiant1;
    }

    @DeleteMapping("/deletePartenaire/{partenaire-id}")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public void deletePartenairet(@PathVariable("partenaire-id") Long PartenairetId ) {
        ipartenaireService.deletePartenaire(PartenairetId);
    }
    @PutMapping(value = "/affectationPartenaire_univer/{Par-id}/{uni-id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void affectationPartenaireUniversite(@PathVariable("Par-id") Long partId ,@PathVariable("uni-id") Long UniId )
    {
        ipartenaireService.assignPartenaireToUniversite(partId,UniId);
    }

    @GetMapping("/retrieve-all-partenaire-stats")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public Map<String, Integer> statistiqueProduit() {
        Map<String, Integer> listPatenaire = ipartenaireService.statistiquePartenaire();
        return listPatenaire;
    }

    @GetMapping("/search/{x}")
    @CrossOrigin(origins = "http://localhost:4200")
  public Iterable<Partenaire> viewHomePage( @PathVariable("x") String keyword) {
        Iterable<Partenaire> listPatenaire = ipartenaireService.search(keyword);
return listPatenaire;
    }

    @GetMapping("/findAllEPaginate")

    public Pagepa getPartenaires(
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<Integer> size)
    {
        Page<Partenaire> partenaires = null;
        partenaires=partenaireRepository.findAll(
                PageRequest.of(
                        page.orElse(0),
                        size.orElse(10)
                )
        );
        Pagepa res = new Pagepa(partenaires.getContent(), partenaires.getTotalPages(),
                partenaires.getNumber(), partenaires.getSize() ,1,2 );

        return res;
    }


}
