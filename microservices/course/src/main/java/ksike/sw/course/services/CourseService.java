package ksike.sw.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksike.sw.course.dto.StudentDTO;
import ksike.sw.course.dto.SummaryResponse;
import ksike.sw.course.entities.Course;

@Service
public class CourseService implements ICourseService {

    @Autowired
    private ICourseService courseRepository;

    @Autowired
    private IStudentClient studentClient;

    @Override
    public List<Course> findAll() {
        return (List<Course>) this.courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return this.courseRepository.findById(id); // .orElseThrow();
    }

    @Override
    public void save(Course entity) {
        this.courseRepository.save(entity);
    }

    @Override
    public SummaryResponse getSummary(Long idCourse) {

        // get the course
        Course entity = this.courseRepository.findById(idCourse); //.orElse(new Course());

        // call the rest api to get students
        List<StudentDTO> students = this.studentClient.findAllByCourse(idCourse);

        return SummaryResponse.builder()
            .name(entity.getName())
            .teacher(entity.getTeacher())
            .students(students)
            .build();
    }

}
