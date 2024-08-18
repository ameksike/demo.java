package ksike.sw.course.services;

import java.util.List;

import ksike.sw.course.dto.SummaryResponse;
import ksike.sw.course.entities.Course;


public interface ICourseService {

    List<Course> findAll();

    Course findById(Long id);

    void save(Course entity);

    SummaryResponse getSummary(Long idCourse);

}
