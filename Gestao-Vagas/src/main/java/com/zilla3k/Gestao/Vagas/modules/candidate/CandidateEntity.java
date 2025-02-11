package com.zilla3k.Gestao.Vagas.modules.candidate;

import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

@Data
public class CandidateEntity {
    private UUID id;
    private String name;

    @Email(message = "Format invalid!")
    private String email;

    @Pattern(regexp = "\\S+", message = "Format invalid!")
    private String username;

    @Length(min = 8, max = 100, message = "Minimum 8 character is required!")
    private String password;
    private String bio;
    private String curriculum;

}
