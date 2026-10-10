package tn.esprit.zarroukimariemcce11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.zarroukimariemcce11.domain.Agence;

public interface IAgenceRepository extends JpaRepository<Agence, Long> {
}