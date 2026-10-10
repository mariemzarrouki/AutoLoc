package tn.esprit.zarroukimariemcce11.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "vehicule")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicule;

    @Column(nullable = false, unique = true, length = 20)
    private String immatriculation;

    @Column(nullable = false, length = 50)
    private String marque;

    @Column(nullable = false, length = 50)
    private String modele;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private CategorieVehicule categorie;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal tarifJournalier;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatutVehicule statut;

    // ===== Vehicule → Agence (côté propriétaire) =====
    @ManyToOne(fetch = FetchType.LAZY)
    private Agence agence;

    // ===== Vehicule → Reservation (côté inverse) =====
    @OneToMany(mappedBy = "vehicule", fetch = FetchType.LAZY)
    private List<Reservation> reservations = new ArrayList<>();

    // ===== Vehicule → Maintenance (côté inverse, cascade PERSIST) =====
    @OneToMany(mappedBy = "vehicule",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY)
    private List<Maintenance> maintenances = new ArrayList<>();

    // ===== Vehicule ↔ Equipement (ManyToMany, côté propriétaire) =====
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "vehicule_equipement",
            joinColumns = @JoinColumn(name = "id_vehicule"),
            inverseJoinColumns = @JoinColumn(name = "id_equipement")
    )
    private Set<Equipement> equipements = new HashSet<>();
}