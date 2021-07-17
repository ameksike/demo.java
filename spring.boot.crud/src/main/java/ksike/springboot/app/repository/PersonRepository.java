package ksike.springboot.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ksike.springboot.app.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

  public List<Person> findByLastName(String lastName);

}