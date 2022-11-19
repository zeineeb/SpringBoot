package tn.esprit.spring.repositories;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.spring.entity.Universite;

import java.util.List;
import java.util.Optional;


public interface UniversiteRepository  extends JpaRepository<Universite, Long> {
   Universite  findByEmail(String email);


}
