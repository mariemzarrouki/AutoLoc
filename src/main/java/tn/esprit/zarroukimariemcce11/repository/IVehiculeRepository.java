package tn.esprit.zarroukimariemcce11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.zarroukimariemcce11.domain.Vehicule;

public interface IVehiculeRepository extends JpaRepository<Vehicule, Long> {
}