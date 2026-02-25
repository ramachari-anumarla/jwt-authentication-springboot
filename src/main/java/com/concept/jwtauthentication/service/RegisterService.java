package com.concept.jwtauthentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.concept.jwtauthentication.dto.RegisterDTO;
import com.concept.jwtauthentication.model.Person;
import com.concept.jwtauthentication.repository.PersonRepository;

@Service
public class RegisterService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String registerPerson(RegisterDTO registerDTO) {
        // Check if the username already exists
        if (personRepository.findByUsername(registerDTO.getUsername()).isPresent()) {
            return "Username already exists!";
        }

        // Create a new Person entity
        Person person = new Person();
        person.setUsername(registerDTO.getUsername());
        person.setPassword(passwordEncoder.encode(registerDTO.getPassword())); // Hash the password
        person.setEmail(registerDTO.getEmail());
        person.setRole("User");

        // Save the user to the database
        personRepository.save(person);

        return "User registered successfully!";
    }
}
