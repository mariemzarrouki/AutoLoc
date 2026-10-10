package tn.esprit.zarroukimariemcce11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.zarroukimariemcce11.domain.Paiement;

public interface IPaiementRepository extends JpaRepository<Paiement, Long> {
}