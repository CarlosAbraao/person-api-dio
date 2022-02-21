package com.carlosdev.personApi.personApi.repository;

import com.carlosdev.personApi.personApi.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
