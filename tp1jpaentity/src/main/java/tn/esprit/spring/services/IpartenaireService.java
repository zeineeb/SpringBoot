package tn.esprit.spring.services;
import tn.esprit.spring.entity.Partenaire;

import java.util.List;
import java.util.Map;

public interface IpartenaireService
{

    public Long ajouterPartenaire(Partenaire p);
    public Iterable<Partenaire> retrieveAllPartenaire();
    Partenaire retrievePartenaire(Long idPartenaire);

    public void deletePartenaire(Long id);
    Partenaire updatePartenaire(Partenaire p);
    public void assignPartenaireToUniversite( Long idPartenaire, Long idUniversite);
    public Map<String, Integer> statistiquePartenaire();
    public List<Partenaire> search(String keyword);

}
