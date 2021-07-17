package ksike.springboot.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksike.springboot.app.model.Person;
import ksike.springboot.app.repository.PersonRepository;

@Service
public class PersonService {
    @Autowired
    private PersonRepository rpyPerson;

    public Person save(Person entity) {
        return this.rpyPerson.save(entity);
    }

    public Iterable<Person> findAll() {
        return this.rpyPerson.findAll();
    }

    public Person findById(Long id) {
        Optional<Person> op = this.rpyPerson.findById(id);
        return op.get();
    }

    public Person store(Person entity, Long id) {
        return this.rpyPerson.findById(id).map(obj -> {
            if (entity.getFirstName() != "" && entity.getFirstName() != null) {
                obj.setFirstName(entity.getFirstName());
            }
            if (entity.getLastName() != "" && entity.getLastName() != null) {
                obj.setLastName(entity.getLastName());
            }
            return this.rpyPerson.save(obj);
        }).orElseGet(() -> {
            return this.rpyPerson.save(entity);
        });
    }

    public void deleteById(Long id) {
        this.rpyPerson.deleteById(id);
    }
}