package tn.esprit.spring.repositories;

import org.hibernate.sql.Select;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.spring.entity.Partenaire;
import tn.esprit.spring.entity.Universite;

import java.util.List;
import java.util.Optional;


public interface UniversiteRepository  extends JpaRepository<Universite, Long> {
   Universite  findByEmail(String email);
   @Query("SELECT u FROM Universite u WHERE u.nomUniv LIKE %?1%"
           + " OR u.email LIKE %?1%"
   )
   public List<Universite> search(String keyword);


}
