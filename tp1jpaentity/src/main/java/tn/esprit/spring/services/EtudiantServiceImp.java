package tn.esprit.spring.services;


import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.repositories.EtudiantRepository;

import java.util.Optional;

@Service
@Slf4j
public class EtudiantServiceImp implements IEtudiantService{

    @Autowired
    EtudiantRepository etudiantRepository;

    public Long ajouter_etudiant(Etudiant e) {
        etudiantRepository.save(e);
        log.info("Ajouter Etudiant");
        return e.getIdEtudiant();
    }

    @Override
    public Iterable<Etudiant> retrieveAllEtudiant() {return etudiantRepository.findAll();}

    @Override
    public Optional< Etudiant > findEtudiantById(Long id) {
        return etudiantRepository.findById(id);
    }

    @Override
    public void deleteEtudiant(long id) {
        etudiantRepository.deleteById(id);}

    @Override
    public Etudiant updateEtudiant(Etudiant e) {return etudiantRepository.save(e);}

}
