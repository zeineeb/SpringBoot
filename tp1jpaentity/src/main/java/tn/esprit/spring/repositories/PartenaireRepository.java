package tn.esprit.spring.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.spring.entity.Partenaire;

import java.util.List;

public interface PartenaireRepository extends JpaRepository<Partenaire, Long> {
    @Query("SELECT p FROM Partenaire p WHERE p.nomPartenaire LIKE %?1%"
            + " OR p.localisation LIKE %?1%"
            + " OR p.email LIKE %?1%"
            + " OR CONCAT(p.support, '') LIKE %?1%"
            + " OR CONCAT(p.numTelPar, '') LIKE %?1%"
    )
    public List<Partenaire> search(String keyword);

    @Query("select  u.nomUniv, COUNT(p) from Universite u join Partenaire p on u=p.universites group by u.nomUniv  ")
    List<String> stats();
   Partenaire findByEmail(String email);

}
