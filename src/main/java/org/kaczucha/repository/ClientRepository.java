package org.kaczucha.repository;

import org.kaczucha.repository.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {

//    @Query("SELECT c FROM Client c where c.email= :email")
    Client findByEmail(String email);

    List<Client> findByName(String name);
    Page<Client> findByName(String name, Pageable pageable);
}
