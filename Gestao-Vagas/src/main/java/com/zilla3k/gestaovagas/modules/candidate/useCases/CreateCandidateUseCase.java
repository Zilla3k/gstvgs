package com.zilla3k.gestaovagas.modules.candidate.useCases;

import com.zilla3k.gestaovagas.exceptions.UserAlreadyExistException;
import com.zilla3k.gestaovagas.modules.candidate.CandidateEntity;
import com.zilla3k.gestaovagas.modules.candidate.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
public class CreateCandidateUseCase {

    private final CandidateRepository candidateRepository;

    public CreateCandidateUseCase(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public CandidateEntity execute(CandidateEntity candidateEntity){
        this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent(user -> {
                    throw new UserAlreadyExistException();
                });

        return this.candidateRepository.save(candidateEntity);
    }
}

