package ksike.springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ksike.springboot.app.model.Person;
import ksike.springboot.app.service.PersonService;

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

  @GetMapping("/{id}")
  ResponseEntity<?> select(@PathVariable Long id) {
    Person obj = this.srvPerson.findById(id);
    return new ResponseEntity<Person>(obj, HttpStatus.OK);
  }

  @PostMapping("")
  ResponseEntity<?> insert(@Validated @RequestBody Person entity) {
    Person obj = this.srvPerson.save(entity);
    return new ResponseEntity<Person>(obj, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  ResponseEntity<?> update(@Validated @RequestBody Person entity, @PathVariable Long id) {
    Person obj = this.srvPerson.store(entity, id);
    return new ResponseEntity<Person>(obj, HttpStatus.GONE);
  }

  @DeleteMapping("/{id}")
  void delete(@PathVariable Long id) {
    this.srvPerson.deleteById(id);
  }

}