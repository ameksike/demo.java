package ksike.sw.course.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ksike.sw.course.entities.Course;

@Repository
public interface ICourseRepository extends CrudRepository<Course, Long>{
    
}
