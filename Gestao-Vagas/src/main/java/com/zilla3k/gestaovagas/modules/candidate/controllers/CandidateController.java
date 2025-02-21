package com.zilla3k.gestaovagas.modules.candidate.controllers;

import com.zilla3k.gestaovagas.exceptions.UserAlreadyExistException;
import com.zilla3k.gestaovagas.modules.candidate.CandidateEntity;
import com.zilla3k.gestaovagas.modules.candidate.useCases.CreateCandidateUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    private final CreateCandidateUseCase createCandidateUseCase;

    public CandidateController(CreateCandidateUseCase createCandidateUseCase) {
        this.createCandidateUseCase = createCandidateUseCase;
    }

    @PostMapping("")
    public ResponseEntity<Object> createCandidate(@Valid @RequestBody CandidateEntity candidateEntity) {
        try{
           var result = this.createCandidateUseCase.execute(candidateEntity);
           return ResponseEntity.ok().body(result);
        }catch (Exception e){
           return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

