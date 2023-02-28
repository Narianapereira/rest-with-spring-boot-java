package br.com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

@Service
public class PersonServices {
	
	private AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<>();
		for(int i=0; i<8;i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}
	private Person mockPerson(int i) {
		
		logger.info("Finding all people");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name" + i);
		person.setLastName("Last name" + i);
		person.setAddress("Some place in Brasil" + i);
		person.setGender("Male");
		return person;		
	}
	
	public Person findById(String id) {
		
		logger.info("Finding one Person");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Nariana");
		person.setLastName("Pereira");
		person.setAddress("Santa Catarina - Brasil");
		person.setGender("Male");
		return person;
	}
	
	public Person create(Person person) {
		
		logger.info("Creating one Person");

		return person;
	}
	
    public Person update(Person person) {
		
		logger.info("Update one Person");

		return person;
	}
    
    public void delete(String id) {
		
		logger.info("Deleting one Person");

	}

}
