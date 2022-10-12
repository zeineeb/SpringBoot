
package tn.esprit.spring.entity;
import lombok.*;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table( name ="Etudiant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idEtudiant")
    private Long idEtudiant; // Clé primaire
    private String prenomE;
    private String nomE;
    @Enumerated(EnumType.STRING)
    Option opt ;

// Constructeur et accesseurs (getters) et mutateurs (setters)

    @OneToMany( mappedBy="etudiant")
    private Set<Contrat> contrat;
    @ManyToMany
    private Set<Equipe> equipes;

    @ManyToOne
    Departement departement;

}