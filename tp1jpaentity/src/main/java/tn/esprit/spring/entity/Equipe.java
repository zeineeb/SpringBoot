package tn.esprit.spring.entity;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table( name ="Equipe")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Equipe implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idEquipe")
    private Long idEquipe; // Clé primaire

    private String nomEquipe;

    @Enumerated(EnumType.STRING)
    Niveau niveau ;

    @ManyToMany(mappedBy = "equipes")
    private Set<Etudiant> etudiants;

    @OneToOne
    private DetailEquipe detailEquipel;
}
