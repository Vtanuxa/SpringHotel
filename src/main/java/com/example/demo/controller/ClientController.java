package com.example.demo.controller;

import com.example.demo.entity.Client;
import com.example.demo.repository.ClientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClientController {
    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/add-client")
    public String showAddClient(Model model) {
        model.addAttribute("client", new Client());
        return "add-client";
    }
    @PostMapping("/add-client")
    public String addClient(@ModelAttribute Client client) {
        clientRepository.save(client);
        return "redirect:/clients";
    }
    @GetMapping("/clients")
    public String showClients(Model model) {
        List<Client> clientList = clientRepository.findAll();
        model.addAttribute("clientList", clientList);
        return  "client-list";
    }
    @GetMapping("/delete-client/{id}")
    public String deleteRoom(@PathVariable Long id) {
        clientRepository.deleteById(id);
        return "redirect:/clients";
    }
    @GetMapping("/edit-client/{id}")
    public String updateClient(@PathVariable Long id, Model model) {
        Client client = clientRepository.findById(id).orElseThrow();
        model.addAttribute("client", client);
        return "edit-client";
    }
    @PostMapping("/edit-client/{id}")
    public String updateClient(@PathVariable Long id, @ModelAttribute Client updateclient) {
        Client client = clientRepository.findById(id).orElseThrow();
        client.setFullName(updateclient.getFullName());
        client.setPhone(updateclient.getPhone());
        client.setEmail(updateclient.getEmail());
        client.setPassport(updateclient.getPassport());
        clientRepository.save(client);
        return "redirect:/clients";
    }
}
