package com.example.demo.service;

import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    public Client postClient(Client client) throws Exception{
        return clientRepository.save(client);
    }

    public Optional<Client> getClient(int id) throws Exception {
        Optional <Client> cliente = clientRepository.findById(id);
        if (cliente.isEmpty()){
            return null;
        } else {
            return cliente.get()
        }

    }
}
