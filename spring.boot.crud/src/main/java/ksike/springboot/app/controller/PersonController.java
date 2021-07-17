package ksike.springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ksike.springboot.app.model.Person;
import ksike.springboot.app.service.PersonService;
/*
import java.util.List;
import ksike.springboot.app.model.Person;
import ksike.springboot.app.repository.PersonRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
*/

// https://spring.io/guides/tutorials/rest/

@RestController
@RequestMapping("/api/person")
@CrossOrigin
class PersonController {

  @Autowired
  private PersonService srvPerson;

  @GetMapping("")
  Iterable<Person> all() {
    return this.srvPerson.findAll();
  }

  @PostMapping("")
  ResponseEntity<?> newPerson(@Validated @RequestBody Person entity) {
      Person obj = this.srvPerson.save(entity);
      return new ResponseEntity<Person>(obj, HttpStatus.CREATED);
  }



  
/*
  PersonController(PersonRepository repository) {
    this.repository = repository;
  }
*/
/*
  @GetMapping("/persons")
  List<Person> all() {
   // return repository.findAll();
  }
  // end::get-aggregate-root[]
/*
  @PostMapping("/Persons")
  Person newPerson(@RequestBody Person newPerson) {
   //return repository.save(newPerson);
  }
*/
  // Single item
  /*
  @GetMapping("/Persons/{id}")
  Person one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new PersonNotFoundException(id));
  }
*/
/*
  @PutMapping("/Persons/{id}")
  Person replacePerson(@RequestBody Person newPerson, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(Person -> {
        Person.set(newPerson.getName());
        Person.setRole(newPerson.getRole());
        return repository.save(Person);
      })
      .orElseGet(() -> {
        newPerson.setId(id);
        return repository.save(newPerson);
      });
  }
**/
/*
  @DeleteMapping("/Persons/{id}")
  void deletePerson(@PathVariable Long id) {
    repository.deleteById(id);
  }*/
}