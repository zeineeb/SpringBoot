package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Contrat;

import tn.esprit.spring.repositories.ContratRepository;

import java.util.Optional;
@Service
@Slf4j
public class ContratServiceImp implements IContratService{

    @Autowired
    ContratRepository contratRepository;

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


}
