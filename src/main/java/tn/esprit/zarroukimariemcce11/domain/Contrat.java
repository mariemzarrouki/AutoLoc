package tn.esprit.zarroukimariemcce11.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contrat")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;

    @Column(nullable = false)
    private LocalDate dateSignature;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal montantTotal;

    @Column(nullable = false)
    private Boolean valide;

    // ===== Contrat → Paiement (côté inverse, composition) =====
    @OneToMany(mappedBy = "contrat",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<Paiement> paiements = new ArrayList<>();

    // ===== Contrat ↔ Reservation (OneToOne, côté propriétaire) =====
    @OneToOne(fetch = FetchType.LAZY)
    private Reservation reservation;
}