package tn.esprit.spring.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import tn.esprit.spring.entity.Offre;


public interface OffreRepository extends JpaRepository<Offre, Long> {



}
