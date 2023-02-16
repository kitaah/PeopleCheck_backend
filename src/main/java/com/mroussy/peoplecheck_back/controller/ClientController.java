package com.mroussy.peoplecheck_back.controller;

import com.mroussy.peoplecheck_back.exception.ClientNotFoundException;
import com.mroussy.peoplecheck_back.model.Client;
import com.mroussy.peoplecheck_back.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @PostMapping("/client")
    Client newClient(@RequestBody Client newClient) { return clientRepository.save(newClient);}

    @GetMapping("/clients")
    List<Client> getAllClients() { return clientRepository.findAll();}

    @GetMapping("/client/{id}")
    Client getClientById(@PathVariable Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
    }

    @PutMapping("/client/{id}")
    Client updateClient(@RequestBody Client newClient, @PathVariable Long id){
        return clientRepository.findById(id)
                .map(client -> {
                    client.setFname(newClient.getFname());
                    client.setLname(newClient.getLname());
                    client.setGender(newClient.getGender());
                    client.setAge(newClient.getAge());
                    client.setPhone(newClient.getPhone());
                    client.setEmail(newClient.getEmail());
                    client.setAddress(newClient.getAddress());
                    return clientRepository.save(client);
                }).orElseThrow(() -> new ClientNotFoundException(id));
    }

    @DeleteMapping("client/{id}")
    String deleteClient(@PathVariable Long id){
        if(!clientRepository.existsById(id)) {
            throw new ClientNotFoundException(id);
        }
        clientRepository.deleteById(id);
        return "Le client avec l'id " + id + " a été correctement supprimé.";
    }
}
