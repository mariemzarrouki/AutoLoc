package tn.esprit.zarroukimariemcce11.service;

import tn.esprit.zarroukimariemcce11.domain.Client;

import java.util.List;

public interface IClientService {
    Client create(Client client);
    Client findById(Long id);
    List<Client> findAll();
    Client update(Long id, Client client);
    void deleteById(Long id);
}