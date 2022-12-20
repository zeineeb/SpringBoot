package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Equipe;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.entity.Niveau;
import tn.esprit.spring.repositories.ContratRepository;
import tn.esprit.spring.repositories.EquipeRepository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EquipeServiceImp implements IEquipeService{

    @Autowired
    EquipeRepository equipeRepository;
    @Autowired
    ContratRepository contratRepository;

    public Long ajouterEquipe(Equipe e) {
        equipeRepository.save(e);
        log.info("Ajouter Equipe");
        return e.getIdEquipe();
    }

    @Override
    public Iterable<Equipe> retrieveAllEquipe() {return equipeRepository.findAll();}

    @Override
    public void deleteEquipe(Long id) {
        equipeRepository.deleteById(id);}

    @Override
    public Equipe updateEquipe(Equipe e) {return equipeRepository.save(e);}

    @Override
    public Equipe retrieveEquipe(Long idEquipe) {
        return equipeRepository.findById(idEquipe).get();
    }

    @Override
    // @Scheduled(cron = "0/5 * * * * *")
    public void faireEvoluerEquipes() {
        List<Equipe> equipeList=equipeRepository.findAll();
        for (Equipe equipe:equipeList){
            int nbr=0;
            for(Etudiant etudiant:equipe.getEtudiants()){
                if(membreDepasseUnAns(etudiant))
                    nbr++;
            }
            if(nbr>=3){
                switch (equipe.getNiveau()){
                    case SENIOR:
                        equipe.setNiveau(Niveau.EXPERT);
                        break;
                    case JUNIOR:
                        equipe.setNiveau(Niveau.SENIOR);
                        break;
                }
                equipeRepository.save(equipe);
            }
        }
    }

    public boolean membreDepasseUnAns(Etudiant etudiant){
        List<Contrat> contratList=contratRepository.findAll();
        List<Contrat> contratsEtudiantConcerné=new ArrayList<>();
        for(Contrat contrat:contratList){
            if(contrat.getEtudiant()==etudiant){
                contratsEtudiantConcerné.add(contrat);
            }
        }
        for(Contrat contrat:contratsEtudiantConcerné){
            if (contrat.getArchive()!=true){
                if(ChronoUnit.DAYS.between(contrat.getDatedeb().toInstant(), LocalDate.now())>365){
                    System.out.println("1ans");
                    return true;
                }
            }
        }
        return false;
    }


}
