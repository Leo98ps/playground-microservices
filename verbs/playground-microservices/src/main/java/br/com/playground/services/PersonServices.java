package br.com.playground.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.playground.exceptions.ResourceNotFoundException;
import br.com.playground.model.Person;
import br.com.playground.repositories.PersonRepository;

/**
 * Services {@code Person}.
 */
@Service
public class PersonServices {

	/**
	 * Autowired {@code personRepository}.
	 */
	@Autowired
	public PersonRepository repository;

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	/**
	 * Create a person.
	 * 
	 * @param person person to be created.
	 * 
	 * @return created person.
	 */
	public Person create(Person person) {
		logger.info("Creating one person!");

		return repository.save(person);
	}

	/**
	 * Update the person.
	 * 
	 * @param person person to be updated.
	 * 
	 * @return updated person.
	 */
	public Person update(Person person) {
		logger.info("Updating one person!");

		Person entity = repository.findById(person.getID())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		return repository.save(entity);
	}

	/**
	 * Delete the person.
	 * 
	 * @param id the ID of the person to be deleted.
	 */
	public void delete(Long id) {
		logger.info("Deleting one person!");

		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

		repository.delete(entity);
	}

	/**
	 * Returns a list with all the people.
	 * 
	 * @return Returns a list containing all the people.
	 */
	public List<Person> findEntityAll() {
		logger.info("Finding all persons!");

		return repository.findAll();
	}

	/**
	 * Returns a person.
	 * 
	 * @param id person ID to search for.
	 * 
	 * @return One person.
	 */
	public Person findEntityById(long id) {
		logger.info("Finding one person!");

		return repository.findById(id)
				/* */.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
	}
}
