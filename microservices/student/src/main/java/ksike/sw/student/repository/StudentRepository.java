package ksike.sw.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ksike.sw.student.entities.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    @Query("SELECT s FROM Student AS s WHERE s.courseId = :idCourse")
    List<Student> findAllByCourse(Long idCourse);

    List<Student> findAllByCourseId(Long idCourse);
}
