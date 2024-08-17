package ksike.sw.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksike.sw.course.entities.Course;

@Service
public class CourseService implements ICourseService {

    @Autowired
    private ICourseService courseRepository;

    @Override
    public List<Course> findAll() {
        return (List<Course>) this.courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return this.courseRepository.findById(id); //.orElseThrow();
    }

    @Override
    public void save(Course entity) {
        this.courseRepository.save(entity);
    }

}
