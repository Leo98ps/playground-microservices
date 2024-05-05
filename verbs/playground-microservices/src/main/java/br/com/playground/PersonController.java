package br.com.playground;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.playground.model.Person;
import br.com.playground.services.PersonServices;

/**
 * Controller for Person.
 */
@RestController
@RequestMapping("/person")
public class PersonController {

	/**
	 * Autowired {@code personServices}.
	 */
	@Autowired
	private PersonServices personServices;

	/**
	 * Returns a list with all the people.
	 * 
	 * @return Returns a list containing all the people.
	 * 
	 * @throws Exception If any other exception occurs.
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findEntityAll() throws Exception {

		return personServices.findEntityAll();
	}

	/**
	 * Returns a person.
	 * 
	 * @param id person ID to search for.
	 * 
	 * @return One person.
	 * 
	 * @throws Exception If any other exception occurs.
	 */
	@GetMapping(value = "/{id}", /* */
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findEntityById(/* */
			@PathVariable(value = "id") long id) throws Exception {

		return personServices.findEntityById(id);
	}

	/**
	 * Create a person.
	 * 
	 * @param person person to be created.
	 * 
	 * @return created person.
	 * 
	 * @throws Exception If any other exception occurs.
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, /* */
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person create(/* */
			@RequestBody Person person) throws Exception {

		return personServices.create(person);
	}

	/**
	 * Update the person.
	 * 
	 * @param person person to be updated.
	 * 
	 * @return updated person.
	 * 
	 * @throws Exception If any other exception occurs.
	 */
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, /* */
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person update(/* */
			@RequestBody Person person) throws Exception {

		return personServices.update(person);
	}

	/**
	 * Delete the person.
	 * 
	 * @param id the ID of the person to be deleted.
	 * 
	 * @return Returns a ResponseEntity with no content(status 204).
	 * 
	 * @throws Exception If any other exception occurs.
	 */
	@DeleteMapping(value = "/{id}", /* */
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delete(/* */
			@PathVariable(value = "id") long id) throws Exception {

		personServices.delete(id);

		return ResponseEntity.noContent().build();
	}
}
