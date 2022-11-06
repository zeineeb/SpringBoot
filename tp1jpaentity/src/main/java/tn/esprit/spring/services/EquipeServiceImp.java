package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Equipe;
import tn.esprit.spring.repositories.EquipeRepository;

import java.util.Optional;

@Service
@Slf4j
public class EquipeServiceImp implements IEquipeService{

    @Autowired
    EquipeRepository equipeRepository;

    public Long ajouterEquipe(Equipe e) {
        equipeRepository.save(e);
        log.info("Ajouter Equipe");
        return e.getIdEquipe();
    }

    @Override
    public Iterable<Equipe> retrieveAllEquipe() {return equipeRepository.findAll();}

    @Override
    public Optional< Equipe > findEquipeById(Long id) {
        return equipeRepository.findById(id);
    }

    @Override
    public void deleteEquipe(long id) {
        equipeRepository.deleteById(id);}

    @Override
    public Equipe updateEquipe(Equipe e) {return equipeRepository.save(e);}

}
