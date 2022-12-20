package tn.esprit.spring.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.spring.entity.Offre;
import tn.esprit.spring.entity.Partenaire;

import java.util.List;


public interface OffreRepository extends JpaRepository<Offre, Long> {
    @Query("SELECT o FROM Offre o WHERE o.nomOffre LIKE %?1%"
            + " OR o.descriptionOffre LIKE %?1%"
            + " OR o.typeOffre LIKE %?1%"

    )
    public List<Offre> search(String keyword);


}
