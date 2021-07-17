package ksike.springboot.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ksike.springboot.app.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

  List<Person> findByLastName(String lastName);

  Person findById(long id);
}