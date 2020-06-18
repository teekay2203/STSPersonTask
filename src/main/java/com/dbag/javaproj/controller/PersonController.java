package com.dbag.javaproj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbag.javaproj.databaserepository.PersonDatabaseRepo;
import com.dbag.javaproj.exception.ResourceNotFoundException;
import com.dbag.javaproj.model.Person;

@RestController
@RequestMapping("/api/vi/")
public class PersonController {
	
	@Autowired
	private PersonDatabaseRepo persondbrepo;
	//@RequestMapping("/")
	
	//get person
	
	@GetMapping("person")	
	public List<Person> getAllPerson(){
		
		return this.persondbrepo.findAll();
	}
	
	//get person by ID
	@GetMapping("/person/{id}")
	public ResponseEntity <Person> getPersonById(@PathVariable(value = "id") Long personId)
			throws ResourceNotFoundException {
		Person person = persondbrepo.findById(personId).
				orElseThrow(() -> new ResourceNotFoundException("person is not existing with this id :"
						+ personId));
		return ResponseEntity.ok().body(person);
	}
		
	//Save and Update peson
	@PostMapping("person")
	public Person createPerson(@RequestBody Person person)
	{
		PersonController pc;
		return this.persondbrepo.save(person);
	}

		
	//update Person
	@PutMapping("/person/{id}")
	public ResponseEntity<Person> updateAndSavePerson(@PathVariable(value = "id") Long personId,
			@Validated @RequestBody Person personData)throws ResourceNotFoundException
	{
		Person person = persondbrepo.findById(personId).
				orElseThrow(() -> new ResourceNotFoundException("person is not existing with this id :"
						+ personId));
		person.setId(personData.getId());
		person.setFirstName(personData.getFirstName());
		person.setLastName(personData.getLastName());
		person.setCompDept(personData.getCompDept());
		person.setOfcLocation(personData.getOfcLocation());
		person.setProjWorking(personData.getProjWorking());
		person.setSocialSecNumber(personData.getSocialSecNumber());
		return ResponseEntity.ok(this.persondbrepo.save(person));
	}
	
	//delete employee
	@DeleteMapping("/person/{id}")
	public Map<String,Boolean> deletePerson(@PathVariable(value = "id") Long personId)
			throws ResourceNotFoundException{
		
		Person person = persondbrepo.findById(personId).
				orElseThrow(() -> new ResourceNotFoundException("person is not existing with this id :"
						+ personId));
		this.persondbrepo.delete(person);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return response;
		
	}
	
}
