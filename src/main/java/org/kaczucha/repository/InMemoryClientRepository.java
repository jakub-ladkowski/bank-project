package org.kaczucha.repository;

import org.kaczucha.repository.entity.Client;

import java.util.*;

public class InMemoryClientRepository implements ClientRepository {
    private List<Client> clients;

     public InMemoryClientRepository(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public void save(Client client) {
        clients.add(client);
    }

    @Override
    public Client findByEmail(String email) {
        return clients
                .stream()
                .filter(client -> Objects.equals(client.getEmail(), email))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Client with following email: %snot found".formatted(email)));
    }
}
