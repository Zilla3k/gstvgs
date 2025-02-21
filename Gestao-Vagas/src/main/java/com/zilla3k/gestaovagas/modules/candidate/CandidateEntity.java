package com.zilla3k.gestaovagas.modules.candidate;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

@Data
@Entity(name = "candidate")
public class CandidateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;

    @Email(message = "Format invalid!")
    private String email;

    @Pattern(regexp = "\\S+", message = "Format invalid!")
    private String username;

    @Length(min = 7, max = 100, message = "Minimum 8 character is required!")
    private String password;
    private String bio;
    private String curriculum;

    @CreationTimestamp
    private LocalDate createdAt;
}