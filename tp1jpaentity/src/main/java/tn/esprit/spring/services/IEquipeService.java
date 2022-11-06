package tn.esprit.spring.services;

import tn.esprit.spring.entity.Equipe;

import java.util.Optional;

public interface IEquipeService {

    public Long ajouterEquipe(Equipe e);
    public Iterable<Equipe> retrieveAllEquipe();
    Optional< Equipe > findEquipeById(Long id);
    public void deleteEquipe(long id);
    Equipe updateEquipe(Equipe e);
}
