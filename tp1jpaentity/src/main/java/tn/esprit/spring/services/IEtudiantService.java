package tn.esprit.spring.services;

import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Etudiant;

import java.util.Optional;


public interface IEtudiantService {
    public Long ajouter_etudiant(Etudiant e);
    public Iterable<Etudiant> retrieveAllEtudiant();
    Optional< Etudiant > findEtudiantById(Long id);

    public void deleteEtudiant(long id);
    Etudiant updateEtudiant(Etudiant e);
}
