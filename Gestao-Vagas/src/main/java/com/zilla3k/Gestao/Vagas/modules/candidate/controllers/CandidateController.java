package com.zilla3k.Gestao.Vagas.modules.candidate.controllers;

import com.zilla3k.Gestao.Vagas.modules.candidate.CandidateEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @PostMapping("")
    public void createCandidate(@Valid @RequestBody CandidateEntity candidateEntity){
        System.out.println("Candidato:");
        System.out.println(candidateEntity.getUsername());
        System.out.println(candidateEntity.getName());
        System.out.println(candidateEntity.getEmail());
        System.out.println(candidateEntity.getBio());
    }

}

