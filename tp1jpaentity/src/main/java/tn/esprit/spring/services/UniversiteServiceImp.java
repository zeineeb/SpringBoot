package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Universite;
import tn.esprit.spring.repositories.UniversiteRepository;

import java.util.Optional;

@Service
@Slf4j
public class UniversiteServiceImp implements IUniversiteService {

    @Autowired
    UniversiteRepository universiteRepository;

    public Long ajouterUniversite(Universite u) {
        universiteRepository.save(u);
        log.info("Ajouter Universite");
        return u.getIdUniversite();
    }

    @Override
    public Iterable<Universite> retrieveAllUniversite() {return universiteRepository.findAll();}

    @Override
    public Optional< Universite > findUniversiteById(Long id) {
        return universiteRepository.findById(id);
    }

    @Override
    public void deleteUniversite(long id) {
        universiteRepository.deleteById(id);}

    @Override
    public Universite updateUniversite(Universite u) {return universiteRepository.save(u);}

}
