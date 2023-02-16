package com.mroussy.peoplecheck_back.repository;

import com.mroussy.peoplecheck_back.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
