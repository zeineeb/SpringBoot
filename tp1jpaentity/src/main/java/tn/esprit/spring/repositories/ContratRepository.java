package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Etudiant;

public interface ContratRepository  extends JpaRepository<Contrat, Long> {
}
