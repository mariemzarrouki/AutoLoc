# Atelier 2 — Stratégies de Fetch & Cascade

## Contrat ↔ Paiement
- Type : @OneToMany / @ManyToOne (bidirectionnel)
- Côté propriétaire : Paiement (colonne `contrat_id_contrat`)
- Fetch : LAZY
- Cascade : ALL
- orphanRemoval : true
- Justification : composition — un paiement n'existe pas sans contrat.

## Reservation ↔ Contrat
- Type : @OneToOne (bidirectionnel)
- Côté propriétaire : Contrat (colonne `reservation_id_reservation`)
- Fetch : LAZY
- Cascade : ALL côté Reservation

## Agence → Vehicule
- Type : @OneToMany / @ManyToOne
- Côté propriétaire : Vehicule (colonne `agence_id_agence`)
- Fetch : LAZY | Cascade : Aucune

## Agence → Employee
- Type : @OneToMany / @ManyToOne
- Côté propriétaire : Employee (colonne `agence_id_agence`)
- Fetch : LAZY | Cascade : Aucune

## Vehicule ↔ Equipement
- Type : @ManyToMany
- Côté propriétaire : Vehicule (table `vehicule_equipement`)
- Fetch : LAZY | Cascade : Aucune | Collection : Set

## Client → Reservation
- Type : @OneToMany / @ManyToOne
- Côté propriétaire : Reservation (colonne `client_id_client`)
- Fetch : LAZY | Cascade : PERSIST

## Reservation → Vehicule
- Type : @ManyToOne
- Côté propriétaire : Reservation (colonne `vehicule_id_vehicule`)
- Fetch : LAZY | Cascade : Aucune

## Vehicule → Maintenance
- Type : @OneToMany / @ManyToOne
- Côté propriétaire : Maintenance (colonne `vehicule_id_vehicule`)
- Fetch : LAZY | Cascade : PERSIST