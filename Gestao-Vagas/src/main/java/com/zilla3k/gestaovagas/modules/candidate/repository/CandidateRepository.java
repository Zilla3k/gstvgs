package com.zilla3k.gestaovagas.modules.candidate.repository;

import java.util.Optional;
import com.zilla3k.gestaovagas.modules.candidate.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {
    @Query("SELECT c FROM candidate c WHERE c.username = :username OR c.email = :email")
    Optional<CandidateEntity> findByUsernameOrEmail(@Param("username") String username, @Param("email") String email);
}

