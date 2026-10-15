package tn.esprit.zarroukimariemcce11.service;

import tn.esprit.zarroukimariemcce11.domain.Paiement;

import java.util.List;

public interface IPaiementService {
    Paiement findById(Long id);
    List<Paiement> findAll();
}