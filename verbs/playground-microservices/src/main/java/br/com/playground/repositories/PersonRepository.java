package br.com.playground.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.playground.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {}