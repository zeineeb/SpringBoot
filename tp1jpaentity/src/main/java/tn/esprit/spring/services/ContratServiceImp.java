package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Contrat;

import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.repositories.ContratRepository;
import tn.esprit.spring.repositories.EtudiantRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class ContratServiceImp implements IContratService{

    @Autowired
    ContratRepository contratRepository;
    @Autowired
    EtudiantRepository etudiantRepository;

    public Long ajouter_contrat(Contrat c) {
        contratRepository.save(c);
        log.info("Ajouter Etudiant");
        return c.getIdContrat();
    }

    @Override
    public Iterable<Contrat> retrieveAllContrat() {return contratRepository.findAll();}

    @Override
    public Optional< Contrat > findContratById(Long id) {
        return contratRepository.findById(id);
    }

    @Override
    public void deleteContrat(long id) {
        contratRepository.deleteById(id);}

    @Override
    public Contrat updateContrat(Contrat c) {return contratRepository.save(c);}
    @Override
    public Contrat retrieveContrat(Long idContrat) {
        return contratRepository.findById(idContrat).get();
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        Etudiant etudiant = etudiantRepository.findByNomEAndPrenomE(nomE, prenomE);
        if (etudiant != null) {
            int nombreContratActif = 0;
            for (Contrat contrat : etudiant.getContrat()) {
                if (contrat.getArchive() == true)
                    nombreContratActif++;
            }
            if (nombreContratActif < 5) {
                ce.setEtudiant(etudiant);
                ce.setArchive(true);
                updateContrat(ce);
            }
        }
        return ce;
    }

@Override
public float getChiffreAffaireEntreDeuxDate1(Date startDate, Date endDate){
        return  contratRepository.getcontratmontantBetween(startDate,endDate);
}


    @Override
    // @Scheduled(cron = "0 0 1 ? * *")
    public void retrieveAndUpdateStatusContrat() {
        List<Contrat> C = contratRepository.findAll();
        LocalDate localDate = LocalDate.now();
        for (int d=0 ; d<C.size() ; d++){
            Contrat S=  C.get(d);
            long diff=localDate.getDayOfMonth()-S.getDatefin().getTime();
            long diffs = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            if (diffs<=0){
                log.info("Contrat "+ LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
                S.setArchive(true);
                contratRepository.save(S);}
            else if (diffs <=15){
                log.info("Contrat expirer "+ LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
            }
        }
    }

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        int j = 0;

        List<Contrat> contrat = contratRepository.findAll();

        for (int i = 0; i < contrat.size(); i++) {
            Contrat ct = contrat.get(i);

            if (ct.getArchive() == false) {
                j++;
            }
        }
        return j;
    }

    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        float CA = 0;
        List<Contrat> contrats = contratRepository.getContratByDate(startDate, endDate);
        for (int i=0 ; i<contrats.size() ; i++){
            Contrat ct= contrats.get(i);
            if (ct.getSpecialite().toString()=="IA"){
                int dd = Integer.parseInt(ct.getDatedeb().toString().substring(5,7));
                int df = Integer.parseInt(ct.getDatefin().toString().substring(5,7));
                CA += ((df-dd)*300);
            } else if (ct.getSpecialite().toString()=="RESEAU") {
                int dd = Integer.parseInt(ct.getDatedeb().toString().substring(5,7));
                int df = Integer.parseInt(ct.getDatefin().toString().substring(5,7));
                CA += ((df-dd)*350);
            } else if (ct.getSpecialite().toString()=="CLOUD") {
                int dd = Integer.parseInt(ct.getDatedeb().toString().substring(5,7));
                int df = Integer.parseInt(ct.getDatefin().toString().substring(5,7));
                CA += ((df-dd)*400);
            } else if (ct.getSpecialite().toString()=="SECURITE") {
                int dd = Integer.parseInt(ct.getDatedeb().toString().substring(5,7));
                int df = Integer.parseInt(ct.getDatefin().toString().substring(5,7));
                CA += ((df-dd)*450);
            } else {
                return CA;
            }
        }
        return CA;
    }

}
