package tn.esprit.spring.entity;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table( name ="Departement")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Departement implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idDepartement")
    private Long idDepartement; // Clé primaire

    private String nomDepart;

    @OneToMany( mappedBy="departement")
    private Set<Etudiant> etudiants;

}
