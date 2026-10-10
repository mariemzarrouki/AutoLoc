package tn.esprit.zarroukimariemcce11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.zarroukimariemcce11.domain.Equipement;

public interface IEquipementRepository extends JpaRepository<Equipement, Long> {
}