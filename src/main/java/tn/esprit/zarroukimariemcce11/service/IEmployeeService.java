package tn.esprit.zarroukimariemcce11.service;

import tn.esprit.zarroukimariemcce11.domain.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee create(Employee employee);
    Employee findById(Long id);
    List<Employee> findAll();
    Employee update(Long id, Employee employee);
    void deleteById(Long id);
}