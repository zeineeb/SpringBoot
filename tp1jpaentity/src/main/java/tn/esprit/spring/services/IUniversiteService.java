package tn.esprit.spring.services;
import tn.esprit.spring.entity.Universite;

import java.util.Optional;

public interface IUniversiteService {

    public Long ajouterUniversite(Universite u);
    public Iterable<Universite> retrieveAllUniversite();
    Optional< Universite > findUniversiteById(Long id);
    public void deleteUniversite(long id);
    Universite updateUniversite(Universite u);
}
