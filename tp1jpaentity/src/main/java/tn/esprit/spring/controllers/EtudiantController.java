package tn.esprit.spring.controllers;


import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.services.IEtudiantService;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/EtudiantC")
public class EtudiantController {
@Autowired
IEtudiantService etudiantService;

    // http://localhost:8089/Etudiant/add-Etudiant
    //{prenomE:"Ali", nomE:"Ali"}
    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }
    @PostMapping("/addEtudiant")
    @ResponseBody
    public void addEtudiant(@RequestBody Etudiant etudiant) {
        etudiantService.ajouter_etudiant(etudiant);
    }

}



