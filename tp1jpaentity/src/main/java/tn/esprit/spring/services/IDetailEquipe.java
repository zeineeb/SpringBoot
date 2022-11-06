package tn.esprit.spring.services;

import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.DetailEquipe;

import java.util.Optional;

public interface IDetailEquipe {

    public Long ajouterDetailEquipe(DetailEquipe d);
    public Iterable<DetailEquipe> retrieveAllDetailEquipe();
    Optional< DetailEquipe > findDetailEquipeById(Long id);
    public void deleteDetailEquipe(long id);
    DetailEquipe updateDetailEquipe(DetailEquipe d);

}
