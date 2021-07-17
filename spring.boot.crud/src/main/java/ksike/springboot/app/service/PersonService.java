package ksike.springboot.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksike.springboot.app.model.Person;
import ksike.springboot.app.repository.PersonRepository;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person save(Person entity){
        return this.personRepository.save(entity);
    }

    public Iterable<Person> findAll(){
        return this.personRepository.findAll();
    }
}