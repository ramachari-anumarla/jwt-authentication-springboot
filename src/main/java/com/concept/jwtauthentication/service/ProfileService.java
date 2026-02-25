package com.concept.jwtauthentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concept.jwtauthentication.dto.ProfileDTO;
import com.concept.jwtauthentication.model.Person;
import com.concept.jwtauthentication.repository.PersonRepository;

@Service
public class ProfileService {

    @Autowired
    private PersonRepository personRepository;

    public ProfileDTO getProfile(String username) {
        try {
            Person person = personRepository.findByUsername(username)
                    .orElseThrow(() -> new RuntimeException("User not found with username: " + username));

            ProfileDTO profileDTO = new ProfileDTO(person.getUsername(), person.getEmail());
            return profileDTO;

        } catch (Exception e) {
            throw new RuntimeException("Error fetching profile: " + e.getMessage(), e);
        }
    }
}