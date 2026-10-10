package tn.esprit.zarroukimariemcce11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.zarroukimariemcce11.domain.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
}