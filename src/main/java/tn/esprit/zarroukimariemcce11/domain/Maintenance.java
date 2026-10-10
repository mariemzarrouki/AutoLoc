package tn.esprit.zarroukimariemcce11.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "maintenance")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaintenance;

    @Column(nullable = false)
    private LocalDate dateDebut;

    private LocalDate dateFin;

    @Column(length = 500)
    private String description;

    // ===== Maintenance → Vehicule (côté propriétaire) =====
    @ManyToOne(fetch = FetchType.LAZY)
    private Vehicule vehicule;
}